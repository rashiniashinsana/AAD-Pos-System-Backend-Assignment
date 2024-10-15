package lk.ijse.aadpossyastembackendassignment.dao;

import lk.ijse.aadpossyastembackendassignment.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<OrderEntity,String> {
}
