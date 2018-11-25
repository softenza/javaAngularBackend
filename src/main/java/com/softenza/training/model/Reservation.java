package com.softenza.training.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVATION")
public class Reservation extends BaseEntity implements Comparable<Reservation> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESERVATION_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "RATING")
	private short rating = 0;

	// '0-Pending Approval, 1- Approved/Active, 2- Completed';
	@Column(name = "STATUS")
	private short status = 0;

	@Column(name = "COMMENT")
	private String comment;

	@Column(name = "FEEDBACK")
	private String feedback;

	@Column(name = "NBR_ROOMS")
	private Integer nbrRooms;

	@Column(name = "COST")
	private Double cost;

	@Column(name = "RESERVATION_DATE")
	private Date reservationDate;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public short getRating() {
		return rating;
	}

	public void setRating(short rating) {
		this.rating = rating;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Integer getNbrRooms() {
		return nbrRooms;
	}

	public void setNbrRooms(Integer nbrRooms) {
		this.nbrRooms = nbrRooms;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUserLastName() {
		return this.getUser().getLastName();
	}
	
	public String getUserFirstName() {
		return this.getUser().getFirstName();
	}
	
	public String getUserPhone() {
		return this.getUser().getPhone();
	}
	
	public String getUserEmail() {
		return this.getUser().getPhone();
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", rating=" + rating + ", status=" + status + ", comment=" + comment
				+ ", feedback=" + feedback + ", nbrRooms=" + nbrRooms + ", cost=" + cost + ", reservationDate="
				+ reservationDate + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public int compareTo(Reservation o) {
		// TODO Auto-generated method stub
		return o.reservationDate.compareTo(reservationDate);
	}

}
