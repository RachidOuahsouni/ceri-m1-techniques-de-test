package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        // Créer une instance de PokemonMetadataProvider
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();

        // Passer metadataProvider lors de la création de PokemonFactory
        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);

        // Créer le Pokedex en utilisant le PokedexFactory
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Créer et retourner le PokemonTrainer
        return new PokemonTrainer(name, team, pokedex);
    }
}
