package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
        Intervention inter1, inter2, inter3;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");	
                inter1 = new Intervention(new Date(2020, 04, 12), 1, TypeIntervention.TD, new Salle("salle1", 20), untel, uml);
                inter2 = new Intervention(new Date(2020, 04, 13), 2, TypeIntervention.CM, new Salle("salle2", 20), untel, java);
                inter3 = new Intervention(new Date(2020, 04, 14), 2, TypeIntervention.TP, new Salle("salle3", 20), untel, uml);
        }
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        @Test
	public void testAjoutInter() {
            untel.ajouteIntervention(inter1);
            assertEquals(1, untel.getListeIntervention().size());
	}
        
        @Test
	public void testHeuresPrevues() {
            untel.ajouteEnseignement(uml, 30, 10, 50);
            assertEquals(93, untel.heuresPrevues());
            untel.ajouteEnseignement(java, 30, 10, 50);
            assertEquals(185, untel.heuresPrevues());
            assertEquals(2, untel.getServicePrevu().size());
            
	}
        
        @Test
	public void testHeuresPrevuesUE() {
            untel.ajouteEnseignement(uml, 30, 10, 50);
            untel.ajouteEnseignement(java, 3, 1, 5);
            assertEquals(93, untel.heuresPrevuesPourUE(uml));
	}
        
        @Test
	public void testEnSousService() {
            untel.ajouteEnseignement(uml, 30, 10, 50);
            assertTrue(untel.enSousService());
	}
        
        @Test
	public void testHeuresPlanifiees() {
            untel.ajouteIntervention(inter1);
            untel.ajouteIntervention(inter2);
            untel.ajouteIntervention(inter3);
            assertEquals(6, untel.heuresPlanifier());
	}
	
}
