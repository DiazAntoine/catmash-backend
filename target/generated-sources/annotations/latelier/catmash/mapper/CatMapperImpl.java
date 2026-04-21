package latelier.catmash.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import latelier.catmash.dto.CatDTO;
import latelier.catmash.model.Cat;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-20T09:44:10+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 26 (Oracle Corporation)"
)
@Component
public class CatMapperImpl implements CatMapper {

    @Override
    public Cat dtoToEntity(CatDTO catDTO) {
        if ( catDTO == null ) {
            return null;
        }

        Cat cat = new Cat();

        cat.setId( catDTO.getId() );
        cat.setUrl( catDTO.getUrl() );
        cat.setScore( catDTO.getScore() );

        return cat;
    }

    @Override
    public CatDTO entityToDTO(Cat cat) {
        if ( cat == null ) {
            return null;
        }

        CatDTO catDTO = new CatDTO();

        catDTO.setId( cat.getId() );
        catDTO.setUrl( cat.getUrl() );
        catDTO.setScore( cat.getScore() );

        return catDTO;
    }

    @Override
    public List<CatDTO> entitiesToDTOs(List<Cat> cat) {
        if ( cat == null ) {
            return null;
        }

        List<CatDTO> list = new ArrayList<CatDTO>( cat.size() );
        for ( Cat cat1 : cat ) {
            list.add( entityToDTO( cat1 ) );
        }

        return list;
    }
}
