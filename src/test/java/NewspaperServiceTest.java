import com.company.domain.Newspaper;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.NewspaperService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NewspaperServiceTest {
    private final NewspaperService service = new NewspaperService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Newspaper>>> all = service.findAll(sort);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Newspaper>> responseEntity = service.findByID(id);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByColorTest() {
        String color = "white";
        ResponseEntity<DataDTO<List<Newspaper>>> responseEntity = service.findByColor(color);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void filterByPriceTest() {
        Double max = 25D;
        Double min = 15D;
        ResponseEntity<DataDTO<List<Newspaper>>> all = service.filterByPrice(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by price method is not passed!!");
    }

    @Test
    public void findByTitleTest() {
        String title = "The Times";
        ResponseEntity<DataDTO<List<Newspaper>>> responseEntity = service.findByTitle(title);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by title method is not passed!");
    }
}
