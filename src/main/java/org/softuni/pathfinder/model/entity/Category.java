package org.softuni.pathfinder.model.entity;

import jakarta.persistence.*;
import org.softuni.pathfinder.model.entity.enums.CategoryNameEnum;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private CategoryNameEnum name;
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }
    @Column(columnDefinition = "LONGTEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
