package com.bookcrossing.mapper;

import com.bookcrossing.dto.UsersDTO;
import com.bookcrossing.model.UsersModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UsersDTO usersToUsersDTO(UsersModel usersModel);
}
