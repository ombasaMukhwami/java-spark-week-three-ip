package com.kabrasoft.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Ranger extends BaseModel{
    private String name;
    private String badgeNo;
    private String address;
}
