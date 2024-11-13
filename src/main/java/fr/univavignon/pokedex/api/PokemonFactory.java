package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    private final IPokemonMetadataProvider metadataProvider;

    // Constructeur prenant un fournisseur de métadonnées en paramètre
    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        if (index < 0) {
            throw new PokedexException("Invalid Pokemon index: " + index);
        }

        try {
            // Obtenir les métadonnées du Pokémon en fonction de l'index
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);

            // Utiliser les valeurs de métadonnées pour l'attaque, la défense et l'endurance
            int attack = metadata.getAttack();
            int defense = metadata.getDefense();
            int stamina = metadata.getStamina();
            double iv = Math.random() * 100; // Calcul d'IV aléatoire pour l'exemple

            // Crée et retourne une instance de Pokemon avec les métadonnées appropriées
            return new Pokemon(index, metadata.getName(), attack, defense, stamina, cp, hp, dust, candy, iv);

        } catch (PokedexException e) {
            // Relance l'exception si nécessaire
            throw e;
        }
    }

}
