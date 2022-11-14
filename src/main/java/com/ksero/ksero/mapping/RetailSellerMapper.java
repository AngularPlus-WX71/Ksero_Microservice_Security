package com.ksero.ksero.mapping;

import com.ksero.ksero.resources.retail_seller.RetailSellerResource;
import com.ksero.ksero.resources.retail_seller.UpdateRetailSellerResource;
import com.ksero.shared.mapping.EnhancedModelMapper;
import com.ksero.ksero.domain.model.entity.RetailSeller;
import com.ksero.ksero.resources.retail_seller.CreateRetailSellerResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class RetailSellerMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public RetailSellerResource toResource(RetailSeller model) {
        return mapper.map(model, RetailSellerResource.class);
    }

    public List<RetailSellerResource> toResource(List<RetailSeller> model){
        return mapper.mapList(model, RetailSellerResource.class);
    }

    public RetailSeller toModel(CreateRetailSellerResource resource) {
        return mapper.map(resource, RetailSeller.class);
    }

    public RetailSeller toModel(UpdateRetailSellerResource resource) {
        return mapper.map(resource, RetailSeller.class);
    }
}
