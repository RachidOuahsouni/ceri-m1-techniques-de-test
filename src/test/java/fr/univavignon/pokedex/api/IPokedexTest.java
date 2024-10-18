package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    @Mock
    private IPokedex pokedex;

    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp() throws PokedexException {
        MockitoAnnotations.initMocks(this);

        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        // Mock d'une liste de Pokémon
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);

        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        when(pokedex.getPokemon(133)).thenReturn(aquali);
        when(pokedex.getPokemons()).thenReturn(pokemons);
    }


    @Test
    public void testGetPokemon() throws PokedexException {
        // Test pour Bulbizarre
        Pokemon pokemon = pokedex.getPokemon(0);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(613, pokemon.getCp());

        // Test pour Aquali
        pokemon = pokedex.getPokemon(133);
        assertEquals("Aquali", pokemon.getName());
        assertEquals(2729, pokemon.getCp());
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Aquali", pokemons.get(1).getName());
    }
}
