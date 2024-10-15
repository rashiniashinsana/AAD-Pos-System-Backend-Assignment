package lk.ijse.aadpossyastembackendassignment.dao;

import lk.ijse.aadpossyastembackendassignment.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsDAO extends JpaRepository<OrderDetailsEntity,String> {

}
