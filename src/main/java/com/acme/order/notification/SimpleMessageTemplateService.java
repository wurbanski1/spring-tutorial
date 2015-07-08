package com.acme.order.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class SimpleMessageTemplateService implements MessageTemplateService {
	
	@Setter
	//@Autowired
	private DeliveryTemplate deliveryTemplate;
	@Setter
	//@Autowired
	private OrderCancelledTemplate cancelDeliveryTemplate;

	public SimpleMessageTemplateService() {
	}
	@Autowired
	SimpleMessageTemplateService(DeliveryTemplate deliveryTemplate,OrderCancelledTemplate orderCancelledTemplate){
		
	}

	@Override
	public DeliveryTemplate getDeliveryTemplate() {
		return deliveryTemplate;
	}

	@Override
	public OrderCancelledTemplate getCancelTemplate() {
		return cancelDeliveryTemplate;
	}

}
