package id.ac.ui.cs.advprog.tutorial3.composite.higherups;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class Ceo extends Employees {
    public Ceo(String name, double salary) {
        // TODO Implement
        super(name, salary);
        if (this.salary < 200000.00) {
            throw new IllegalArgumentException();
        }
        this.role = "CEO";
    }

    @Override
    public double getSalary() {
        // TODO Implement
        return this.salary;
    }
}
