/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.Project;

/**
 *
 * @author ppolo
 */
public class QLProject {

    private int projectId;
    private String name;

    public QLProject() {
    }

    public QLProject(int projectId, String name) {
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

    @Override
    public String toString() {
        return name + "{" + projectId + "}";
    }

    public Object[] toDataRow() {
        return new Object[]{projectId, name};
    }

    public Project getProject() {
        return new Project(projectId, name);
    }

}
