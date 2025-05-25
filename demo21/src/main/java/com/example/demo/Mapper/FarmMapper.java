package com.example.demo.Mapper;

import com.example.demo.Entity.Farm;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface FarmMapper {
    @Select("SELECT * FROM farm")
    List<Farm> findAll();

    @Select("SELECT * FROM farm WHERE id = #{id}")
    Farm findById(int id);

    @Insert("INSERT INTO farm(name, location, size) VALUES(#{name}, #{location}, #{size})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Farm farm);

    @Update("UPDATE farm SET name=#{name}, location=#{location}, size=#{size} WHERE id=#{id}")
    void update(Farm farm);

    @Delete("DELETE FROM farm WHERE id = #{id}")
    void delete(int id);
}
