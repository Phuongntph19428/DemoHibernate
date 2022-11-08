/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.Project;
import java.util.ArrayList;
import java.util.List;
import repository.ProjectRepository;
import viewmodel.QLProject;

/**
 *
 * @author ppolo
 */
public class QLProjectService {

    private final ProjectRepository _projectRepo;
    private List<QLProject> _lstQLProject;

    public QLProjectService() {
        _projectRepo = new ProjectRepository();
    }

    public String insert(QLProject qlProj) {
        boolean insertSuccess = _projectRepo.insert(qlProj.getProject());
        return insertSuccess ? "Thêm thành công" : "Thêm thất bại";
    }

    public String update(QLProject qlProj) {
        boolean updateSuccess = _projectRepo.update(qlProj.getProject());
        return updateSuccess ? "Cập nhật thành công" : "Cập nhật thất bại";
    }

    public String delete(int id) {
        boolean deleteSuccess = _projectRepo.delete(id);
        return deleteSuccess ? "Xóa thành công" : "Xóa thất bại";
    }

    public List<QLProject> selectAll() {
        _lstQLProject = new ArrayList<>();
        var pros = _projectRepo.selectAll();
        for (Project pro : pros) {
            _lstQLProject.add(new QLProject(pro.getProjectId(), pro.getName()));
        }
        return _lstQLProject;
    }
}
