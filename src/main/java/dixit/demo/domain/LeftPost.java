package dixit.demo.domain;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@DiscriminatorValue("left")
@Entity
public class LeftPost extends Post{
}
