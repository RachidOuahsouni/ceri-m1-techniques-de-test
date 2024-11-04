package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    private IPokedex pokedex;

    private Pokemon bulbizarre;
    private Pokemon aquali;

    @BeforeEach
    public void setUp() throws PokedexException {
        pokedex = Mockito.mock(IPokedex.class);

        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);

        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        when(pokedex.getPokemon(133)).thenReturn(aquali);
        when(pokedex.getPokemons()).thenReturn(pokemons);

        // Configurer le mock pour lancer une exception pour un ID invalide
        doThrow(new PokedexException("Invalid ID")).when(pokedex).getPokemon(999);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        // Test pour Bulbizarre
        Pokemon pokemon = pokedex.getPokemon(0);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(613, pokemon.getCp());
        assertEquals(126, pokemon.getAttack());
        assertEquals(126, pokemon.getDefense());
        assertEquals(90, pokemon.getStamina());

        // Test pour Aquali
        pokemon = pokedex.getPokemon(133);
        assertEquals("Aquali", pokemon.getName());
        assertEquals(2729, pokemon.getCp());
        assertEquals(186, pokemon.getAttack());
        assertEquals(168, pokemon.getDefense());
        assertEquals(260, pokemon.getStamina());
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Aquali", pokemons.get(1).getName());
    }

    @Test
    public void testInvalidPokemonIdThrowsException() {
        // Test pour vérifier que l'exception est lancée pour un ID invalide
        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(999);
        });
    }

    @Test
    public void testPokemonAttributes() throws PokedexException {
        // Test pour vérifier des attributs spécifiques
        Pokemon pokemon = pokedex.getPokemon(0); // Bulbizarre
        assertEquals(126, pokemon.getAttack());
        assertEquals(126, pokemon.getDefense());
        assertEquals(90, pokemon.getStamina());

        pokemon = pokedex.getPokemon(133); // Aquali
        assertEquals(186, pokemon.getAttack());
        assertEquals(168, pokemon.getDefense());
        assertEquals(260, pokemon.getStamina());
    }
}
