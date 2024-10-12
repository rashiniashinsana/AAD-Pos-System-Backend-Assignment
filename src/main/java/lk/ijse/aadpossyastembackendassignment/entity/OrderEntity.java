package lk.ijse.aadpossyastembackendassignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity{
    @Id
    private String id;
    private String date;
    private String customerId;
    private double total;
    private String discount;
    private double subTotal;
    private double cash;
    private double balance;
}
