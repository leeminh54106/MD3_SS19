package ra.springthymeleaf.model.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class StudentResponse {
    private String id;
    private String firstName;
    private String lastName;
    private Date birthday;
}
