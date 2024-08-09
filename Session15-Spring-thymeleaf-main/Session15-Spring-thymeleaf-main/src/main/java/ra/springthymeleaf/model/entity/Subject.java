package ra.springthymeleaf.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "dmmh")
public class Subject {
    @Id
    @Column(name = "MaMH",columnDefinition = "char(2)")
    private String id;
    @Column(name = "tenMH", length = 25)
    private String name;
    @Column(name = "soTiet")
    private byte countLessons;
}
