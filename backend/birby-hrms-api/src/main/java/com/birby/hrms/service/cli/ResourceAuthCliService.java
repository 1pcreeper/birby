package com.birby.hrms.service.cli;

import com.birby.hrms.dto.response.ResourceAuthResCliDto;

public interface ResourceAuthCliService {
    ResourceAuthResCliDto getAuthData(String bearer);
}
