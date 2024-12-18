package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PokemonFactoryTest {
    private IPokemonMetadataProvider metadataProvider;
    private RocketPokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        // Créer un mock de IPokemonMetadataProvider
        metadataProvider = mock(IPokemonMetadataProvider.class);
        // Initialiser PokemonFactory avec le mock de metadataProvider
        pokemonFactory = new RocketPokemonFactory();
    }

    @Test
    void testCreatePokemonValid() throws PokedexException {
        // Configurer le mock pour retourner des métadonnées de Pokémon pour l'index 0
        PokemonMetadata metadata = new PokemonMetadata(0, "Bulbasaur", 126, 126, 90);
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(metadata);

        // Créer un Pokémon en utilisant la méthode createPokemon
        Pokemon pokemon = pokemonFactory.createPokemon(0, 500, 60, 3000, 3);

        // Vérifier que le Pokémon a les valeurs correctes
        assertEquals(0, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(126, pokemon.getAttack());
        assertEquals(126, pokemon.getDefense());
        assertEquals(90, pokemon.getStamina());
        assertEquals(500, pokemon.getCp());
        assertEquals(60, pokemon.getHp());
        assertEquals(3000, pokemon.getDust());
        assertEquals(3, pokemon.getCandy());

        // Vérifier que l'IV est compris entre 0 et 100
        assertTrue(pokemon.getIv() >= 0 && pokemon.getIv() <= 100);
    }

    @Test
    void testCreatePokemonInvalidIndex() {
        // Vérifier que la méthode lance une exception pour un index invalide
        assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(-1, 500, 60, 3000, 3));
    }

    @Test
    void testCreatePokemonMetadataException() throws PokedexException {
        // Configurer le mock pour lancer une exception lorsqu'on demande les métadonnées
        when(metadataProvider.getPokemonMetadata(0)).thenThrow(new PokedexException("Metadata not found"));

        // Vérifier que l'exception est relancée par la méthode createPokemon
        assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(0, 500, 60, 3000, 3));
    }
}
