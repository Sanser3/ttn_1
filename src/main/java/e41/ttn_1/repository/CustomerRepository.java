package e41.ttn_1.repository;

import e41.ttn_1.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {
    public List<Customers> findByNameAndAddress(String name, String address);
}
