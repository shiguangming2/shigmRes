package org.shigm.securitydymic.bean;

import java.util.List;

/**
 * @author shigm
 * @date 2019/11/17 21:13
 */
public class Menu {
    private Integer id;
    private String pattern;
    private List<Role> roles;


    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", pattern='" + pattern + '\'' +
                ", roles=" + roles +
                '}';
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
