package com.test.dao;

import com.test.domain.Staff;
import com.test.domain.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IStaffDAO {
    List<Staff> selectAllStaff();

    @Select("select * from staff where staff_id = #{staff_id}")
    Staff selectStaffById(Integer staff_id);

    int UpdateStaff(Staff staff);

    int InsertStaff(Staff staff);

    int DeleteStaff(Staff staff);
}
