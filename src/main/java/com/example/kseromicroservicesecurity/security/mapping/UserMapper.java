package com.example.kseromicroservicesecurity.security.mapping;

import com.example.kseromicroservicesecurity.security.domain.model.entity.Role;
import com.example.kseromicroservicesecurity.security.domain.model.entity.User;
import com.example.kseromicroservicesecurity.security.resource.UserResource;
import com.example.kseromicroservicesecurity.shared.mapping.EnhancedModelMapper;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    Converter<Role, String> roleToString = new AbstractConverter<Role, String>(){
        @Override
        protected  String convert(Role role){
            return  role == null ? null : role.getName().name();
        }
    };

    //Object Mapping

    public UserResource toResource(User model){
        mapper.addConverter(roleToString);
        return mapper.map(model, UserResource.class);
    }

    public List<UserResource> toResource(List<User> model){
        return mapper.mapList(model, UserResource.class);
    }

}
