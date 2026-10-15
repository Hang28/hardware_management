package com.chongbangkyak.hardware_store.customer;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "customers")
@SQLRestriction("deleted = false")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer name is required.")
    @Size(max = 50, message = "Name cannot exceed 50 characters.")
    @Column(nullable = false, length = 50)
    private String fullname;

    @NotBlank(message = "Email is required.")
    @Email(message = "Please enter a valid email address.")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Phone number is required.")
    @Pattern(
            regexp = "^\\+9779[78][0-9]{8}$",
            message = "Enter a valid Nepalese phone number starting with +977 97 or +977 98."
    )
    @Column(nullable = false, length = 13)
    private String phone;

    @Size(max = 50, message = "Address cannot exceed 50 characters.")
    @Column(length = 50)
    private String address;

    @Column(nullable = false)
    private boolean deleted = false;

    public Customer() {
    }

    public Customer(String fullname, String email, String phone, String address) {
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }
}