/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.Project_Employee;
import java.util.ArrayList;
import java.util.List;
import repository.PERepository;
import viewmodel.QLPE;

/**
 *
 * @author ppolo
 */
public class QLPEService {

    private final PERepository _peRepo;
    private List<QLPE> _lstPE;

    public QLPEService() {
        _peRepo = new PERepository();
    }

    public String insert(QLPE qlPE) {
        boolean insertSuccess = _peRepo.insert(qlPE.getPE());
        return insertSuccess ? "Thêm thành công" : "Thêm thất bại";
    }

    public String update(QLPE qlPE) {
        boolean updateSuccess = _peRepo.update(qlPE.getPE());
        return updateSuccess ? "Cập nhật thành công" : "Cập nhật thất bại";
    }

    public String delete(int id) {
        boolean deleteSuccess = _peRepo.delete(id);
        return deleteSuccess ? "Xóa thành công" : "Xóa thất bại";
    }

    public List<QLPE> selectAll() {
        _lstPE = new ArrayList<>();
        var pes = _peRepo.selectAll();
        for (Project_Employee pe : pes) {
            _lstPE.add(new QLPE(pe.getId(), pe.getProject(), pe.getEmployee(), pe.getDesc()));
        }
        return _lstPE;
    }
}

