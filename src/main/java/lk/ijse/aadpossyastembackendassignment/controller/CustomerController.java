package lk.ijse.aadpossyastembackendassignment.controller;

import lk.ijse.aadpossyastembackendassignment.dto.impl.CustomerDTO;
import lk.ijse.aadpossyastembackendassignment.exception.DataPersistFailedException;
import lk.ijse.aadpossyastembackendassignment.service.CustomerService;
import lk.ijse.aadpossyastembackendassignment.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    private final CustomerService customerService;
    //Save Customer
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveCustomer(
            @RequestPart("Id") String Id,
            @RequestPart("name") String Name,
            @RequestPart("address") String Address,
            @RequestPart("salary") Double Salary){
        try {
//            //byte [] imageByteCollection = profilePic.getBytes();
//            String base64ProfilePic = AppUtil.toBase64ProfilePic(profilePic);
//            // build the user object
            CustomerDTO buildCustomerDTO = new CustomerDTO();
            buildCustomerDTO.setId(Id);
            buildCustomerDTO.setName(Name);
            buildCustomerDTO.setAddress(Address);
            buildCustomerDTO.setSalary(Salary);

            //send to the service layer
            customerService.saveCustomer(buildCustomerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
