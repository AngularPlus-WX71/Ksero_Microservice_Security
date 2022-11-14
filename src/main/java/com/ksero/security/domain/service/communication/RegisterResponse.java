package com.ksero.security.domain.service.communication;

import com.ksero.security.resource.UserResource;
import com.ksero.shared.domain.service.communication.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource> {

    public RegisterResponse(String message){
        super(message);
    }

    public RegisterResponse(UserResource resource){
        super(resource);
    }
}