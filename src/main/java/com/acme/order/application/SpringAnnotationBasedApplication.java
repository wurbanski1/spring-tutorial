package com.acme.order.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.acme.order.Customer;
import com.acme.order.pizza.PizzaOrderServiceImpl;
import com.acme.order.pizza.PizzaType;
import com.acme.springConfiguration.SpringConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringAnnotationBasedApplication {

	public static void main(String[] args) {
		log.info("Spring XML based application");
		
		Customer customer1 = new Customer("John Smith", "john@smith.com", "Lodz, Jaracza 74");
		Customer customer2 = new Customer("Jan Kowalski", "jan@kowalski.pl", "Lodz, Piotrkowska 100");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(SpringConfiguration.class);
		context.refresh();
		PizzaOrderServiceImpl orderService = (PizzaOrderServiceImpl)context.getBean("pizzaOrderServiceImpl");
		
		String orderId1 = orderService.createOrder(customer1, PizzaType.LARGE);
		String orderId2 = orderService.createOrder(customer2, PizzaType.SMALL);

		log.info("Unprocessed orders:{}", orderService.fetchUnprocessed());
		log.info("Delivered orders:{}", orderService.fetchDelivered());

		orderService.deliverOrder(orderId1);
		log.info("Delivered orders:{}", orderService.fetchDelivered());
		orderService.cancelOrder(orderId2);
		log.info("Delivered orders:{}", orderService.fetchDelivered());
		log.info("Cancelled orders:{}", orderService.fetchCancelled());
		log.info("Unprocessed orders:{}", orderService.fetchUnprocessed());
		
	}
}
