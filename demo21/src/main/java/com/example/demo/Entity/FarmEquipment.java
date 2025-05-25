package com.example.demo.Entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class FarmEquipment {
    private int id;


    @NotBlank(message = "设备名称不能为空")
    private String equipmentName;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "日期格式应为yyyy-MM-dd")
    private String purchaseDate;
    private String maintenanceSchedule;

    @Override
    public String toString() {
        return "FarmEquipment{" +
                "id=" + id +
                ", equipmentName='" + equipmentName + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", maintenanceSchedule='" + maintenanceSchedule + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getMaintenanceSchedule() {
        return maintenanceSchedule;
    }

    public void setMaintenanceSchedule(String maintenanceSchedule) {
        this.maintenanceSchedule = maintenanceSchedule;
    }
}