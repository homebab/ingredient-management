package com.homebab.server.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
@NoArgsConstructor

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

    private Integer shelfLife;

    private String memo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user = new User();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item = new Item();

    private static UserItem addUserItem(Item item, Optional<LocalDateTime> expiredAt, Optional<Integer> shelfLife, Optional<String> memo) {
        UserItem userItem = new UserItem();
        userItem.setItem(item);
        userItem.setExpiredAt(expiredAt.orElse(null));
        userItem.setShelfLife(shelfLife.orElse(null));
        userItem.setMemo(memo.orElse(null));

        return userItem;
    }
}
