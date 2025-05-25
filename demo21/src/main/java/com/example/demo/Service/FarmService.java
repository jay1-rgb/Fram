package com.example.demo.Service;
import com.example.demo.Entity.Farm;

import com.example.demo.Mapper.FarmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class FarmService {
    @Autowired
    private FarmMapper farmMapper;

    public List<Farm> getAllFarms() {
        return farmMapper.findAll();
    }

    public Farm getFarmById(int id) {
        return farmMapper.findById(id);
    }

    public void createFarm(Farm farm) {
        farmMapper.insert(farm);
    }

    public void updateFarm(Farm farm) {
        farmMapper.update(farm);
    }

    public void deleteFarm(int id) {
        farmMapper.delete(id);
    }
}