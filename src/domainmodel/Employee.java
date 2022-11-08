/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author ppolo
 */

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

    @Id // Khóa chính
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWID()") // Cột tên là Id, Kiểu dữ liệu UNIQUEIDENTIFIER mặc định là newID()
    @GeneratedValue(generator = "generator") // Đánh dấu id bảng này đã được gen
//    @GenericGenerator(name = "generator", strategy = "uuid", parameters = {})
    private UUID id;//Có thể dùng UUID hoặc String cho UNIQUEIDENTIFIER(database)

    @Column(name = "FirstName") // Cột FirstName
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "DateOB")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOB;

    @OneToMany(mappedBy = "employee", targetEntity = Project_Employee.class)// Có mối quan hệ với bảng Project_Employee: một employee có nhiều project_employee
    private List<Project_Employee> lstProject_Employee;

    public Employee() {
    }

    public Employee(UUID id, String firstName, String lastName, Date dateOB) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOB = dateOB;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Project_Employee> getLstProject_Employee() {
        return lstProject_Employee;
    }

    public void setLstProject_Employee(List<Project_Employee> lstProject_Employee) {
        this.lstProject_Employee = lstProject_Employee;
    }

    public Date getDateOB() {
        return dateOB;
    }

    public void setDateOB(Date dateOB) {
        this.dateOB = dateOB;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName;
    }

}
