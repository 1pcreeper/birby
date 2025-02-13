package com.birby.hrms.service.cli;

import com.birby.hrms.bo.response.ResourceAuthResCliBo;

public interface ResourceAuthCliService {
    ResourceAuthResCliBo getAuthData(String bearer);
}
