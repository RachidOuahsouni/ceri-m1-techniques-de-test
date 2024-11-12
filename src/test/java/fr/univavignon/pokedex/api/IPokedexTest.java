package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    @Mock
    private IPokedex pokedex;

    private Pokemon bulbizarre;
    private Pokemon aquali;

    @BeforeEach
    public void setUp() throws PokedexException {
        // Initialise les mocks
        MockitoAnnotations.openMocks(this);

        // Données des Pokémon
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        // Mock pour récupérer les Pokémon du Pokedex
        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        when(pokedex.getPokemon(133)).thenReturn(aquali);
        when(pokedex.getPokemons()).thenReturn(Arrays.asList(bulbizarre, aquali));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        // Test pour récupérer un Pokémon par son index
        Pokemon pokemon = pokedex.getPokemon(0);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(613, pokemon.getCp());

        pokemon = pokedex.getPokemon(133);
        assertEquals("Aquali", pokemon.getName());
        assertEquals(2729, pokemon.getCp());
    }

    @Test
    public void testGetPokemons() {
        // Test pour récupérer tous les Pokémon du Pokedex
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Aquali", pokemons.get(1).getName());
    }

    @Test
    public void testPokedexException() {
        Exception exception = assertThrows(PokedexException.class, () -> {
            throw new PokedexException("Test exception");
        });
        assertEquals("Test exception", exception.getMessage());
    }

}
