package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    @Mock
    private IPokemonFactory pokemonFactory;

    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
        when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);
    }

    @Test
    public void testCreatePokemon() {
        // Test pour Bulbizarre
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
        assertEquals(56, pokemon.getIv(), 0.1);

        // Test pour Aquali
        pokemon = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals("Aquali", pokemon.getName());
        assertEquals(2729, pokemon.getCp());
        assertEquals(202, pokemon.getHp());
        assertEquals(5000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
        assertEquals(100, pokemon.getIv(), 0.1);
    }
}
