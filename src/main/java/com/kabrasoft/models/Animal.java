package com.kabrasoft.models;

import com.kabrasoft.constants.Species;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal extends BaseModel {
    private Species species;
    private String name;
    private String health;
    private String age;
}
