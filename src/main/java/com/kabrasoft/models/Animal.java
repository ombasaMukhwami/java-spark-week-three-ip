package com.kabrasoft.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal extends BaseModel {
    private int animalTypeId;
    private String name;
    private String health;
    private String age;
}
