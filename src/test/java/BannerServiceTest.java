import com.company.domain.Banner;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.BannerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BannerServiceTest {
    private final BannerService service = new BannerService();

    @Test
    public void findByAllTest() {
        String sort = "1";
        ResponseEntity<DataDTO<List<Banner>>> all = service.findAll(sort);
        Assertions.assertTrue(all.getData().isSuccess(), "Find all method is not passed!");
    }

    @Test
    public void findByIDTest() {
        Long id = 1L;
        ResponseEntity<DataDTO<Banner>> responseEntity = service.findByID(id);
        Assertions.assertTrue(responseEntity.getData().isSuccess(), "Find by id method is not passed!");
    }

    @Test
    public void findByColorTest() {
        String color = "white";
        ResponseEntity<DataDTO<List<Banner>>> responseEntity = service.findByColor(color);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by color method is not passed!");
    }

    @Test
    public void filterByPriceTest() {
        Double max = 25D;
        Double min = 15D;
        ResponseEntity<DataDTO<List<Banner>>> all = service.filterByPrice(min, max);
        Assertions.assertTrue(all.getData().isSuccess(), "Filter by price method is not passed!!");
    }

    @Test
    public void findByNameTest() {
        String name = "business";
        ResponseEntity<DataDTO<List<Banner>>> responseEntity = service.findByName(name);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by name method is not passed!");
    }

    @Test
    public void findByWeight() {
        Integer weight = 175;
        ResponseEntity<DataDTO<List<Banner>>> responseEntity = service.findByWeight(weight);
        Assertions.assertEquals(responseEntity.getStatus(), 200, "Find by weight method is not passed!");
    }
}
