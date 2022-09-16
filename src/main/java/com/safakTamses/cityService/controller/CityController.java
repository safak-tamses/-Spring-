package com.safakTamses.cityService.controller;

import com.safakTamses.cityService.model.city;
import com.safakTamses.cityService.service.cityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/citys")
@AllArgsConstructor
public class CityController {

    private final com.safakTamses.cityService.service.cityService cityService;
    @GetMapping
    public ResponseEntity<List<city>> getCitys() {
        return new ResponseEntity<>(cityService.getCity(), OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<city> getcityy(@PathVariable String id){
        return new ResponseEntity<>(cityService.findS(id),OK);
    }
    @PostMapping
    public ResponseEntity<city> createCity(@RequestBody city ver){
        return new ResponseEntity<>(cityService.addCity(ver),CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> getCity(@PathVariable String id , @RequestBody city newCity){
        city oldCity = cityService.findS(id);
        oldCity.setName(newCity.getName());
        oldCity.setCreateDate(new Date());
        return new ResponseEntity<>(OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delCity(@PathVariable String id){
        cityService.delCity(id);
        return new ResponseEntity<>(OK);
    }


}
