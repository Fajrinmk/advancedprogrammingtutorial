package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class SecurityExpert extends Employees {
    public SecurityExpert(String name, double salary) {
        super(name, salary);
        if (this.salary < 70000.00) {
            throw new IllegalArgumentException();
        }
        this.role = "Security Expert";
    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
