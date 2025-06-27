package com.buddybench.utils;

import com.buddybench.controller.BaseController;
import com.buddybench.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.validation.Validator;

@Component
public class BeanValidator {
    @Autowired
    protected RoleRepository roleRepository;

    public static Validator getValidator() {
        return (Validator) Validation.buildDefaultValidatorFactory().getValidator();
    }

    @PostConstruct
    public void updateRespData() {
        Constants.adminRespId();
    }

    @PostConstruct
    public String[] allRoleName() {
        return roleRepository.findAllByRoleName();
    }
}
