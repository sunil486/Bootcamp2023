package com.sunil486.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Actors")
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int actor_id;
	private String actor_name;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "Movies_Actors", 
			joinColumns = @JoinColumn(name = "actor_id"),
			inverseJoinColumns=@JoinColumn(name="movie_id")
			)
	List<Movie> movies;

	public Actor(String actor_name) {
		this.actor_name = actor_name;
	}

	public int getActor_id() {
		return actor_id;
	}

	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}

	public String getActor_name() {
		return actor_name;
	}

	public void setActor_name(String actor_name) {
		this.actor_name = actor_name;
	}
}
