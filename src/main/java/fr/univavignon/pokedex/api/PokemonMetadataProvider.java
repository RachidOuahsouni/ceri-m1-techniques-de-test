package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    // Liste statique de métadonnées pour les Pokémon
    private static final List<PokemonMetadata> POKEMON_METADATA_LIST = new ArrayList<>();

    static {
        // Remplir la liste avec des exemples de données Pokémon
        POKEMON_METADATA_LIST.add(new PokemonMetadata(0, "Bulbasaur", 49, 49, 45));
        POKEMON_METADATA_LIST.add(new PokemonMetadata(1, "Ivysaur", 62, 63, 60));
        POKEMON_METADATA_LIST.add(new PokemonMetadata(2, "Venusaur", 82, 83, 80));
        // On peut Ajouter d'autres Pokémon
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Vérifie si l'index est valide
        if (index < 0 || index >= POKEMON_METADATA_LIST.size()) {
            throw new PokedexException("Invalid Pokemon index: " + index);
        }
        // Retourne les métadonnées du Pokémon correspondant à l'index
        return POKEMON_METADATA_LIST.get(index);
    }
}
