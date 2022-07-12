package com.ssu.vaapi.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class UserDto {
    String name;
    String username;
}
