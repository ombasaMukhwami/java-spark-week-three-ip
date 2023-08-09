package com.kabrasoft.services;

import com.kabrasoft.models.Ranger;

import java.util.List;

public interface RangerService {
    boolean  createRanger(Ranger ranger);
    Ranger findByName(String name);
    Ranger findById(int id);
    List<Ranger> findAll();
    boolean delete(int id);
}
