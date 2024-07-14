package com.ricardooandree.movie_review_api.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Review.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {
    private static final String TABLE_NAME = "review";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;


    @Column(name = "movie", length = 155, unique = true, nullable = false)
    @NotBlank
    @Size(min = 3, max = 155)
    private String movie;


    @Column(name = "comment", length = 255, nullable = false)
    @NotBlank
    @Size(min = 3, max = 155)
    private String comment;


    @Column(name = "score", nullable = false)
    @NotBlank
    private int score;

}
