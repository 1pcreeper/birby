package com.birby.hrms_api.app.service.entity.impl;

import com.birby.hrms_api.app.model.clidto.res.AccountStaffResCliDto;
import com.birby.hrms_api.app.model.exception.ClientServiceException;
import com.birby.hrms_api.app.model.exception.ResourceNotFoundException;
import com.birby.hrms_api.app.model.entity.Staff;
import com.birby.hrms_api.app.repository.StaffRepository;
import com.birby.hrms_api.app.service.client.AccountStaffClientService;
import com.birby.hrms_api.app.service.entity.StaffEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffEntityServiceImpl implements StaffEntityService {
    private final StaffRepository staffRepository;
    private final AccountStaffClientService accountStaffClientService;

    @Autowired
    public StaffEntityServiceImpl(
            StaffRepository staffRepository,
            AccountStaffClientService accountStaffClientService
    ) {
        this.staffRepository = staffRepository;
        this.accountStaffClientService = accountStaffClientService;
    }

    @Override
    @Cacheable(value = "staffs", key = "#id")
    public Staff findById(String id) throws ResourceNotFoundException {
        Optional<Staff> staffOptional = staffRepository.findById(id);
        if(!staffOptional.isEmpty()){
            return staffOptional.get();
        }
        try{
            AccountStaffResCliDto resCliDto =  accountStaffClientService.getStaff(id);
            return save(Staff.builder()
                    .id(resCliDto.getId())
                    .uid(resCliDto.getUid())
                    .build());
        }catch (ClientServiceException e){
            throw new ResourceNotFoundException("StaffId Not Found");
        }
    }

    @Override
    @CachePut(value = "staffs", key = "#staff.id")
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    @CacheEvict(value = "staffs", key = "#id")
    public void delete(String id) {
        staffRepository.deleteById(id);
    }
}
