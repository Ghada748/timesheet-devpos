package tn.esprit.rh.achat.services.operateur;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.IOperateurService;


@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class OperateurServiceTest {
    @MockBean
    private OperateurRepository or;
    private Operateur op1 = new Operateur(1L,"nour","mallek","1234");
    private Operateur op2 = new Operateur(2L,"malleek","nouur","20853");
    private Operateur op3 = new Operateur(3L,"eline","mallek","23456");
    @Autowired
    IOperateurService os;

    @Test
    public void addOperateurTest() {
        when(or.save(op1)).thenReturn(op1);
        assertNotNull(op1);
        assertEquals(op1, os.addOperateur(op1));
        System.out.println("l'ajout est effectué avec succès !");
    }
    @Test
    public void retrieveAllOperateursTest() {
        when(or.findAll()).thenReturn(Stream
                .of(op1,op2)
                .collect(Collectors.toList()));
        assertEquals(2,os.retrieveAllOperateurs().size());
        System.out.println("afficher tout est effectué avec succès !");
    }

    @Test
    public void DeleteOperateurTest() {
        or.save(op1);
        os.deleteOperateur(op1.getIdOperateur());
        verify(or, times(1)).deleteById(op1.getIdOperateur());
        System.out.println(" suppression effectué avec succès !");

    }
    @Test
    public void UpdateOperateurTest() {
        when(or.save(op1)).thenReturn(op1);
        assertNotNull(op1);
        assertEquals(op1, os.updateOperateur(op1));
        System.out.println("modification effectué avec succès!");
    }

    @Test
    public void retrieveOperateurTest() {
        when(or.findById(op1.getIdOperateur())).thenReturn(Optional.of(op1));
        assertEquals(op1, os.retrieveOperateur(op1.getIdOperateur()));
        System.out.println("affichage est effectué avec succès !");
    }
}