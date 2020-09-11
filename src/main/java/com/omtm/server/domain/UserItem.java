package com.omtm.server.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "user")
@ToString(exclude="user")

@Entity
@Table(schema = "public", name = "user_items")
public class UserItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime expiredAt;

    @NonNull
    private String name;

    private String tag;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Storage storage; // [FRIDGE, FREEZER, ROOM]

    private String memo;

    private String imageUrl;

//    private Boolean sensitivity;

    @NonNull
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user = new User();

    public void setUser(User user) {
        this.user = user;
        user.getUserItems().add(this);
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item = new Item();

    public void setItem(Item item) {
        this.item = item;
    }

}
