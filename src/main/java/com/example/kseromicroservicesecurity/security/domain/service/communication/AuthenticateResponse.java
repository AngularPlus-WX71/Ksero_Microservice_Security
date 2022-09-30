package com.example.kseromicroservicesecurity.security.domain.service.communication;

import com.example.kseromicroservicesecurity.security.resource.AuthenticateResource;
import com.example.kseromicroservicesecurity.shared.domain.service.communication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {

    public AuthenticateResponse(String message){
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource){
        super(resource);
    }
}