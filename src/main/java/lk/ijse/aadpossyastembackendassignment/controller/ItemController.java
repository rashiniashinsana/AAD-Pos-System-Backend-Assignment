package lk.ijse.aadpossyastembackendassignment.controller;


import lk.ijse.aadpossyastembackendassignment.customObj.ItemResponse;
import lk.ijse.aadpossyastembackendassignment.dto.impl.ItemDTO;
import lk.ijse.aadpossyastembackendassignment.exception.CustomerNotFoundException;
import lk.ijse.aadpossyastembackendassignment.exception.DataPersistFailedException;
import lk.ijse.aadpossyastembackendassignment.exception.ItemNotFound;
import lk.ijse.aadpossyastembackendassignment.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/items")
@RequiredArgsConstructor
public class ItemController {
    @Autowired
    private final ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addItem(@RequestBody ItemDTO item) {

            try {
                itemService.saveItem(item);
                System.out.println("ItemDto"+item);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (DataPersistFailedException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems(){
        return itemService.getAllItems();
    }
    @GetMapping(value = "/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResponse getSelectedItem(@PathVariable("itemId") String itemId) {
        {
            return itemService.getSelectedItem(itemId);
        }

    }

     @PatchMapping(value = "/{itemCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateItem(@PathVariable ("itemCode") String itemId, @RequestBody ItemDTO itemDTO) {
         try {
             itemDTO.setCode(itemId);
             itemService.updateItem(itemDTO);

             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         } catch (CustomerNotFoundException e) {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         } catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }

    @DeleteMapping(value ="/{itemId}" )
    public ResponseEntity<Void> deleteItem(@PathVariable ("itemId") String itemId) {
        try {
            itemService.deleteItem(itemId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
