package com.example.demo.Controller;

import com.example.demo.Entity.FarmEquipment;

import com.example.demo.Entity.Result;
import com.example.demo.Service.FarmEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class FarmEquipmentController {

    @Autowired
    private FarmEquipmentService farmEquipmentService;

    @GetMapping
    public Result<List<FarmEquipment>> getAllEquipment() {
        return Result.success(farmEquipmentService.getAllEquipment());
    }

    @GetMapping("/{id}")
    public Result<FarmEquipment> getEquipmentById(@PathVariable int id) {
        return Result.success(farmEquipmentService.getEquipmentById(id));
    }

    @PostMapping
    public Result<Void> createEquipment(@RequestBody FarmEquipment farmEquipment) {
        farmEquipmentService.createEquipment(farmEquipment);
        return Result.success(null);
    }

    @PutMapping("/{id}")
    public Result<Void> updateEquipment(@PathVariable int id, @RequestBody FarmEquipment farmEquipment) {
        farmEquipment.setId(id); // set the ID for the update method
        farmEquipmentService.updateEquipment(farmEquipment);
        return Result.success(null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteEquipment(@PathVariable int id) {
        farmEquipmentService.deleteEquipment(id);
        return Result.success(null);
    }
}