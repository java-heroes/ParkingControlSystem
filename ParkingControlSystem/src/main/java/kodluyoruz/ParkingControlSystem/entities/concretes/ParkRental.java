package kodluyoruz.ParkingControlSystem.entities.concretes;

import lombok.Data;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "park_rentals")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","rentalDetail"})
public class ParkRental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "rent_date")
	private Date rentDate;

	@Column(name = "end_date")
	private Date endDate;

	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "park_layout_id")
	private ParkLayout parkLayout;

	@JsonManagedReference
	@OneToOne(mappedBy="parkRental")
	private RentalDetail rentalDetail;
	 
}
