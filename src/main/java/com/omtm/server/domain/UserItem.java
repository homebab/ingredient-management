package com.omtm.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "user")
@ToString(exclude = "user")

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
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user = new User();

    public void setUser(User user) {
        this.user = user;
        user.getUserItems().add(this);
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item = new Item();

    public void setItem(Item item) {
        this.item = item;
    }

//    @Builder
//    public UserItem(LocalDateTime expiredAt, String name, String tag, Storage storage, String memo, String imageUrl) {
//        this.expiredAt = expiredAt;
//        this.name = name;
//        this.tag = tag;
//        this.storage = storage;
//        this.memo = memo;
//        this.imageUrl = imageUrl;
//    }

}
