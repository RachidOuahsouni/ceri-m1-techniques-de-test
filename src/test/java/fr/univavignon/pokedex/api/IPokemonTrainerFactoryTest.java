package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokemonTrainerFactory pokemonTrainerFactory;

    @Mock
    private IPokedexFactory pokedexFactory;

    @Mock
    private IPokedex pokedex;

    private PokemonTrainer pokemonTrainer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        pokemonTrainer = new PokemonTrainer("Rachid", Team.MYSTIC, pokedex);

        when(pokemonTrainerFactory.createTrainer("Rachid", Team.MYSTIC, pokedexFactory)).thenReturn(pokemonTrainer);
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Rachid", Team.MYSTIC, pokedexFactory);
        assertEquals("Rachid", trainer.getName());
        assertEquals(Team.MYSTIC, trainer.getTeam());
    }
}
