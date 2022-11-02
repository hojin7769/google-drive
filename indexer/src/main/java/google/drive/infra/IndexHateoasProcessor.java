package google.drive.infra;
import google.drive.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class IndexHateoasProcessor implements RepresentationModelProcessor<EntityModel<Index>>  {

    @Override
    public EntityModel<Index> process(EntityModel<Index> model) {

        
        return model;
    }
    
}
