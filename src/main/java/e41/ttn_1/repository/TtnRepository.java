package e41.ttn_1.repository;

import e41.ttn_1.entity.Customers;
import e41.ttn_1.entity.Orders;
import e41.ttn_1.entity.Ttns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TtnRepository extends JpaRepository<Ttns, Integer> {
    public List<Ttns> findTtnsByCreateTtn(LocalDate date);
    public Optional<Ttns> findTtnsByAccessKey(String accessKey);
}
