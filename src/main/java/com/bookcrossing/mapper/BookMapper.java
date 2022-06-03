package com.bookcrossing.mapper;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.model.BookModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);

    BookDTO bookModelToBookDTO(BookModel bookModel);
}
