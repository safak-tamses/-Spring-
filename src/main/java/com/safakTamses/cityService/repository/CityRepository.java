package com.safakTamses.cityService.repository;

import com.safakTamses.cityService.model.city;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<city,String> {

}
