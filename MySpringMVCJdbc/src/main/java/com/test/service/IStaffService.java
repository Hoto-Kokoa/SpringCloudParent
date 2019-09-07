package com.test.service;

import com.test.domain.Staff;
import com.test.domain.Student;

import java.util.List;

public interface IStaffService {
    List<Staff> selectAllStaff();

    Staff selectStaffById(Integer staff_id);

    int UpdateStaff(Staff staff);

    int InsertStaff(Staff staff);

    int DeleteStaff(Staff staff);
}
