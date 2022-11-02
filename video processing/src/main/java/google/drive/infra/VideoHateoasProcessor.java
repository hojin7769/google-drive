package google.drive.infra;
import google.drive.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class VideoHateoasProcessor implements RepresentationModelProcessor<EntityModel<Video>>  {

    @Override
    public EntityModel<Video> process(EntityModel<Video> model) {

        
        return model;
    }
    
}
