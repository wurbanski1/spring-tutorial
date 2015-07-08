package com.acme.springConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.order.HashMapOrderRepository;
import com.acme.order.OrderFactory;
import com.acme.order.OrderRepository;
import com.acme.order.delivery.BasicDeliveryTimeServiceImpl;
import com.acme.order.delivery.DeliveryTimeService;
import com.acme.order.delivery.TimeService;
import com.acme.order.delivery.strategy.PizzaTypeDeliveryTimeStrategy;
import com.acme.order.notification.DeliveryTemplate;
import com.acme.order.notification.MailSender;
import com.acme.order.notification.OrderCancelledTemplate;
import com.acme.order.notification.SimpleMessageTemplateService;
import com.acme.order.pizza.PizzaOrderServiceImpl;

@Configuration
@ComponentScan("com.acme")
public class SpringConfiguration {
	
	@Bean
	public OrderFactory orderFactory() {
		return new OrderFactory();
	}
	
	@Bean
	public OrderRepository hashMapOrderRepository() {
		return new HashMapOrderRepository();
	}
	
	@Bean
	public DeliveryTimeService basicDeliveryTimeServiceImpl() {
		BasicDeliveryTimeServiceImpl basicDeliveryTimeServiceImpl = new BasicDeliveryTimeServiceImpl();
		basicDeliveryTimeServiceImpl.setTimeService(timeService());
		return basicDeliveryTimeServiceImpl;
	}
	
	@Bean
	public TimeService timeService() {
		return new TimeService();
	}
	
	@Bean
	public DeliveryTemplate deliveryTemplate() {
		return new DeliveryTemplate();
	}
	
	@Bean
	public OrderCancelledTemplate orderCancelledTemplate() {
		return new OrderCancelledTemplate();
	}
	
	@Bean
	public SimpleMessageTemplateService simpleMessageTemplateService() {
		SimpleMessageTemplateService simpleMessageTemplateService = new SimpleMessageTemplateService();
		simpleMessageTemplateService.setDeliveryTemplate(deliveryTemplate());
		simpleMessageTemplateService.setCancelDeliveryTemplate(orderCancelledTemplate());
		return simpleMessageTemplateService;
	}
	
	@Bean
	public MailSender mailSender() {
		return new MailSender();
	}
	
	@Bean
	public PizzaOrderServiceImpl pizzaOrderServiceImpl() {
		
		PizzaOrderServiceImpl pizzaOrderServiceImpl = new PizzaOrderServiceImpl();
		pizzaOrderServiceImpl.setDeliveryTimeService(basicDeliveryTimeServiceImpl());
		pizzaOrderServiceImpl.setMailSender(mailSender());
		pizzaOrderServiceImpl.setMessageTemplate(simpleMessageTemplateService());
		pizzaOrderServiceImpl.setOrderFactory(orderFactory());
		pizzaOrderServiceImpl.setOrderRepository(hashMapOrderRepository());
		return pizzaOrderServiceImpl;
		
	}
	
	@Bean
	public PizzaTypeDeliveryTimeStrategy pizzaTypeDeliveryTimeStrategy() {
		
		return new PizzaTypeDeliveryTimeStrategy();
	}
	
}
