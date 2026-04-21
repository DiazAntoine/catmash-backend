package latelier.catmash.mapper;

import org.mapstruct.Mapper;

import latelier.catmash.dto.CatDTO;
import latelier.catmash.model.Cat;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatMapper {

    Cat dtoToEntity (CatDTO catDTO);

    CatDTO entityToDTO (Cat cat);

    List<CatDTO> entitiesToDTOs (List<Cat> cat);
}