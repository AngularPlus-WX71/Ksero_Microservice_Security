package com.example.kseromicroservicesecurity.ksero.mapping;

import com.example.kseromicroservicesecurity.shared.mapping.EnhancedModelMapper;
import com.example.kseromicroservicesecurity.ksero.domain.model.entity.Wholesaler;
import com.example.kseromicroservicesecurity.ksero.resources.wholesaler.CreateWholesalerResource;
import com.example.kseromicroservicesecurity.ksero.resources.wholesaler.UpdateWholesalerResource;
import com.example.kseromicroservicesecurity.ksero.resources.wholesaler.WholesalerResource;
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
