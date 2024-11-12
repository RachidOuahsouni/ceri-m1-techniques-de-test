package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;

    private PokemonMetadata bulbizarreMetadata;
    private PokemonMetadata aqualiMetadata;

    @BeforeEach
    public void setUp() throws PokedexException {
        // Initialise les mocks
        MockitoAnnotations.openMocks(this);

        // Métadonnées des Pokémon
        bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);

        // Mock pour récupérer les métadonnées des Pokémon
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(aqualiMetadata);

        // Ajouter le comportement pour un index invalide (exemple)
        when(pokemonMetadataProvider.getPokemonMetadata(9999)).thenThrow(new PokedexException("Invalid index"));
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Test pour récupérer les métadonnées d'un Pokémon
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());

        metadata = pokemonMetadataProvider.getPokemonMetadata(133);
        assertEquals("Aquali", metadata.getName());
        assertEquals(186, metadata.getAttack());
    }

    @Test
    public void testGetPokemonMetadataThrowsException() {
        // Test pour vérifier qu'une exception est levée pour un index invalide
        assertThrows(PokedexException.class, () -> {
            pokemonMetadataProvider.getPokemonMetadata(9999);
        }, "Expected PokedexException to be thrown");
    }

    @Test
    public void testGetPokemonMetadataName() throws PokedexException {
        // Test pour vérifier le nom du Pokémon
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals("Bulbizarre", metadata.getName());

        metadata = pokemonMetadataProvider.getPokemonMetadata(133);
        assertEquals("Aquali", metadata.getName());
    }

    @Test
    public void testGetPokemonMetadataStats() throws PokedexException {
        // Test pour vérifier les statistiques d'attaque et de défense
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());

        metadata = pokemonMetadataProvider.getPokemonMetadata(133);
        assertEquals(186, metadata.getAttack());
        assertEquals(168, metadata.getDefense());
    }


}
