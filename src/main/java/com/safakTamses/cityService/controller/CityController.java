package com.safakTamses.cityService.controller;

import com.safakTamses.cityService.model.city;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/citys")
public class CityController {

    private static final List<city> citys= new ArrayList<>();
    public CityController(){
        if(citys.isEmpty()){
            city city1 = new city(new Date(),"34","İstanbul");
            city city2 = new city(new Date(),"21","Diyarbakır");
            city city3 = new city(new Date(),"63","Şanlıurfa");
            citys.add(city1);
            citys.add(city2);
            citys.add(city3);
        }


    }
    @GetMapping
    public ResponseEntity<List<city>> getCitys() {
        return new ResponseEntity<>(citys, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<city> getcity(@PathVariable String id){
        city result= getCityById(id);
        return new ResponseEntity<>(result,OK);
    }
    @PostMapping
    public ResponseEntity<city> createCity(@RequestBody city newCity){
        newCity.setCreateDate(new Date());
        citys.add(newCity);
        return new ResponseEntity<>(newCity,CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> getCity(@PathVariable String id , @RequestBody city newCity){
        city oldCity = getCityById(id);
        oldCity.setName(newCity.getName());
        oldCity.setCreateDate(new Date());
        return new ResponseEntity<>(OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delCity(@PathVariable String id){
        city oldCity = getCityById(id);
        citys.remove(oldCity);
        return new ResponseEntity<>(OK);
    }


    private city getCityById(String id){
        return  citys.stream()
                .filter((city -> city.getId().equals(id)))
                .findFirst().orElseThrow(() -> new RuntimeException("City noy found"));
    }
}
