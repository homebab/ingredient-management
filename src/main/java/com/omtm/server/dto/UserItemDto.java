package com.omtm.server.dto;

import com.omtm.server.domain.Storage;
import com.omtm.server.domain.UserItem;
import lombok.Getter;

import java.time.LocalDateTime;

public class UserItemDto {

    @Getter
    public static class Response {
        private Long id;
        private Long userId;
        private Long itemId;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private LocalDateTime expiredAt;
        private String name;
        private String tag;
        private Storage storage; // [FRIDGE, FREEZER, ROOM]
        private String memo;
        private String imageUrl;

        public Response(UserItem useritem) {
            this.id = useritem.getId();
            this.userId = useritem.getUser().getId();
            this.itemId = useritem.getItem().getId();
            this.createdAt = useritem.getCreatedAt();
            this.updatedAt = useritem.getUpdatedAt();
            this.expiredAt = useritem.getExpiredAt();
            this.name = useritem.getName();
            this.tag = useritem.getTag();
            this.storage = useritem.getStorage();
            this.memo = useritem.getMemo();
            this.imageUrl = useritem.getImageUrl();
        }

    }
}
