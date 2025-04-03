package dev.m.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Category {
    @Id
    private String id;
    private String name;
    private String description;
}