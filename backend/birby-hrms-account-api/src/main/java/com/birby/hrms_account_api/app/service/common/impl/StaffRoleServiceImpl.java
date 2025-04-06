package com.birby.hrms_account_api.app.service.common.impl;

import com.birby.hrms_account_api.app.constant.KafkaTopics;
import com.birby.hrms_account_api.app.model.eto.req.RevokeV1ReqETO;
import com.birby.hrms_account_api.app.model.dto.res.StaffRoleIdsV1ResDTO;
import com.birby.hrms_account_api.app.model.exception.DatabaseUpdateFailureException;
import com.birby.hrms_account_api.app.model.exception.ResourceNotFoundException;
import com.birby.hrms_account_api.app.component.mapper.StaffRoleMapper;
import com.birby.hrms_account_api.app.model.entity.Staff;
import com.birby.hrms_account_api.app.model.entity.StaffRole;
import com.birby.hrms_account_api.app.service.auth.FirebaseAuthService;
import com.birby.hrms_account_api.app.service.kafka.producer.KafkaProducerService;
import com.birby.hrms_account_api.app.service.entity.RoleEntityService;
import com.birby.hrms_account_api.app.service.entity.StaffEntityService;
import com.birby.hrms_account_api.app.service.entity.StaffRoleEntityService;
import com.birby.hrms_account_api.app.service.manager.BloomFilterManagerService;
import com.birby.hrms_account_api.app.service.common.StaffRoleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StaffRoleServiceImpl implements StaffRoleService {
    private final StaffRoleEntityService staffRoleEntityService;
    private final FirebaseAuthService firebaseAuthService;
    private final StaffEntityService staffEntityService;
    private final StaffRoleMapper staffRoleMapper;
    private final BloomFilterManagerService bloomFilterManagerService;
    private final RoleEntityService roleEntityService;
    private final KafkaProducerService kafkaProducerService;
    @Autowired
    public StaffRoleServiceImpl(
            StaffRoleEntityService staffRoleEntityService,
            FirebaseAuthService firebaseAuthService,
            StaffEntityService staffEntityService,
            StaffRoleMapper staffRoleMapper,
            BloomFilterManagerService bloomFilterManagerService,
            RoleEntityService roleEntityService,
            KafkaProducerService kafkaProducerService
    ) {
        this.staffRoleEntityService = staffRoleEntityService;
        this.firebaseAuthService = firebaseAuthService;
        this.staffEntityService = staffEntityService;
        this.staffRoleMapper = staffRoleMapper;
        this.bloomFilterManagerService = bloomFilterManagerService;
        this.roleEntityService = roleEntityService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Override
    @Transactional
    public void setStaffRolesV1(String staffId, List<String> roleIds,String token)
            throws ResourceNotFoundException, FirebaseAuthException , DatabaseUpdateFailureException {
        Staff staff = staffEntityService.findById(staffId);
        List<StaffRole> staffRoles = staffRoleEntityService.findByStaffId(staff.getId());
        List<String> currentRoleIds = staffRoles.stream().map(sr->sr.getRole().getId()).collect(Collectors.toList());
        System.out.println(currentRoleIds);
        staffRoleEntityService.deleteAll(staffRoles);
        for(String roleId : roleIds){
            roleEntityService.findById(roleId);
            staffRoleEntityService.insert(staff.getId(),roleId);
        }
        firebaseAuthService.setClaims(staff.getUid(),roleIds,staff.getId());
        bloomFilterManagerService.addBloom(
                staff.getUid(),
                currentRoleIds
        );
        RevokeV1ReqETO revokeV1ReqETO =  RevokeV1ReqETO.builder()
                .uid(staff.getUid())
                .roleIds(currentRoleIds)
                .build();
        try{
            kafkaProducerService.sendMessage(KafkaTopics.REVOKE_ROLE, revokeV1ReqETO);
       } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        log.debug("revoke-role sent");
    }

    @Override
    public StaffRoleIdsV1ResDTO getStaffRolesByUidV1(String uid) {
        Staff staff = staffEntityService.findByUid(uid);
        List<StaffRole> staffRoles = staffRoleEntityService.findByStaffId(staff.getId());
        return staffRoleMapper.toStaffRoleIdsResDto(staff,staffRoles);
    }
}
