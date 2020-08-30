package com.homebab.server.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@ToString()

@Entity
@Table(schema = "public", name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String email;

    private String name;

    private Integer age;

    private String gender;

    private String imageUrl;


    @OneToMany (mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Item> items = new HashSet<Item>();

    public void addItem(Item item) {
        items.add(item);
        item.setUser(this);
    }

}
