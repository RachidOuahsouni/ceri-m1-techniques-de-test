package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PokemonMetadataProviderTest {

    private PokemonMetadataProvider metadataProvider;

    @BeforeEach
    void setUp() {
        // Initialiser PokemonMetadataProvider
        metadataProvider = new PokemonMetadataProvider();
    }

    @Test
    void testGetPokemonMetadataValidIndex() throws PokedexException {
        // Récupérer les métadonnées pour l'index 0 (Bulbasaur)
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);

        // Vérifier les valeurs des métadonnées de Bulbasaur
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(49, metadata.getAttack());
        assertEquals(49, metadata.getDefense());
        assertEquals(45, metadata.getStamina());

        // Récupérer les métadonnées pour l'index 2 (Venusaur)
        metadata = metadataProvider.getPokemonMetadata(2);

        // Vérifier les valeurs des métadonnées de Venusaur
        assertEquals(2, metadata.getIndex());
        assertEquals("Venusaur", metadata.getName());
        assertEquals(82, metadata.getAttack());
        assertEquals(83, metadata.getDefense());
        assertEquals(80, metadata.getStamina());
    }

    @Test
    void testGetPokemonMetadataInvalidIndex() {
        // Vérifier que la méthode lance une exception pour un index invalide (négatif)
        assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(-1));

        // Vérifier que la méthode lance une exception pour un index invalide (supérieur au nombre de Pokémon)
        assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(100));
    }
}
