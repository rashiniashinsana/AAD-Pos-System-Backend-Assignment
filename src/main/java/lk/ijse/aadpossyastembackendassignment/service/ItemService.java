package lk.ijse.aadpossyastembackendassignment.service;

import lk.ijse.aadpossyastembackendassignment.customObj.ItemResponse;
import lk.ijse.aadpossyastembackendassignment.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    List<ItemDTO> getAllItems();

    ItemResponse getSelectedItem(String itemId);

    void deleteItem(String itemId);

    void updateItem(ItemDTO itemDTO);
}
