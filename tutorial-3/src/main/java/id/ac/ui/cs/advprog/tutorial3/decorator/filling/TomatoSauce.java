package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class TomatoSauce extends Filling{
	Food food;

    public TomatoSauce(Food food) {
        //TODO Implement
    	this.food = food;
    }

    @Override
    public String getDescription() {
        //TODO Implement
    	return food.getDescription() + ", adding tomato sauce";
    }

    @Override
    public double cost() {
        //TODO Implement
    	return food.cost() + 1.70;
    }
}
