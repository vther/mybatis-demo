package com.vther.dao;

import com.vther.entity.PersonEntity;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PersonMapper {

//    @Select("SELECT * FROM persons")
    List<PersonEntity> selectAll();

    @Select(" SELECT * FROM persons WHERE id = #{id}")
    PersonEntity selectById(int id);

    int insert(PersonEntity person);

    @Update("UPDATE persons SET name = #{name} WHERE id = #{id}")
    void update(PersonEntity person);

    void delete(int id);
}