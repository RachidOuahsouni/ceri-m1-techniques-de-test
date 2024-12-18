package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PokemonFactoryTest {
    private PokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProviderMock;

    @BeforeEach
    void setUp() {
        // Création d'un mock pour l'IPokemonMetadataProvider
        metadataProviderMock = Mockito.mock(IPokemonMetadataProvider.class);
        // Initialisation de la factory avec le mock
        pokemonFactory = new PokemonFactory(metadataProviderMock);
    }

    @Test
    void testCreatePokemonValid() throws PokedexException {
        // Création des métadonnées pour un Pokémon avec un index valide
        PokemonMetadata metadata = new PokemonMetadata(1, "Bulbasaur", 49, 49, 45);
        Mockito.when(metadataProviderMock.getPokemonMetadata(1)).thenReturn(metadata);

        // Créer un Pokémon avec un index valide (1 pour "Bulbasaur")
        Pokemon pokemon = pokemonFactory.createPokemon(1, 500, 60, 3000, 3);

        // Vérifier que le Pokémon a les valeurs correctes
        assertEquals(1, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName()); // Vérifie le nom correct pour l'index 1
        assertEquals(500, pokemon.getCp());
        assertEquals(60, pokemon.getHp());
        assertEquals(3000, pokemon.getDust());
        assertEquals(3, pokemon.getCandy());

        // Vérifier que les statistiques sont initialisées correctement
        assertEquals(49, pokemon.getAttack());
        assertEquals(49, pokemon.getDefense());
        assertEquals(45, pokemon.getStamina());
    }

    @Test
    void testCreatePokemonInvalidIndex() throws PokedexException {
        // Simuler une exception PokedexException lors de la récupération des métadonnées
        Mockito.when(metadataProviderMock.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalid Pokemon index"));

        // Vérifier que l'exception est bien lancée pour un index invalide
        PokedexException thrown = assertThrows(PokedexException.class, () -> {
            pokemonFactory.createPokemon(-1, 500, 60, 3000, 3);
        });

        assertEquals("Invalid Pokemon index: -1", thrown.getMessage());
    }

    @Test
    void testCreatePokemonMetadataException() throws PokedexException {
        // Simuler le cas où le Pokémon demandé n'existe pas
        PokemonMetadata metadata = new PokemonMetadata(999, "MISSINGNO", 1000, 1000, 1000);
        Mockito.when(metadataProviderMock.getPokemonMetadata(999)).thenReturn(metadata);

        // Créer un Pokémon avec un index inexistant (999)
        Pokemon pokemon = pokemonFactory.createPokemon(999, 500, 60, 3000, 3);

        // Vérifier que le Pokémon a le nom "MISSINGNO"
        assertEquals(999, pokemon.getIndex());
        assertEquals("MISSINGNO", pokemon.getName());
    }
}
