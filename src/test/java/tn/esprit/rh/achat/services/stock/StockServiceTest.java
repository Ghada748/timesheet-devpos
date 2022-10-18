
package tn.esprit.rh.achat.services.stock;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;


import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IStockService;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class StockServiceTest {



    @MockBean
    private StockRepository sr;

    private Stock stock1 = new Stock(1L,"stock1", 100, 1,null);
    private Stock stock2 = new Stock(7L,"stock2", 200, 2,null);


    @Autowired
    IStockService is;


    @Test
    public void addStockTest() {
        when(sr.save(stock1)).thenReturn(stock1);
        assertNotNull(stock1);
        assertEquals(stock1, is.addStock(stock1));
        System.out.println("add works !");
    }


    @Test
    public void retrieveAllStocksTest() {
        when(sr.findAll()).thenReturn(Stream
                .of(stock1,stock2)
                .collect(Collectors.toList()));
        assertEquals(2,is.retrieveAllStocks().size());
        System.out.println("Retrieve operators works !");
    }



    @Test
    public void DeleteStockTest() {
        sr.save(stock1);
        is.deleteStock(stock1.getIdStock());
        verify(sr, times(1)).deleteById(stock1.getIdStock());
        System.out.println("Delete works !");

    }


    @Test
    public void UpdateStockTest() {
        when(sr.save(stock1)).thenReturn(stock1);
        assertNotNull(stock1);
        assertEquals(stock1, is.updateStock(stock1));
        System.out.println("Update works !");
    }

    @Test
    public void retrieveStockTest() {
        when(sr.findById(stock1.getIdStock())).thenReturn(Optional.of(stock1));
        assertEquals(stock1, is.retrieveStock(stock1.getIdStock()));
        System.out.println("Retrieve works !");
    }

}