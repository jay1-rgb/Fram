package com.example.demo.Service;
import com.example.demo.Entity.FarmEquipment;

import com.example.demo.Mapper.FarmEquipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmEquipmentService {
    @Autowired
    private FarmEquipmentMapper farmEquipmentMapper;

    public List<FarmEquipment> getAllEquipment() {
        return farmEquipmentMapper.findAll();
    }

    public FarmEquipment getEquipmentById(int id) {
        return farmEquipmentMapper.findById(id);
    }

    public void createEquipment(FarmEquipment farmEquipment) {
        farmEquipmentMapper.insert(farmEquipment);
    }

    public void updateEquipment(FarmEquipment farmEquipment) {
        farmEquipmentMapper.update(farmEquipment);
    }

    public void deleteEquipment(int id) {
        farmEquipmentMapper.delete(id);
    }
}