package com.ssu.vaapi.gates.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ClientDto {
    String username;
    String password;
}
