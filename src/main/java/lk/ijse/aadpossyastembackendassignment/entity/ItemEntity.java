package lk.ijse.aadpossyastembackendassignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class ItemEntity  implements SuperEntity{
    @Id
    private String code;
    private String name;
    private BigDecimal price;
    private String status;
    private int qty;
}
