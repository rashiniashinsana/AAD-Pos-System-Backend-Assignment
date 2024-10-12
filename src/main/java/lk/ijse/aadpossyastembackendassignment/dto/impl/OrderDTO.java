package lk.ijse.aadpossyastembackendassignment.dto.impl;

import lk.ijse.aadpossyastembackendassignment.customObj.OrderResponse;
import lk.ijse.aadpossyastembackendassignment.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO, OrderResponse {
    private String id;
    private String date;
    private String customerId;
    private double total;
    private String discount;
    private double subTotal;
    private double cash;
    private double balance;
}
