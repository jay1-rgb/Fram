package com.example.demo.Mapper;
import com.example.demo.Entity.FarmEquipment;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface FarmEquipmentMapper {
    @Select("SELECT * FROM farm_equipment")
    List<FarmEquipment> findAll();

    @Select("SELECT * FROM farm_equipment WHERE id = #{id}")
    FarmEquipment findById(int id);

    @Insert("INSERT INTO farm_equipment(equipmentName, purchaseDate, maintenanceSchedule) VALUES(#{equipmentName}, #{purchaseDate}, #{maintenanceSchedule})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(FarmEquipment farmEquipment);

    @Update("UPDATE farm_equipment SET equipmentName=#{equipmentName}, purchaseDate=#{purchaseDate}, maintenanceSchedule=#{maintenanceSchedule} WHERE id=#{id}")
    void update(FarmEquipment farmEquipment);

    @Delete("DELETE FROM farm_equipment WHERE id = #{id}")
    void delete(int id);
}
