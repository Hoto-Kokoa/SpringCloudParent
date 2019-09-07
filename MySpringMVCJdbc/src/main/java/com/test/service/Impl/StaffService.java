package com.test.service.Impl;

import com.test.dao.IStaffDAO;
import com.test.domain.Staff;
import com.test.domain.Student;
import com.test.service.IStaffService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
@Getter
public class StaffService implements IStaffService {

    private IStaffDAO staffDAO;

    public List<Staff> selectAllStaff() {
        return staffDAO.selectAllStaff();
    }

    public Staff selectStaffById(Integer staff_id) {
        return staffDAO.selectStaffById(staff_id);
    }

    public int UpdateStaff(Staff staff) {
        return staffDAO.UpdateStaff(staff);
    }

    public int InsertStaff(Staff staff) {
        return staffDAO.InsertStaff(staff);
    }

    public int DeleteStaff(Staff staff) {
        return staffDAO.DeleteStaff(staff);
    }
}
