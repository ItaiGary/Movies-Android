package com.example.movies;

public class Movie {

	private String title;
	private String rating;
	private String actors;
	private String image;
	
	
	public Movie() {}
	
	
	public Movie(String title, String rating, String actors, String image) {
		super();
		this.title = title;
		this.rating = rating;
		this.actors = actors;
		this.image = image;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	

	
}