package com.birby.resource_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResDto {
    private Map<String, Object> principal;
}
