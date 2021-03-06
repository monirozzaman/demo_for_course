package com.spring.studentportal.client.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessTokenResponse {

    private String token;
}
