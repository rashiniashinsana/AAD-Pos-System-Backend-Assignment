package lk.ijse.aadpossyastembackendassignment.util;
import java.util.UUID;

public class AppUtil {

    public static String createCustomerId(){
        return "CUSTOMER-"+ UUID.randomUUID();
    }

}
