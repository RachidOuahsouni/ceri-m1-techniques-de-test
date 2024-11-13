package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PokedexFactoryTest {

    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private PokedexFactory pokedexFactory;

    @BeforeEach
    void setUp() {
        // Créer des mocks pour IPokemonMetadataProvider et IPokemonFactory
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);

        // Initialiser PokedexFactory
        pokedexFactory = new PokedexFactory();
    }

    @Test
    void testCreatePokedex() {
        // Utiliser la méthode createPokedex pour créer un Pokedex
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Vérifier que l'instance de Pokedex est créée correctement
        assertNotNull(pokedex);
        assertTrue(pokedex instanceof Pokedex);


    }
}
