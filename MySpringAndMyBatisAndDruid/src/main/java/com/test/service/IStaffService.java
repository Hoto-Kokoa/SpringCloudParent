package com.test.service;

import com.test.domain.Staff;

import java.util.List;

public interface IStaffService {
    List<Staff> selectAllStaff();

    int UpdateStaff(Staff staff);

    int InsertStaff(Staff staff);

    int DeleteStaff(Staff staff);
}
