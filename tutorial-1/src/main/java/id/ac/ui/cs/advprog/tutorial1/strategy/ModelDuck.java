package id.ac.ui.cs.advprog.tutorial1.strategy;

public class ModelDuck {
	// TODO Complete me!
	public void ModelDuck() {
		this.setFlyBehavior(new FlyNoWay());
		this.setQuackBehavior(new Squeak());
		this.setSwimBehavior(new Swim());
	}

	@Override
	public void display() {
		System.out.println("I'm model duck");
	}

}
