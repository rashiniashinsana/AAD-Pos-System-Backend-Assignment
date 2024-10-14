package lk.ijse.aadpossyastembackendassignment.util;


import lk.ijse.aadpossyastembackendassignment.dto.impl.CustomerDTO;
import lk.ijse.aadpossyastembackendassignment.dto.impl.ItemDTO;
import lk.ijse.aadpossyastembackendassignment.dto.impl.OrderDTO;
import lk.ijse.aadpossyastembackendassignment.dto.impl.OrderDetailsDTO;
import lk.ijse.aadpossyastembackendassignment.entity.CustomerEntity;
import lk.ijse.aadpossyastembackendassignment.entity.ItemEntity;
import lk.ijse.aadpossyastembackendassignment.entity.OrderDetailsEntity;
import lk.ijse.aadpossyastembackendassignment.entity.OrderEntity;
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

    public List<CustomerDTO> convertToDTOList(List<CustomerEntity> customers) {
        return modelMapper.map(customers, new TypeToken<List<CustomerDTO>>()   {}.getType());
    }

    public CustomerEntity convertToCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }
    //matters of ItemEntity and DTO
    public ItemDTO convertToDTO(ItemEntity note) {
        return modelMapper.map(note, ItemDTO.class);
    }
    public ItemEntity convertToEntity(ItemDTO dto) {
        return modelMapper.map(dto, ItemEntity.class);
    }
    public List<ItemDTO> convertToDTO(List<ItemEntity> notes) {
        return modelMapper.map(notes, new TypeToken<List<ItemDTO>>() {}.getType());
    }

    //matters of Order
    public OrderDTO convertToOrderDTO(OrderEntity order) {
        return modelMapper.map(order, OrderDTO.class);
    }
    public OrderEntity convertToOrderEntity(OrderDTO dto) {
        return modelMapper.map(dto, OrderEntity.class);
    }
    public List<OrderDTO> convertToOrderDTOList(List<OrderEntity> orders) {
        return modelMapper.map(orders, new TypeToken<List<OrderDTO>>() {}.getType());
    }
    public OrderDetailsEntity convertToOrderDetailEntity(OrderDetailsDTO dto) {
        return modelMapper.map(dto, OrderDetailsEntity.class);
    }
    public OrderDetailsDTO convertToOrderDetailDto(OrderEntity entity) {
        return modelMapper.map(entity, OrderDetailsDTO.class);
    }
    public List<OrderDetailsDTO> convertToOrderDetailDTOList(List<OrderDetailsEntity> orders) {
        return modelMapper.map(orders, new TypeToken<List<OrderDetailsDTO>>() {}.getType());
    }
}
