package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;

    private PokemonMetadata bulbizarreMetadata;
    private PokemonMetadata aqualiMetadata;

    @Before
    public void setUp() throws PokedexException {
        MockitoAnnotations.initMocks(this);

        bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);

        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(aqualiMetadata);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Test pour Bulbizarre
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());

        // Test pour Aquali
        metadata = pokemonMetadataProvider.getPokemonMetadata(133);
        assertEquals("Aquali", metadata.getName());
        assertEquals(186, metadata.getAttack());
        assertEquals(168, metadata.getDefense());
        assertEquals(260, metadata.getStamina());
    }
}

