package id.ac.ui.cs.advprog.tutorial4.exercise1;

import org.junit.Before;
import org.junit.Test;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;

public class PizzaStoreTest {
    private Class<?> pizzaStoreClass;

    @Before
    public void setUp() throws Exception {
        pizzaStoreClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.exercise1.PizzaStore");
    }

    @Test
    public void testPizzaStoreIsAbstract() {
        int classModifiers = pizzaStoreClass.getModifiers();

        assertTrue(Modifier.isAbstract(classModifiers));
    }

    @Test
    public void testPizzaStoreHasCreatePizza() throws Exception {
        Method createPizza = pizzaStoreClass.getDeclaredMethod("createPizza",
                String.class);
        int methodModifiers = createPizza.getModifiers();

        assertTrue(Modifier.isProtected(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
    }

    @Test
    public void testPizzaStoreHasOrderPizza() throws Exception {
        Method orderPizza = pizzaStoreClass.getDeclaredMethod("orderPizza",
                String.class);
        int methodModifiers = orderPizza.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
    }


}
