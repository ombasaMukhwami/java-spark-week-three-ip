package com.kabrasoft.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Sighting extends BaseModel{
    private int animalId;
    private String location;
    private String timestamp;
    private String rangerName;
}
