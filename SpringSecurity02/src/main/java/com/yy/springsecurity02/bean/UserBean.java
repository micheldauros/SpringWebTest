package com.yy.springsecurity02.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class UserBean {
    private String userId;
    private String username;
    private String password;
    private List<RoleBean> userRoles=new ArrayList<>();
    private List<ResourceBean> resourceBeans=new ArrayList<>();

    public UserBean(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public Boolean havePermission(String resource){
        return this.resourceBeans.stream().anyMatch(resourceBean -> resourceBean.getResourceName().equals(resource));
    }
}
