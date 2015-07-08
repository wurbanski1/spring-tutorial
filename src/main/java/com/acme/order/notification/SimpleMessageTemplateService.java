package com.acme.order.notification;

import lombok.Setter;

public class SimpleMessageTemplateService implements MessageTemplateService {
	
	@Setter
	private DeliveryTemplate deliveryTemplate;
	@Setter
	private OrderCancelledTemplate cancelDeliveryTemplate;

	public SimpleMessageTemplateService() {
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
