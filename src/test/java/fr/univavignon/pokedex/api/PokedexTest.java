package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Comparator;
import java.util.List;

class PokedexTest {
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private Pokedex pokedex;

    @BeforeEach
    void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    void testAddPokemon() {
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 0, 0, 0, 0, 0);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
        assertEquals(1, pokedex.size());
    }

    @Test
    void testGetPokemonValid() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 0, 0, 0, 0, 0);
        pokedex.addPokemon(pokemon);
        Pokemon retrievedPokemon = pokedex.getPokemon(0);
        assertEquals(pokemon, retrievedPokemon);
    }

    @Test
    void testGetPokemonInvalid() {
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(1));
    }

    @Test
    void testGetPokemons() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbasaur", 126, 126, 90, 0, 0, 0, 0, 0);
        Pokemon pokemon2 = new Pokemon(1, "Charmander", 128, 108, 78, 0, 0, 0, 0, 0);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals(pokemon1, pokemons.get(0));
        assertEquals(pokemon2, pokemons.get(1));
    }

    @Test
    void testGetPokemonsEmpty() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertTrue(pokemons.isEmpty());
    }

    @Test
    void testGetPokemonsSortedByCp() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbasaur", 126, 126, 90, 10, 0, 0, 0, 0);
        Pokemon pokemon2 = new Pokemon(1, "Charmander", 128, 108, 78, 20, 0, 0, 0, 0);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        List<Pokemon> sortedPokemons = pokedex.getPokemons(Comparator.comparing(Pokemon::getCp));
        assertEquals(pokemon1, sortedPokemons.get(0));
        assertEquals(pokemon2, sortedPokemons.get(1));
    }

    @Test
    void testGetPokemonsSortedByHp() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbasaur", 126, 126, 90, 10, 50, 0, 0, 0);
        Pokemon pokemon2 = new Pokemon(1, "Charmander", 128, 108, 78, 20, 60, 0, 0, 0);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        List<Pokemon> sortedPokemons = pokedex.getPokemons(Comparator.comparing(Pokemon::getHp));
        assertEquals(pokemon1, sortedPokemons.get(0));
        assertEquals(pokemon2, sortedPokemons.get(1));
    }

    @Test
    void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = new PokemonMetadata(0, "Bulbasaur", 126, 126, 90);
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(metadata);
        PokemonMetadata retrievedMetadata = pokedex.getPokemonMetadata(0);
        assertEquals(metadata, retrievedMetadata);
    }

    @Test
    void testCreatePokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 0, 0, 0, 0, 0);
        when(pokemonFactory.createPokemon(0, 126, 90, 0, 0)).thenReturn(pokemon);
        Pokemon createdPokemon = pokedex.createPokemon(0, 126, 90, 0, 0);
        assertEquals(pokemon, createdPokemon);
    }
}
