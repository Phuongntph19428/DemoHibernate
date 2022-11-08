/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ppolo
 */

@Entity
@Table(name = "Project_Employee")
public class Project_Employee implements Serializable {
    
    @Id
    @Column(name = "Project_Employee_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "ProjectId", nullable = true)
    private Project project;
    
    @ManyToOne
    @JoinColumn(name = "EmployeeId", nullable = true) // môt project_employee có môt employee 
    private Employee employee;
    
    @Column(name = "[Desc]")
    private String desc;

    public Project_Employee() {
    }

    public Project_Employee(Project project, Employee employee, String desc) {
        this.project = project;
        this.employee = employee;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Project_Employee{" + "id=" + id + ", project=" + project + ", employee=" + employee + ", Desc=" + desc + '}';
    }
    
}