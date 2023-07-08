package e41.ttn_1.repository;

import e41.ttn_1.entity.Ttns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TtnRepository extends JpaRepository<Ttns, Integer> {
}
