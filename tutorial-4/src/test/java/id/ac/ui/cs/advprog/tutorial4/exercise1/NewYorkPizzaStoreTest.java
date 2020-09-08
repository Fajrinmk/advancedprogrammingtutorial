package id.ac.ui.cs.advprog.tutorial4.exercise1;

import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.CheesePizza;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.ClamPizza;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.Pizza;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.VeggiePizza;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NewYorkPizzaStoreTest {

    private PizzaStore newYorkPizzaStore;

    @Before
    public void setUp() throws Exception {
        newYorkPizzaStore = new NewYorkPizzaStore();
    }

    @Test
    public void testCreateCheesePizza(){
        Pizza pizza = newYorkPizzaStore.orderPizza("cheese");
        assertTrue(pizza instanceof CheesePizza);
        assertEquals("New York Style Cheese Pizza",pizza.getName());
    }

    @Test
    public void testCreateVeggiesPizza(){
        Pizza pizza = newYorkPizzaStore.orderPizza("veggie");
        assertTrue(pizza instanceof VeggiePizza);
        assertEquals("New York Style Veggie Pizza",pizza.getName());
    }

    @Test
    public void testCreateClamPizza(){
        Pizza pizza = newYorkPizzaStore.orderPizza("clam");
        assertTrue(pizza instanceof ClamPizza);
        assertEquals("New York Style Clam Pizza",pizza.getName());
    }
}
