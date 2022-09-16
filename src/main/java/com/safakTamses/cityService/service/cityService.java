package com.safakTamses.cityService.service;

import com.safakTamses.cityService.model.city;
import com.safakTamses.cityService.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class cityService {
    private final CityRepository cityRepository;


    public List<city> getCity(){
        return cityRepository.findAll();
    }
    public city addCity(city ver) {
        return cityRepository.save(ver);
    }
    public void delCity(String id) {
        cityRepository.deleteById(id);
    }
    public city findS(String id) {
        return cityRepository.findById(id).orElseThrow(() -> new RuntimeException("city not found"));
    }
}
