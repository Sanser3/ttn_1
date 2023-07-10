package e41.ttn_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ttns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "customers_id")
    private Customers customers;
    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;
    @Column(updatable = false)
    private LocalDateTime createTtn;
}
