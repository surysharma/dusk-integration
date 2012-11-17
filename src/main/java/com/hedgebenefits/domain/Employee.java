package com.hedgebenefits.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "id", "name", "niNumber" })
public class Employee {

    @XmlElement
    private Long id;
    @XmlElement
    private String name;
    @XmlElement
    private String niNumber;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNiNumber() {
        return niNumber;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setNiNumber(String niNumber) {
        this.niNumber = niNumber;
    }

    public static class EmployeeBuilder{

        private Long id;
        private String name;
        private String niNumber;

        public EmployeeBuilder id(Long id) {
            this.id =id;
            return this;  //To change body of created methods use File | Settings | File Templates.
        }

        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;  //To change body of created methods use File | Settings | File Templates.
        }

        public EmployeeBuilder niNumber(String niNumber) {
            this.niNumber = niNumber;
            return this;  //To change body of created methods use File | Settings | File Templates.
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.id = id;
            employee.niNumber = niNumber;
            employee.name = name;
            return employee;  //To change body of created methods use File | Settings | File Templates.
        }
    }
}
