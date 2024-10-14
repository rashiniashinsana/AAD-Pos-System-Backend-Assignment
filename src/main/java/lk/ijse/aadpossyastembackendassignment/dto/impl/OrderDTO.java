package lk.ijse.aadpossyastembackendassignment.dto.impl;

import lk.ijse.aadpossyastembackendassignment.customObj.OrderResponse;
import lk.ijse.aadpossyastembackendassignment.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO, OrderResponse {
    private String id;
    private Timestamp date;
    private String customerId;
    private List<OrderDetailsDTO> orderDetailDTOS = new ArrayList<>();
    private double total;
    private double discount;
    private double subTotal;
    private double cash;
    private double balance;
}
