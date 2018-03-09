package id.ac.ui.cs.advprog.tutorial4.exercise1.factory;

import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.CheddarCheese;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.Cheese;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.BoiledClams;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.Clams;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.Dough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.NoCrustDough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.ChilliSauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.Sauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.*;


public class DepokPizzaIngredientFactory implements PizzaIngredientFactory {
    
	@Override
    public Dough createDough() {
        return new NoCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new ChilliSauce();
    }

    @Override
    public Cheese createCheese() {
        return new CheddarCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {new Tomato(), new Spinach(), new BlackOlives(), new Eggplant()};
        return veggies;
    }

    @Override
    public Clams createClam() {
        return new BoiledClams();
    }
}