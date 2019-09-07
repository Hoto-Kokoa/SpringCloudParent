package com.test.web.controller;


import com.test.domain.Staff;
import com.test.service.Impl.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {


    @Autowired
    private StaffService staffService;

    @RequestMapping("/list")
    public String list(Model model) {

        model.addAttribute("staff", staffService.selectAllStaff());
        return "staff/list";
    }

    @RequestMapping("/insert")
    public String insert(Model model, Long staff_id) {
        if (staff_id != null) {

        }

        return "staff/insert";
    }

    @RequestMapping("/save")
    public String save(Staff staff) {
        System.out.println(staff);
        int i = staffService.InsertStaff(staff);
        System.out.println("插入返回数值:"+i);
        return "redirect:/staff/list";
    }


    @RequestMapping("/delete")
    public String delete(Staff staff) {
        int i = staffService.DeleteStaff(staff);
        System.out.println("删除返回数值:"+i);
        return "redirect:/staff/list";
    }


    @RequestMapping("/update")
    public String update(Model model, Integer staff_id) {
        System.out.println("staff_id:"+staff_id);
        model.addAttribute("staff", staffService.selectStaffById(staff_id));
        return "staff/update";
    }


    @RequestMapping("/updateSave")
    public String updateSave(Staff staff) {
        System.out.println("要更新的staff的数据:"+staff);
        int i = staffService.UpdateStaff(staff);
        System.out.println("更新返回数据:"+i);
        return "redirect:/staff/list";
    }
}
