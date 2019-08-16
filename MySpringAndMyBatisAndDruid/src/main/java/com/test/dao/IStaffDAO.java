package com.test.dao;

import com.test.domain.Staff;

import java.util.List;

public interface IStaffDAO {
    List<Staff> selectAllStaff();

    int UpdateStaff(Staff staff);

    int InsertStaff(Staff staff);

    int DeleteStaff(Staff staff);
}
