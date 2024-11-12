package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
