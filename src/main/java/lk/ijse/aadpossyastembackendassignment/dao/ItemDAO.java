package lk.ijse.aadpossyastembackendassignment.dao;

import lk.ijse.aadpossyastembackendassignment.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends JpaRepository<ItemEntity, String> {
}
