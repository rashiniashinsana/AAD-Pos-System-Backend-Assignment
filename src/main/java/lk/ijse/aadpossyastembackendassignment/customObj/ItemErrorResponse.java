package lk.ijse.aadpossyastembackendassignment.customObj;



import java.io.Serializable;

public class ItemErrorResponse implements ItemResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
