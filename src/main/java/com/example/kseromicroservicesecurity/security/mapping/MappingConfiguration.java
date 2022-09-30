package com.example.kseromicroservicesecurity.security.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration("securityMappingConfiguration")
public class MappingConfiguration implements Serializable {
    @Bean
    public UserMapper userMapper(){
        return  new UserMapper();
    }

    @Bean
    public RoleMapper roleMapper(){
        return new RoleMapper();
    }
}
