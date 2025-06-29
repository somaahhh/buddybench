package com.buddybench.controller;

import com.buddybench.repository.RoleRepository;
import com.buddybench.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {

    @Autowired
    protected RoleRepository roleRepository;

    @Autowired
    protected RoleService roleService;
}
