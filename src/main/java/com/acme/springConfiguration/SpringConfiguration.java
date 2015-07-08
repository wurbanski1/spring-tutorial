package com.acme.springConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.order.HashMapOrderRepository;
import com.acme.order.OrderFactory;
import com.acme.order.delivery.BasicDeliveryTimeServiceImpl;
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
	public HashMapOrderRepository hashMapOrderRepository() {
		return new HashMapOrderRepository();
	}
	
	@Bean
	public BasicDeliveryTimeServiceImpl basicDeliveryTimeServiceImpl() {
		return new BasicDeliveryTimeServiceImpl(timeService());
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
		return new SimpleMessageTemplateService();
	}
	
	@Bean
	public MailSender mailSender() {
		return new MailSender();
	}
	
	@Bean
	public PizzaOrderServiceImpl pizzaOrderServiceImpl() {
		return new PizzaOrderServiceImpl();
	}
	
	@Bean
	public PizzaTypeDeliveryTimeStrategy pizzaTypeDeliveryTimeStrategy() {
		return new PizzaTypeDeliveryTimeStrategy();
	}
	
}
