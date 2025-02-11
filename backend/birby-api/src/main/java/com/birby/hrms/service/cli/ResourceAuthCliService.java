package com.birby.hrms.service.cli;

import com.birby.hrms.dto.response.AuthResCliDto;
import org.springframework.web.bind.annotation.RequestHeader;

public interface ResourceAuthCliService {
    AuthResCliDto getAuthData(String bearer);
}
