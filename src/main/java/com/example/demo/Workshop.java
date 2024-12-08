package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String date;
    private String time;
    private String tutor;
    private String slots;
    private String image; // To store the path of the uploaded image

	public Workshop(String title, String description, String date, String time, String tutor, String slots,
			String image) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.time = time;
		this.tutor = tutor;
		this.slots = slots;
		this.image = image;
	}
	// Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public String getTutor() { return tutor; }
    public void setTutor(String tutor) { this.tutor = tutor; }
    public String getSlots() { return slots; }
    public void setSlots(String slots) { this.slots = slots; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}