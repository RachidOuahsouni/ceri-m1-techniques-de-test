package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokemonTrainerFactory pokemonTrainerFactory;

    @Mock
    private IPokedexFactory pokedexFactory;

    @Mock
    private IPokedex pokedex;

    private PokemonTrainer pokemonTrainer;

    @BeforeEach
    public void setUp() {
        // Initialisation des mocks
        MockitoAnnotations.openMocks(this);

        // Création d'un dresseur Pokémon pour les tests
        pokemonTrainer = new PokemonTrainer("Rachid", Team.MYSTIC, pokedex);

        // Mock pour la création du dresseur Pokémon
        when(pokemonTrainerFactory.createTrainer("Rachid", Team.MYSTIC, pokedexFactory)).thenReturn(pokemonTrainer);
    }

    @Test
    public void testCreateTrainer() {
        // Test pour créer un dresseur Pokémon
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Rachid", Team.MYSTIC, pokedexFactory);

        // Vérification des informations du dresseur
        assertEquals("Rachid", trainer.getName());
        assertEquals(Team.MYSTIC, trainer.getTeam());
    }
}
