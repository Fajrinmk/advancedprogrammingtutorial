package id.ac.ui.cs.advprog.tutorial3.composite;

public abstract class Employees {
    protected String name;
    protected double salary;
    protected String role;
    
    public Employees(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public abstract double getSalary();

    public String getRole() {
        return this.role;
    }
}
