package ra.springthymeleaf.model.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "dmKhoa")
public class Department {
    @Id
    @Column(name = "MaKhoa",columnDefinition = "char(2)")
    private String id;
    @Column(name = "tenKhoa", length = 30)
    private String name;

}
