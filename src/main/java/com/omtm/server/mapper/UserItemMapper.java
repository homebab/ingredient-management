package com.omtm.server.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserItemMapper {

//    private final ModelMapper modelMapper = new ModelMapper();
//
//    @Bean
//    public ModelMapper userItemMapper() {
//        // 매핑 전략 설정
//        modelMapper.getConfiguration()
//                .setMatchingStrategy(MatchingStrategies.STRICT);
//
//        modelMapper.createTypeMap(UserItem.class, UserItemDTO.class)
//                .addMapping(User::getName, UserDTO::setUserName);
//
//        return modelMapper;
//    }
}
