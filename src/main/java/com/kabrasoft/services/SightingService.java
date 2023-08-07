package com.kabrasoft.services;

import com.kabrasoft.models.Sighting;

import java.util.List;

public interface SightingService {
    boolean  createSighting(Sighting sighting);
    List<Sighting> findAll();
    boolean delete(int id);
}
