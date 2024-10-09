package lk.ijse.aadpossyastembackendassignment.util;


import java.util.Base64;
import java.util.UUID;

public class AppUtil {

    public static String createCustomerId(){
        return "CUSTOMER-"+ UUID.randomUUID();
    }

    public static String toBase64ProfilePic(String profilePic){
        return Base64.getEncoder().encodeToString(profilePic.getBytes());
    }
}
