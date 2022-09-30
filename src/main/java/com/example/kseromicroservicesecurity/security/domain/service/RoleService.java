package com.example.kseromicroservicesecurity.security.domain.service;

import com.example.kseromicroservicesecurity.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {

    void seed();

    List<Role> getAll();
}