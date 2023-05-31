import com.company.domain.Poster;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.PosterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PosterServiceTest {
    private final PosterService service = new PosterService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Poster>>> all = service.findAll(sort);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Poster>> responseEntity = service.findByID(id);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByColorTest() {
        String color = "white";
        ResponseEntity<DataDTO<List<Poster>>> responseEntity = service.findByColor(color);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void filterByPriceTest() {
        Double max = 25D;
        Double min = 15D;
        ResponseEntity<DataDTO<List<Poster>>> all = service.filterByPrice(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by price method is not passed!!");
    }

    @Test
    public void findByPurposeTest() {
        String purpose = "Political Posters";
        ResponseEntity<DataDTO<List<Poster>>> responseEntity = service.findByPurpose(purpose);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by purpose method is not passed!");
    }

    @Test
    public void filterByAudienceTest() {
        Integer max = 100;
        Integer min = 50;
        ResponseEntity<DataDTO<List<Poster>>> all = service.filterByAudience(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by audience method is not passed!!");
    }
}
