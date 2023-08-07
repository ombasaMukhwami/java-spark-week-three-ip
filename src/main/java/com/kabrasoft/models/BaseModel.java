package com.kabrasoft.models;

import lombok.Data;

import java.time.Instant;

@Data
public abstract class BaseModel {
    private int id;
    private Instant dateAdded;
}
