package kodluyoruz.ParkingControlSystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="park_layouts")
@Entity
public class ParkLayout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//@Column(name="car_park_id")
	//private int carParkId;
	
	@Column(name="name")
	private char name;
	
	@ManyToOne()
	@JoinColumn(name="car_park_id")
	private CarPark carPark;
}
