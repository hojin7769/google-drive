package google.drive.infra;
import google.drive.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class FileHateoasProcessor implements RepresentationModelProcessor<EntityModel<File>>  {

    @Override
    public EntityModel<File> process(EntityModel<File> model) {

        
        return model;
    }
    
}
