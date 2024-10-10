package lk.ijse.aadpossyastembackendassignment.dto.impl;

import lk.ijse.aadpossyastembackendassignment.customObj.ItemResponse;
import lk.ijse.aadpossyastembackendassignment.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements SuperDTO, ItemResponse {

    private String code;
    private String name;
    private BigDecimal price;
    private String status;
    private int qty;
}
