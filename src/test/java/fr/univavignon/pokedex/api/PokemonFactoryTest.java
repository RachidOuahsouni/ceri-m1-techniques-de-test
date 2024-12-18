package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonFactoryTest {
    private RocketPokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        // Initialiser RocketPokemonFactory
        pokemonFactory = new RocketPokemonFactory();
    }

    @Test
    void testCreatePokemonValid() {
        // Créer un Pokémon avec un index valide (1 pour "Bulbasaur")
        Pokemon pokemon = pokemonFactory.createPokemon(1, 500, 60, 3000, 3);

        // Vérifier que le Pokémon a les valeurs correctes
        assertEquals(1, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName()); // Vérifie le nom correct pour l'index 1
        assertEquals(500, pokemon.getCp());
        assertEquals(60, pokemon.getHp());
        assertEquals(3000, pokemon.getDust());
        assertEquals(3, pokemon.getCandy());

        // Vérifier que les statistiques sont initialisées même avec des valeurs random
        assertNotNull(pokemon.getAttack());
        assertNotNull(pokemon.getDefense());
        assertNotNull(pokemon.getStamina());
    }

    @Test
    void testCreatePokemonInvalidIndex() {
        // Créer un Pokémon avec un index invalide (-1)
        Pokemon pokemon = pokemonFactory.createPokemon(-1, 500, 60, 3000, 3);

        // Vérifier que le Pokémon utilise les valeurs par défaut pour un index invalide
        assertEquals(-1, pokemon.getIndex());
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack()); // Statistiques pour index invalide
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(0, pokemon.getIv());
    }

    @Test
    void testCreatePokemonMetadataException() {
        // Vérifier que la classe retourne "MISSINGNO" pour un index absent de la map
        Pokemon pokemon = pokemonFactory.createPokemon(999, 500, 60, 3000, 3);

        // Le Pokémon doit avoir "MISSINGNO" comme nom
        assertEquals(999, pokemon.getIndex());
        assertEquals("MISSINGNO", pokemon.getName());
    }
}
