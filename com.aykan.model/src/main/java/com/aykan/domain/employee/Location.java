package com.aykan.domain.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id", nullable = false, unique = true)
    private Long locationId;
    @Column(length = 25)
    private String streetAddress;
    @Column(name = "postalCode")
    private int postalCode;
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private List<Department> departments;

    public Location() {
    }

    public Location(String streetAddress, int postalCode, String city) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        return getLocationId() != null ? getLocationId().equals(location.getLocationId()) : location.getLocationId() == null;
    }

    @Override
    public int hashCode() {
        return getLocationId() != null ? getLocationId().hashCode() : 0;
    }
}
