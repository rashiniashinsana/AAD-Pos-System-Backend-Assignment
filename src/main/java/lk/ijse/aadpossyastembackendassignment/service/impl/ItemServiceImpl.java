package lk.ijse.aadpossyastembackendassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.aadpossyastembackendassignment.customObj.ItemResponse;
import lk.ijse.aadpossyastembackendassignment.dao.ItemDAO;
import lk.ijse.aadpossyastembackendassignment.dto.impl.ItemDTO;
import lk.ijse.aadpossyastembackendassignment.exception.DataPersistFailedException;
import lk.ijse.aadpossyastembackendassignment.service.ItemService;
import lk.ijse.aadpossyastembackendassignment.util.AppUtil;
import lk.ijse.aadpossyastembackendassignment.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
   @Autowired
   private ItemDAO itemDAO;
   @Autowired
   private Mapping mapping;
   @Override
    public void saveItem(ItemDTO itemDTO){
       itemDTO.setCode(AppUtil.createCustomerId());
       var itemEntity = mapping.convertToEntity(itemDTO);
       var savedNoted = itemDAO.save(itemEntity);
       if(savedNoted == null){
           throw new DataPersistFailedException("Cannot save note");
       }
   }

   @Override
   public List<ItemDTO> getAllItems() {
      return List.of();
   }

   @Override
   public ItemResponse getSelectedNote(String noteId) {
      return null;
   }

   @Override
   public void updateItem(String itemId, ItemDTO item) {

   }

   @Override
   public void deleteItem(String itemId) {

   }
}
