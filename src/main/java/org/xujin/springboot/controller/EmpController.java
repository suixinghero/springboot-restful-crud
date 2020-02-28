package org.xujin.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.xujin.springboot.dao.DepartmentDao;
import org.xujin.springboot.dao.EmployeeDao;
import org.xujin.springboot.entities.Department;
import org.xujin.springboot.entities.Employee;

import java.util.Collection;
import java.util.Date;


/**
 * @author xujin
 * @package-name org.xujin.springboot.controller
 * @createtime 2020-02-26 17:37
 */
@Controller
public class EmpController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    //得到员工列表页面
    @GetMapping("/emps")
    public String getEmpList(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加功能
    @PostMapping("/emp")
    public String  addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //来到员工编辑页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        model.addAttribute("depts",departments);
        return "emp/edit";
    }

    //员工编辑功能
    @PutMapping("/emp")
    public String  editEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除功能
    @DeleteMapping("/emp/{id}")
    public String  deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
