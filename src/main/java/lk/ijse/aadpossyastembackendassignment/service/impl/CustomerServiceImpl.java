package lk.ijse.aadpossyastembackendassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.aadpossyastembackendassignment.customObj.CustomerErrorResponse;
import lk.ijse.aadpossyastembackendassignment.customObj.CustomerResponse;
import lk.ijse.aadpossyastembackendassignment.dao.CustomerDAO;
import lk.ijse.aadpossyastembackendassignment.dto.impl.CustomerDTO;
import lk.ijse.aadpossyastembackendassignment.entity.CustomerEntity;
import lk.ijse.aadpossyastembackendassignment.exception.CustomerNotFoundException;
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
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setId(AppUtil.createCustomerId());
        CustomerEntity savedCustomer =
                customerDAO.save(mapping.convertToCustomerEntity(customerDTO));
        if (savedCustomer == null) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmpCustomer = customerDAO.findById(customerDTO.getId());
        if (!tmpCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        } else {
            tmpCustomer.get().setId(customerDTO.getId());
            tmpCustomer.get().setName(customerDTO.getName());
            tmpCustomer.get().setAddress(customerDTO.getAddress());
            tmpCustomer.get().setSalary(customerDTO.getSalary());
        }
    }

    @Override
    public void deleteCustomer(String customerId) {

        Optional<CustomerEntity> selectedCustomerId = customerDAO.findById(customerId);
        if (!selectedCustomerId.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        } else {
            customerDAO.deleteById(customerId);
        }
    }

    @Override
    public CustomerResponse getSelectedCustomer(String customerId) {
        if (customerDAO.existsById(customerId)) {
            CustomerEntity customerEntity = customerDAO.getCustomerEntitiesById(customerId);
            return mapping.convertToDTO(customerEntity);
        } else {
            return new CustomerErrorResponse(0, "Customer not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity>getAllCustomers = customerDAO.findAll();
        return mapping.convertToDTOList(getAllCustomers);
    }



}
