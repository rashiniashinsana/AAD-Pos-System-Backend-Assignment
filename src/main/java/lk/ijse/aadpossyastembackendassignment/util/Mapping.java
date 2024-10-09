package lk.ijse.aadpossyastembackendassignment.util;


import lk.ijse.aadpossyastembackendassignment.dto.impl.CustomerDTO;
import lk.ijse.aadpossyastembackendassignment.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO convertToDTO(CustomerEntity customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public List<CustomerDTO> convertToDTO(List<CustomerEntity> customers) {
        return modelMapper.map(customers, new TypeToken<List<CustomerDTO>>()   {}.getType());
    }

    public CustomerEntity convertToCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }
}
