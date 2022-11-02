package google.drive.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="DashBoard_table")
@Data
public class DashBoard {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long fileSize;
        private String fileName;
        private Boolean isIndexed;
        private Boolean isUploaded;
        private String videoUrl;


}