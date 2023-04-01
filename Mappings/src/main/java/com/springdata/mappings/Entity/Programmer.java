package com.springdata.mappings.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(name="salary")
    private int sal;
    @ManyToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinTable(name="programmers_projects",
            joinColumns = @JoinColumn(name = "programmer_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="project_id",referencedColumnName = "id"))
    private Set<Project> projects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }
}
