package com.spring.studentportal.client;


import com.spring.studentportal.client.dto.request.LoginRequest;
import com.spring.studentportal.client.dto.response.AccessTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
@FeignClient(value = "UaaClientService", url = "localhost:20224/public/")
public interface UaaClientService {

    @PostMapping("signin")
    Optional<AccessTokenResponse> login(LoginRequest loginRequest);


}
