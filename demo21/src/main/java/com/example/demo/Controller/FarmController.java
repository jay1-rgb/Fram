package com.example.demo.Controller;


import com.example.demo.Entity.Farm;

import com.example.demo.Entity.Result;
import com.example.demo.Service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmController {

    @Autowired
    private FarmService farmService;

    @GetMapping
    public Result<List<Farm>> getAllFarms() {
        return Result.success(farmService.getAllFarms());
    }

    @GetMapping("/{id}")
    public Result<Farm> getFarmById(@PathVariable int id) {
        return Result.success(farmService.getFarmById(id));
    }

    @PostMapping
    public Result<Void> createFarm(@RequestBody Farm farm) {
        farmService.createFarm(farm);
        return Result.success(null);
    }

    @PutMapping("/{id}")
    public Result<Void> updateFarm(@PathVariable int id, @RequestBody Farm farm) {
        farm.setId(id); // set the ID for the update method
        farmService.updateFarm(farm);
        return Result.success(null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteFarm(@PathVariable int id) {
        farmService.deleteFarm(id);
        return Result.success(null);
    }
}