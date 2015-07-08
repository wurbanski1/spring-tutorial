package com.acme.order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.order.pizza.PizzaOrderServiceImpl;
import com.acme.order.pizza.PizzaType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/configuration.xml" })
public class PizzaOrderServiceSpringTest {

	@Autowired
	private PizzaOrderServiceImpl pizzaOrderServiceImpl;
	private Customer customer1;
	private Customer customer2;

	@Before
	public void Implementation() {
		customer1 = new Customer("John Smith", "john@smith.com", "Lodz, Jaracza 74");
		customer2 = new Customer("Jan Kowalski", "jan@kowalski.pl", "Lodz, Piotrkowska 100");
	}

	@Test
	public void pizzaOrderServiceSpringTest() {
		Assert.assertNotNull(pizzaOrderServiceImpl.createOrder(customer1, PizzaType.BIG));
	}

}
