package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    @Mock
    private IPokemonFactory pokemonFactory;

    private Pokemon bulbizarre;
    private Pokemon aquali;

    @BeforeEach
    public void setUp() throws PokedexException {
        // Initialise les mocks
        MockitoAnnotations.openMocks(this);

        // Données des Pokémon
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        // Mock pour la création des Pokémon
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
        when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        // Test pour créer un Pokémon à partir des métadonnées
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(613, pokemon.getCp());

        pokemon = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals("Aquali", pokemon.getName());
        assertEquals(2729, pokemon.getCp());
    }

    @Test
    public void testCreatePokemonName() throws PokedexException {
        // Test pour vérifier le nom du Pokémon créé
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals("Bulbizarre", pokemon.getName());

        pokemon = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals("Aquali", pokemon.getName());
    }

    @Test
    public void testCreatePokemonCp() throws PokedexException {
        // Test pour vérifier le CP du Pokémon créé
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(613, pokemon.getCp());

        pokemon = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(2729, pokemon.getCp());
    }

    @Test
    public void testGetHp() throws PokedexException {
        // Test pour vérifier le HP du Pokémon créé
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(64, pokemon.getHp());

        pokemon = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(202, pokemon.getHp());
    }

    @Test
    public void testGetDust() throws PokedexException {
        // Test pour vérifier le Dust du Pokémon créé
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(4000, pokemon.getDust());

        pokemon = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(5000, pokemon.getDust());
    }

    @Test
    public void testGetCandy() throws PokedexException {
        // Test pour vérifier le Candy du Pokémon créé
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(4, pokemon.getCandy());

        pokemon = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(4, pokemon.getCandy());
    }

    @Test
    public void testGetIv() throws PokedexException {
        // Test pour vérifier le IV du Pokémon créé
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(56.0, pokemon.getIv());

        pokemon = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(100.0, pokemon.getIv());
    }



}
