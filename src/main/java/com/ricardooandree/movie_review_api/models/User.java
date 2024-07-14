package com.ricardooandree.movie_review_api.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = User.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;


    @Column(name = "username", length = 100, unique = true, nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String username;


    @Column(name = "password", length = 6, nullable = false)
    @NotBlank
    @Size(min = 8, max = 60)
    private String password;

    
    @OneToMany(mappedBy = TABLE_NAME)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<Review> reviews = new ArrayList<>();
    
}
