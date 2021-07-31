package kodluyoruz.ParkingControlSystem.entities.concretes;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rental_details")
public class RentalDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "total_price")
	private float totalPrice;

	@Column(name = "payment_price")
	private float paymentPrice;

	@Column(name = "payment_date")
	private Date paymentDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="ParkRental",joinColumns= {@JoinColumn(name="id")})
	private ParkRental parkRental;

}
