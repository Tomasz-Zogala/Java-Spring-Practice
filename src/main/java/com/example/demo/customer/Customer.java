package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {

    @Id
    private Long id;

    @NotBlank(message = "name must be not empty")
    private String name;

    @NotBlank(message = "password must be not empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank
    @Email(message = "email must be not empty")
    private String email;

    @JsonProperty("customer_id")
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
