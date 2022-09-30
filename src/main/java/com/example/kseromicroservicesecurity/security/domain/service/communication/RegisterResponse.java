package com.example.kseromicroservicesecurity.security.domain.service.communication;

import com.example.kseromicroservicesecurity.security.resource.UserResource;
import com.example.kseromicroservicesecurity.shared.domain.service.communication.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource> {

    public RegisterResponse(String message){
        super(message);
    }

    public RegisterResponse(UserResource resource){
        super(resource);
    }
}