package kodluyoruz.ParkingControlSystem.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	
	@JsonBackReference
	@OneToOne()
	@JoinColumn(name="park_rental_id") 
	private ParkRental parkRental;
	
}
