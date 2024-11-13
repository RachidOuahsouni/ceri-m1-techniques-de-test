package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PokemonFactoryTest {

    @Test
    void testCreatePokemon() throws PokedexException {
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
        assertThrows(PokedexException.class, () -> {
            factory.createPokemon(-1, 100, 100, 2000, 3);
        }, "PokedexException should have been thrown");
    }
}
