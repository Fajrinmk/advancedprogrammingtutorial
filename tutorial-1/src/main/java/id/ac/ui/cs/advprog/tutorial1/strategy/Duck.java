package id.ac.ui.cs.advprog.tutorial1.strategy;

public abstract class Duck {

    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;
    private SwimBehavior swimBehavior;

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }
    
    public void swim() {
        swimBehavior.swim();
    }

    public abstract void display();


    // TODO Complete me!
    
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
    
    public void setSwimBehavior(SwimBehavior swimBehavior) {
        this.swimBehavior = swimBehavior;
    }


}
