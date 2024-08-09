package ra.springthymeleaf.model.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "dmsv")
public class Student {
    @Id
    @Column(name = "MaSV",columnDefinition = "char(3)")
    private String id;
    @Column(name = "hoSV",length = 15)
    private String firstName;
    @Column(name = "tenSV", length = 7)
    private String lastName;
    @Column(name = "phai", columnDefinition = "char(7)")
    private String sex;
    @Column(name = "ngaysinh")
    private Date birthday;
    @Column(name = "noisinh",length = 20)
    private String homeTown;
    @ManyToOne // earge
//    @OneToMany // lazy
//    @OneToOne // Earge
//    @ManyToMany // lazy
    @JoinColumn(name ="MaKhoa",foreignKey = @ForeignKey(name = "DMKhoa_MaKhoa_fk"))
    private Department department;
    @Column(name = "hocbong")
    private float scholarship;
}
