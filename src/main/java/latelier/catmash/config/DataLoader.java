package latelier.catmash.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import latelier.catmash.model.Cat;
import latelier.catmash.repository.CatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private CatRepository catRepository;
    private ObjectMapper objectMapper;

    public DataLoader(CatRepository catRepository, ObjectMapper objectMapper) {
        this.catRepository = catRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * Import data from "/dataEntry/cats.json" into database at launch
     */
    @Override
    public void run(String... args) throws Exception {

        ClassPathResource resource =
                new ClassPathResource("dataEntry/cats.json");

        try (InputStream is = resource.getInputStream()) {

            CatsWrapper wrapper = objectMapper.readValue(is, CatsWrapper.class);

            List<Cat> cats = wrapper.getImages();

            catRepository.saveAll(cats);
        }
    }
}