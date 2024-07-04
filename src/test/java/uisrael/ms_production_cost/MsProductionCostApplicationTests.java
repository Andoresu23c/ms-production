package uisrael.ms_production_cost;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import uisrael.ms_production_cost.model.Product;
import uisrael.ms_production_cost.services.impl.productServicesImpl;

@SpringBootTest
class MsProductionCostApplicationTests {

	@Autowired
	private productServicesImpl serv;
	@Test
	public void contextLoads() {
		
        List<Product> result = serv.listProduct();
        assertEquals(2, result.size());
	}

}
