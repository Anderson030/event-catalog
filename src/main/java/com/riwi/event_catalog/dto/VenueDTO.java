package com.riwi.event_catalog.dto;

public class VenueDTO {

    private Long id;
    private String name;
    private String city;   // <--- NUEVO
    private int capacity;

    public VenueDTO() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}
