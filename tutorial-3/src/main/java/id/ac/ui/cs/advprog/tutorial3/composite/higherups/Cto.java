package id.ac.ui.cs.advprog.tutorial3.composite.higherups;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class Cto extends Employees {
    public Cto(String name, double salary) {
        super(name, salary);
        if (this.salary < 100000.00) {
            throw new IllegalArgumentException();
        }
        this.role = "CTO";
    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
