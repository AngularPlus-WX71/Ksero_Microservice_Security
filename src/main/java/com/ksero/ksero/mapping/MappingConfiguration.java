package com.ksero.ksero.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration("kseroMappingConfiguration")
public class MappingConfiguration implements Serializable {


    @Bean
    public RetailSellerMapper retailSellerMapper() { return new RetailSellerMapper(); }

    @Bean
    public WholesalerMapper wholesalerMapper() {
        return new WholesalerMapper();
    }


}
