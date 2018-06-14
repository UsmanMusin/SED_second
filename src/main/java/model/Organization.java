package model;

import javax.persistence.*;
import java.util.Set;

//@Entity
public class Organization {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Employee manager;

    @OneToMany
    private Set<Department> departmentSet;

    private String name;
    private String legalAddress;
    private String physicalAddress;

    public Organization() {
    }

    /*public Organization(Employee manager, Set<Department> departmentSet, String name, String legalAddress, String physicalAddress) {
        this.manager = manager;
        this.departmentSet = departmentSet;
        this.name = name;
        this.legalAddress = legalAddress;
        this.physicalAddress = physicalAddress;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public Set<Department> getDepartmentSet() {
        return departmentSet;
    }

    public void setDepartmentSet(Set<Department> departmentSet) {
        this.departmentSet = departmentSet;
    }

    @Override
    public String toString(){
        return "\nOrganization:\n" + "name: " + name + "\nmanager:" + manager +
                "\nlegalAddress: " + legalAddress + "\nphysicalAddress: " + physicalAddress;
    }
}
