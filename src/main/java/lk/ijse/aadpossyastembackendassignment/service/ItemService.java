package lk.ijse.aadpossyastembackendassignment.service;

import lk.ijse.aadpossyastembackendassignment.customObj.ItemResponse;
import lk.ijse.aadpossyastembackendassignment.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    List<ItemDTO> getAllItems();

    ItemResponse getSelectedNote(String noteId);

    void updateItem(String itemId, ItemDTO item);

    void deleteItem(String itemId);
}
