package lk.ijse.aadpossyastembackendassignment.dao;

import lk.ijse.aadpossyastembackendassignment.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity, String> {

}
