package com.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

@Entity
@TypeDefs({
	  @TypeDef(name = "json", typeClass = JsonStringType.class),
	  @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
	})
public class Reservation {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	@Column(name="movie_title")
	public String movieTitle;
	public String showtime;
	@Column(columnDefinition = "json")
	@Type(type = "json")
	private String[] seats;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getShowtime() {
		return showtime;
	}
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
	public String[] getSeats() {
		return seats;
	}
	public void setSeats(String[] seats) {
		this.seats = seats;
	}
	

}
