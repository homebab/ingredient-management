package com.omtm.server.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "userItems")
@ToString(exclude = "userItems")

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

    @NonNull
    @Email(message = "invalid email")
    private String email;

    @NonNull
    private String name;

    private Integer age;

    private String gender;

    private String imageUrl;

    @NonNull
    private boolean active = true;

    @JsonManagedReference
    @OneToMany (mappedBy = "user", fetch = FetchType.LAZY)
    private final Set<UserItem> userItems = new HashSet<>();

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }

}
