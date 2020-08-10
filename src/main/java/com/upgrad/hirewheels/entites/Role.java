package com.upgrad.hirewheels.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Role {

    @Id
    @SequenceGenerator(name="ROLEID_GENERATOR" )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLEID_GENERATOR")
    @Column(name="ROLE_ID")
    private int roleId;

    @Column(name="ROLE_NAME",nullable = false,unique = true)
    private String roleName;

    @OneToMany(mappedBy ="role" )
    List<User> users;

    public Role() {
    }

    public Role(String roleName,int roleId) {
        this.roleId=roleId;
        this.roleName=roleName;
    }

    public Role(String roleName) {
        this.roleName=roleName;
    }


    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
