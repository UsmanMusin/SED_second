package model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String contacts;

    @OneToOne
    private Employee manager;



    @OneToMany
    private Set<Employee> employeeSet;

    public Department() {
    }

    /*public Department(String name, String contacts, Employee manager, Set<Employee> employeeSet) {
        this.name = name;
        this.contacts = contacts;
        this.manager = manager;
        this.employeeSet = employeeSet;
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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    @Override
    public String toString(){
        return "\nDepartment:\n" + "name: " + name + "\ncontacts:" + contacts +
                "\nmanager: " + manager;
    }
}
