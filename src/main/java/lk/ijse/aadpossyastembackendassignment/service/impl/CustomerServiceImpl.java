package lk.ijse.aadpossyastembackendassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.aadpossyastembackendassignment.customObj.CustomerResponse;
import lk.ijse.aadpossyastembackendassignment.dao.CustomerDAO;
import lk.ijse.aadpossyastembackendassignment.dto.impl.CustomerDTO;
import lk.ijse.aadpossyastembackendassignment.entity.CustomerEntity;
import lk.ijse.aadpossyastembackendassignment.exception.CustomerNotFoundExeption;
import lk.ijse.aadpossyastembackendassignment.exception.DataPersistFailedException;
import lk.ijse.aadpossyastembackendassignment.service.CustomerService;
import lk.ijse.aadpossyastembackendassignment.util.AppUtil;
import lk.ijse.aadpossyastembackendassignment.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private final CustomerDAO customerDAO;
    @Autowired
    private final Mapping mapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO){
        customerDTO.setId(AppUtil.createCustomerId());
        CustomerEntity savedCustomer =
                customerDAO.save(mapping.convertToCustomerEntity(customerDTO));
        if(savedCustomer == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmpUser = customerDAO.findById(customerDTO.getId());
        if(!tmpUser.isPresent()){
            throw new CustomerNotFoundExeption("Customer not found");
        }else {
            tmpUser.get().setId(customerDTO.getId());
            tmpUser.get().setName(customerDTO.getName());
            tmpUser.get().setAddress(customerDTO.getAddress());
            tmpUser.get().setSalary(customerDTO.getSalary());
        }
    }

    @Override
    public void deleteCustomer(String customerId) {

        Optional<CustomerEntity> selectedCustomerId = customerDAO.findById(customerId);
        if(!selectedCustomerId.isPresent()){
            throw new CustomerNotFoundExeption("Customer not found");
        }else {
            customerDAO.deleteById(customerId);
        }
    }

    @Override
    public CustomerResponse getSelectedCustomer(String customerId) {
        if(customerDAO.existsById(customerId)){
            Optional<CustomerEntity> userEntityByUserId = customerDAO.findById(customerId);
            return mapping.convertToDTO(userEntityByUserId.orElse(null));
        }else {
            throw  new CustomerNotFoundExeption("Customer not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllUsers() {
        return List.of();
    }
}
