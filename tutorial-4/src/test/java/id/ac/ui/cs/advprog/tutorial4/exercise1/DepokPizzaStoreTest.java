package id.ac.ui.cs.advprog.tutorial4.exercise1;

import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.CheesePizza;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.ClamPizza;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.Pizza;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.VeggiePizza;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DepokPizzaStoreTest {

    private PizzaStore depokPizzaStore;

    @Before
    public void setUp() throws Exception {
        depokPizzaStore = new DepokPizzaStore();
    }

    @Test
    public void testCreateCheesePizza() {
        Pizza pizza = depokPizzaStore.orderPizza("cheese");
        assertTrue(pizza instanceof CheesePizza);
        assertEquals("Depok Style Cheese Pizza", pizza.getName());
    }

    @Test
    public void testCreateVeggiesPizza() {
        Pizza pizza = depokPizzaStore.orderPizza("veggie");
        assertTrue(pizza instanceof VeggiePizza);
        assertEquals("Depok Style Veggie Pizza", pizza.getName());
    }

    @Test
    public void testCreateClamPizza() {
        Pizza pizza = depokPizzaStore.orderPizza("clam");
        assertTrue(pizza instanceof ClamPizza);
        assertEquals("Depok Style Clam Pizza", pizza.getName());
    }
}
