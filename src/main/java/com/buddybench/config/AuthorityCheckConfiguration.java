package com.buddybench.config;

import com.buddybench.controller.BaseController;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Configuration
public class AuthorityCheckConfiguration extends BaseController {


    public List<String> adminCheckAuthority(Long res, Collection<? extends GrantedAuthority> userAuth) {
        List<String> emptyList = new ArrayList<>();
        List<String> userRoles = new ArrayList<>();
        String roleAdmin = "";
        String roleName = "";
        for (GrantedAuthority urole : userAuth) {
            roleAdmin = urole.getAuthority();
            userRoles.add(urole.getAuthority());
            roleName = urole.getAuthority();
            System.out.println("roleName::: " + roleName);
        }
        if (roleAdmin.equalsIgnoreCase(roleName)) {
            System.out.println("ROLE::: " + roleAdmin);
            return userRoles;
        } else {
            long id = roleRepository.findRoleIdByRoleName(roleName);
            List<Long> respList = roleRepository.findRespnsbilitiesByRoleId(id);
            System.out.println(
                    "Resp is :Admin:: - " + res + " & SubAdmin Responsibilities List ::: " + Arrays.asList(respList));
            if (respList.contains(res))
                return userRoles;
            else
                return emptyList;
        }
    }
}
