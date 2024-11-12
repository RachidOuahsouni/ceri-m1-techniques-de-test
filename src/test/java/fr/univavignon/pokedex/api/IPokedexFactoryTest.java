package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @BeforeEach
    void setUp() {
        // Création d'un mock pour l'interface IPokedexFactory
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);

        // Définir le comportement du mock
        when(pokedexFactory.createPokedex(Mockito.any(), Mockito.any())).thenReturn(pokedex);
    }

    @Test
    void testCreatePokedex() {
        // Vérifie que l'instance de IPokedex n'est pas nulle
        IPokedex createdPokedex = pokedexFactory.createPokedex(null, null);
        assertNotNull(createdPokedex); // Vérifie que l'objet créé n'est pas nul

        // Vérifie que l'instance retournée est bien celle que nous avons définie dans le mock
        assertEquals(pokedex, createdPokedex); // Comparaison de l'objet retourné avec le mock
    }
}
