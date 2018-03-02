package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class NetworkExpert extends Employees {
	public NetworkExpert(String name, double salary) {
		super(name, salary);
		if (this.salary < 50000.00) {
			throw new IllegalArgumentException();
		} else {
			this.role = "Network Expert";
		}
	}

	@Override
	public double getSalary() {
		return this.salary;
	}
}
