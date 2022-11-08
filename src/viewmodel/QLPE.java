/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.Employee;
import domainmodel.Project;
import domainmodel.Project_Employee;

/**
 *
 * @author ppolo
 */
public class QLPE {

    private int id;
    private Project project;
    private Employee employee;
    private String desc;

    public QLPE() {
    }

    public QLPE(int id, Project project, Employee employee, String desc) {
        this.id = id;
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
        return "QLPE{" + "id=" + id + ", project=" + project + ", employee=" + employee + ", desc=" + desc + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{id, project.getName(), employee.getFirstName() + " " + employee.getLastName()};
    }
    
    public Project_Employee getPE() {
        return new Project_Employee(project, employee, desc);
    }

}