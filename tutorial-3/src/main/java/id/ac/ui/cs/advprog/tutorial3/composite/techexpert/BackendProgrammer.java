package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class BackendProgrammer extends Employees {
    // TODO Implement
    public BackendProgrammer(String name, double salary) {
        super(name, salary);
        if (this.salary < 20000.00) {
            throw new IllegalArgumentException();
        }
        this.role = "Back End Programmer";
    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
