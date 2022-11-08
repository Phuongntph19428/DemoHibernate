/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.Employee;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author ppolo
 */
public class QLEmployee {

    private String id;
    private String firstName;
    private String lastName;
    private Date dateOB;
    private int tuoi;

    public QLEmployee() {
    }

    public QLEmployee(String id, String firstName, String lastName, Date dateOB) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOB = dateOB;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getTuoi() {
        return (new Date()).getYear() - dateOB.getYear();
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public Date getDateOB() {
        return dateOB;
    }

    public void setDateOB(Date dateOB) {
        this.dateOB = dateOB;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "{" + id + "}";
    }

    public Object[] toDataRow() {
        return new Object[]{id, firstName, lastName, getTuoi()};
    }

    public Employee getEmployee() {
        return new Employee(id == null ? null : UUID.fromString(id), firstName, lastName, dateOB);
    }

}