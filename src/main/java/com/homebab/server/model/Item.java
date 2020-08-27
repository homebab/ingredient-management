package com.homebab.server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
//@EqualsAndHashCode(exclude = "recipes")

@Entity
@Table(schema = "public", name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String name;

    private Boolean sensitivity;


//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "items")
//    @JsonIgnoreProperties("items")
//    private Set<Recipe> recipes = new HashSet<>();
//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "items")
//    @JsonIgnoreProperties("items")
//    private Set<User> users = new HashSet<>();
}
