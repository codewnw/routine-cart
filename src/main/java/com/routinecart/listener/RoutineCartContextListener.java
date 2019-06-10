package com.routinecart.listener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.routinecart.service.BaseDataService;
import com.routinecart.service.ItemService;

public class RoutineCartContextListener {

	private final BaseDataService baseDataService;

	public RoutineCartContextListener(BaseDataService baseDataService) {
		this.baseDataService = baseDataService;
	}

	@EventListener({ ContextRefreshedEvent.class, ContextStartedEvent.class })
	public void handleContextRefreshEvent() {
		baseDataService.createBaseData();
	}
}
