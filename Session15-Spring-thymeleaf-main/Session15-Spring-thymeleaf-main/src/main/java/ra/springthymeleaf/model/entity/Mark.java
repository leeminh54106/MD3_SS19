package ra.springthymeleaf.model.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "KetQua")
public class Mark { // chu the
    @EmbeddedId
    private MarkId markId;
    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name = "MaMH",foreignKey = @ForeignKey(name = "DMMH_MaMH_fk"))
    private Subject subject;
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "MaSV",foreignKey = @ForeignKey(name = "KetQua_MaSV_fk"))
    private Student student;
    @Column(name = "Diem",precision = 4,scale = 2)
    private BigDecimal score;
}
