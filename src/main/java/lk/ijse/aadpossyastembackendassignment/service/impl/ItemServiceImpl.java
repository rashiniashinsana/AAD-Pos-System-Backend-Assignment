package lk.ijse.aadpossyastembackendassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.aadpossyastembackendassignment.customObj.ItemErrorResponse;
import lk.ijse.aadpossyastembackendassignment.customObj.ItemResponse;
import lk.ijse.aadpossyastembackendassignment.dao.ItemDAO;
import lk.ijse.aadpossyastembackendassignment.dto.impl.ItemDTO;
import lk.ijse.aadpossyastembackendassignment.entity.CustomerEntity;
import lk.ijse.aadpossyastembackendassignment.entity.ItemEntity;
import lk.ijse.aadpossyastembackendassignment.exception.CustomerNotFoundException;
import lk.ijse.aadpossyastembackendassignment.exception.DataPersistFailedException;
import lk.ijse.aadpossyastembackendassignment.exception.ItemNotFound;
import lk.ijse.aadpossyastembackendassignment.service.ItemService;
import lk.ijse.aadpossyastembackendassignment.util.AppUtil;
import lk.ijse.aadpossyastembackendassignment.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
   @Autowired
   private ItemDAO itemDAO;
   @Autowired
   private Mapping mapping;
   @Override
    public void saveItem(ItemDTO itemDTO){
       itemDTO.setCode(AppUtil.createItemId());
       var itemEntity = mapping.convertToEntity(itemDTO);
      System.out.println("itemEntity = " + itemEntity);
       var savedItem = itemDAO.save(itemEntity);
      System.out.println("SavedItem: " + savedItem);
       if(savedItem == null){
           throw new DataPersistFailedException("Cannot save note");
       }
   }

   @Override
   public List<ItemDTO> getAllItems() {
      return mapping.convertToDTO(itemDAO.findAll());

   }


   @Override
   public ItemResponse getSelectedItem(String itemId) {

      if(itemDAO.existsById(itemId)){
         return mapping.convertToDTO(itemDAO.getReferenceById(itemId));
      }else {
         return new ItemErrorResponse(0,"Item not found");
      }
   }

   @Override
   public void deleteItem(String itemId) {
       Optional<ItemEntity> selectedItemId = itemDAO.findById(itemId);
       if (!selectedItemId.isPresent()) {
           throw new ItemNotFound("Item not found");
       } else {
           itemDAO.deleteById(itemId);
       }

   }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        Optional<ItemEntity> tmpItem = itemDAO.findById(itemDTO.getCode());
        if (!tmpItem.isPresent()) {
            throw new ItemNotFound("Customer not found");
        } else {
            tmpItem.get().setCode(itemDTO.getCode());
            tmpItem.get().setName(itemDTO.getName());
            tmpItem.get().setPrice(itemDTO.getPrice());
            tmpItem.get().setQty(itemDTO.getQty());
        }
    }

}
