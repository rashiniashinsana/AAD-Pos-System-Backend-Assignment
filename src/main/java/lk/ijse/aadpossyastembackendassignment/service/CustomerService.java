package lk.ijse.aadpossyastembackendassignment.service;

import lk.ijse.aadpossyastembackendassignment.customObj.CustomerResponse;
import lk.ijse.aadpossyastembackendassignment.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    CustomerResponse getSelectedCustomer(String customerId);
    List<CustomerDTO> getAllUsers();
}
