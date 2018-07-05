package com.mkuligowski.inventory.config;

import com.mkuligowski.inventory.domain.Inventory;
import com.mkuligowski.inventory.service.InventoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public InventoryService inventory() {
        return new Inventory();
    }
}
