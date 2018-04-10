package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class FrontendProgrammer extends Employees {
    public FrontendProgrammer(String name, double salary) {
        super(name, salary);
        if (this.salary < 30000.00) {
            throw new IllegalArgumentException();
        }
        this.role = "Front End Programmer";
    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
