/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 *
 * @author ppolo
 */
@Entity
@Table(name = "Project")
public class Project implements Serializable {
    @Id
    @Column(name = "ProjectId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)// Có mối quan hệ với bảng Project_Employee: một project có nhiều project_employee
    private List<Project_Employee> lstProject_Employee;

    public Project() {
    }

    public Project(int projectId, String name) {        
        this.projectId = projectId;
        this.name = name;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project_Employee> getLstProject_Employee() {
        return lstProject_Employee;
    }

    public void setLstProject_Employee(List<Project_Employee> lstProject_Employee) {
        this.lstProject_Employee = lstProject_Employee;
    }

    @Override
    public String toString() {
        return "Project{" + "projectId=" + projectId + ", name=" + name;
    }
    
}

