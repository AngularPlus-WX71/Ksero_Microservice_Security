package com.ksero.security.domain.service;

import com.ksero.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {

    void seed();

    List<Role> getAll();
}