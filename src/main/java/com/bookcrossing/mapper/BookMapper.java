package com.bookcrossing.mapper;

import com.bookcrossing.dto.BookDTO;
import com.bookcrossing.model.BookModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);

    List<BookDTO> bookModelsToBookDTOs(List<BookModel> bookModel);

    BookDTO bookModelToBookDTO(BookModel bookModel);


}
