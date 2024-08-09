package ra.springthymeleaf.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Embeddable
public class MarkId implements Serializable {
    @Column(name = "MaSV")
    private String studentId;
    @Column(name = "MaMH")
    private String subjectId;
    @Column(name = "LanThi")
    private byte times;
}
