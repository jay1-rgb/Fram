package com.example.demo.Entity;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Farm {
    private int id;
    @NotBlank(message = "农场名称不能为空")
    private String name;
    @NotBlank(message = "位置不能为空")
    private String location;
    @Min(value = 1, message = "面积必须大于0")
    private double size;

    @Override
    public String toString() {
        return "Farms{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", size=" + size +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}