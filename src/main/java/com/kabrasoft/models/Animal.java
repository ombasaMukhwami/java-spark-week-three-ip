package com.kabrasoft.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    private int id;
    private String type;
    private String name;
    private String health;
    private String age;
}
