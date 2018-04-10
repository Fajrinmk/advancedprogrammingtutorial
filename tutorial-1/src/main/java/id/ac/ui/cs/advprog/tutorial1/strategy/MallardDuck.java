package id.ac.ui.cs.advprog.tutorial1.strategy;

public class MallardDuck extends Duck {
	// TODO Complete me!
	public void MallardDuck() {
		this.setFlyBehavior(new FlyWithWings());
		this.setQuackBehavior(new Quack());
		this.setSwimBehavior(new Swim());
	}

	@Override
	public void display() {
		System.out.println("I'm mallard duck");
	}

}
