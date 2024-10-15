package lk.ijse.aadpossyastembackendassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.aadpossyastembackendassignment.dao.CustomerDAO;
import lk.ijse.aadpossyastembackendassignment.dao.ItemDAO;
import lk.ijse.aadpossyastembackendassignment.dao.OrderDAO;
import lk.ijse.aadpossyastembackendassignment.dao.OrderDetailsDAO;
import lk.ijse.aadpossyastembackendassignment.dto.impl.OrderDTO;
import lk.ijse.aadpossyastembackendassignment.entity.CustomerEntity;
import lk.ijse.aadpossyastembackendassignment.entity.ItemEntity;
import lk.ijse.aadpossyastembackendassignment.entity.OrderDetailsEntity;
import lk.ijse.aadpossyastembackendassignment.exception.DataPersistFailedException;
import lk.ijse.aadpossyastembackendassignment.service.OrderService;
import lk.ijse.aadpossyastembackendassignment.util.AppUtil;
import lk.ijse.aadpossyastembackendassignment.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderDAO orderDAO;
    @Autowired
    private final CustomerDAO customerDAO;
    @Autowired
    private final ItemDAO itemDAO;
    @Autowired
    private final OrderDetailsDAO orderDetailsDAO;

    @Autowired
    private final Mapping mapping;
    @Override
    @Transactional
    public void saveOrders(OrderDTO orderDto) {
//        orderDAO.setId(AppUtil.createCustomerId());
//        CustomerEntity savedCustomer =
//                customerDAO.save(mapping.convertToCustomerEntity(customerDTO));
//        if(savedCustomer == null ) {
//            throw new DataPersistFailedException("Cannot data saved");
//        }
    }

    @Override
    public List<OrderDTO> getAllOrders()  {
        return mapping.convertToOrderDTOList(orderDAO.findAll());
    }
}
