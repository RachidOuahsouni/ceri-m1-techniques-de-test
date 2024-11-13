package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PokemonFactoryTest {

    @Test
    void testCreatePokemon() {
        // Setup
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory factory = new PokemonFactory(metadataProvider);

        // Test valide
        Pokemon pokemon = factory.createPokemon(0, 100, 100, 2000, 3);

        // Validation
        assertNotNull(pokemon, "Pokemon should not be null");
        assertEquals(0, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(49, pokemon.getAttack());
        assertEquals(49, pokemon.getDefense());
        assertEquals(45, pokemon.getStamina());
        assertEquals(100, pokemon.getCp());
        assertEquals(100, pokemon.getHp());
        assertEquals(2000, pokemon.getDust());
        assertEquals(3, pokemon.getCandy());

        // Test d'index invalide
        Pokemon invalidPokemon = factory.createPokemon(-1, 100, 100, 2000, 3);

        // Vérifie que l'index invalide retourne bien null
        assertNull(invalidPokemon, "Pokemon creation with invalid index should return null");

        // Test si l'exception est bien gérée (affichage de l'erreur dans la sortie standard)
        factory.createPokemon(-1, 100, 100, 2000, 3);
        fail("PokedexException should have been thrown");
    }
}
