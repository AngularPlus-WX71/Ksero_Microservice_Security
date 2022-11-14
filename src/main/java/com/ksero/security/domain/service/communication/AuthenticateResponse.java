package com.ksero.security.domain.service.communication;

import com.ksero.security.resource.AuthenticateResource;
import com.ksero.shared.domain.service.communication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {

    public AuthenticateResponse(String message){
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource){
        super(resource);
    }
}