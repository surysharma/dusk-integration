package com.hedgebenefits.domain;


public class Employee {
    private Long id;
    private String name;
    private String niNumber;

    private Employee(){}

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
