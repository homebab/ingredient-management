package com.omtm.server.dto;

import com.omtm.server.domain.Storage;
import com.omtm.server.domain.UserItem;
import lombok.*;

import java.time.LocalDateTime;

public class UserItemDto {

    @Getter
    @Setter
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
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private LocalDateTime expiredAt;
        @NonNull
        private String name;
        private String tag;
        @NonNull
        private Storage storage; // [FRIDGE, FREEZER, ROOM]
        private String memo;
        private String imageUrl;
    }
}
