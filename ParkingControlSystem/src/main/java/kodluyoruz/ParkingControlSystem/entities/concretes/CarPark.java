package kodluyoruz.ParkingControlSystem.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="car_parks")
public class CarPark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="update_date")
    private Date updateDate;

    @Column(name="capacity")
    private int capacity;

    @Column(name="unit_price")
    private float unitPrice;

    @ManyToOne()
    @JoinColumn(name="owner_id")
    private Owner owner;
    
    @OneToMany(mappedBy="carPark")
    private List<ParkLayout> parkLayouts;
}