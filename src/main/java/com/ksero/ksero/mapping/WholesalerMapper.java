package com.ksero.ksero.mapping;

import com.ksero.shared.mapping.EnhancedModelMapper;
import com.ksero.ksero.domain.model.entity.Wholesaler;
import com.ksero.ksero.resources.wholesaler.CreateWholesalerResource;
import com.ksero.ksero.resources.wholesaler.UpdateWholesalerResource;
import com.ksero.ksero.resources.wholesaler.WholesalerResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class WholesalerMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public WholesalerResource toResource(Wholesaler model){
        return mapper.map(model, WholesalerResource.class);
    }

    public List<WholesalerResource> toResource(List<Wholesaler> model){
        return mapper.mapList(model, WholesalerResource.class);
    }

    public Wholesaler toModel(CreateWholesalerResource resource){
        return mapper.map(resource, Wholesaler.class);
    }

    public Wholesaler toModel(UpdateWholesalerResource resource){
        return mapper.map(resource, Wholesaler.class);
    }

}
