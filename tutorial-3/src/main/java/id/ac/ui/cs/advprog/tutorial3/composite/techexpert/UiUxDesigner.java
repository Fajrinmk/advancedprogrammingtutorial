package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class UiUxDesigner extends Employees {
	public UiUxDesigner(String name, double salary) {
		super(name, salary);
		if (this.salary < 90000.00) {
			throw new IllegalArgumentException();
		} else {
			this.role = "UI/UX Designer";
		}
	}

	@Override
	public double getSalary() {
		return this.salary;
	}
}
