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

    @Test
    public void testCreateTrainerName() {
        // Test pour vérifier le nom du dresseur créé
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Rachid", Team.MYSTIC, pokedexFactory);
        assertEquals("Rachid", trainer.getName());
    }

    @Test
    public void testCreateTrainerTeam() {
        // Test pour vérifier l'équipe du dresseur créé
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Rachid", Team.MYSTIC, pokedexFactory);
        assertEquals(Team.MYSTIC, trainer.getTeam());
    }

    @Test
    public void testGetPokedex() {
        // Test pour vérifier que le Pokedex du dresseur est correctement initialisé
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Rachid", Team.MYSTIC, pokedexFactory);

        // Vérification que le Pokedex du dresseur est bien celui que nous avons mocké
        assertEquals(pokedex, trainer.getPokedex());
    }

}
