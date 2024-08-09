package ra.bai1.model.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//build ra doi tuong theo y minh
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;
    @Column(name = "name")
    @NotBlank(message = "Full name is empty")
    private String name;
    @Column(name = "price")
    @NotNull(message = "Price is null")
    private Double price;
    @Column(name = "stock")
    @NotNull(message = "Stock is null")
    private Integer stock;
    @Column(name = "created")
    @NotNull(message = "Created is null")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Past(message = "Created is not valid")
    private Date created;
    @Column(name = "image")
    private String image;
    @Column(name = "status")
    @NotNull(message = "Status is null")
    private Boolean status;
}
