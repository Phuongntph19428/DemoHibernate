/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repository.EmployeeRepository;
import viewmodel.QLEmployee;

/**
 *
 * @author ppolo
 */
public class QLEmployeeService {

    private final EmployeeRepository _employeeRepo;
    private List<QLEmployee> _lstQLEmployee;

    public QLEmployeeService() {
        _employeeRepo = new EmployeeRepository();
    }

    public String insert(QLEmployee qLEm) {
        boolean insertSuccess = _employeeRepo.insert(qLEm.getEmployee());
        return insertSuccess ? "Thêm thành công" : "Thêm thất bại";
    }

    public String update(QLEmployee qLEm) {
        boolean updateSuccess = _employeeRepo.update(qLEm.getEmployee());
        return updateSuccess ? "Cập nhật thành công" : "Cập nhật thất bại";
    }

    public String delete(UUID id) {
        boolean deleteSuccess = _employeeRepo.delete(id);
        return deleteSuccess ? "Xóa thành công" : "Xóa thất bại";
    }

    public List<QLEmployee> selectAll() {
        _lstQLEmployee = new ArrayList<>();
        var ems = _employeeRepo.selectAll();
        for (Employee em : ems) {
            _lstQLEmployee.add(new QLEmployee(em.getId().toString(), em.getFirstName(), em.getLastName(), em.getDateOB()));
        }
        return _lstQLEmployee;
    }

}

