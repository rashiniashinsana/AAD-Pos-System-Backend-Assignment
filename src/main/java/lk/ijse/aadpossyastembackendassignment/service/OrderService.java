package lk.ijse.aadpossyastembackendassignment.service;


import lk.ijse.aadpossyastembackendassignment.dto.impl.OrderDTO;

import java.util.List;

public interface OrderService {
    void saveOrders(OrderDTO orderDto);
    List<OrderDTO> getAllOrders();

}
