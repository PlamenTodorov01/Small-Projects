package org.softuni.pathfinder.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.softuni.pathfinder.model.entity.enums.RoleNameEnum;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private RoleNameEnum role;

    public Role() {
    }

    public Role(RoleNameEnum role) {
        this.role = role;
    }

    @Enumerated(EnumType.STRING)
    public RoleNameEnum getRole() {
        return role;
    }

    public void setRole(RoleNameEnum name) {
        this.role = name;
    }
}
