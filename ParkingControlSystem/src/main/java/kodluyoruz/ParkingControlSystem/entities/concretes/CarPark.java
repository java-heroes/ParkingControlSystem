package kodluyoruz.ParkingControlSystem.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="car_parks")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","parkLayout"})
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

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name="owner_id")
    private Owner owner;
    
    @JsonManagedReference
    @OneToMany(mappedBy="carPark", cascade = CascadeType.REMOVE)
    private List<ParkLayout> parkLayouts;
}