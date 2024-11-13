package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    private final IPokemonMetadataProvider metadataProvider;

    // Constructeur prenant un fournisseur de métadonnées en paramètre
    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
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
            // Gérer l'exception si l'index est invalide
            System.err.println("Erreur : " + e.getMessage());
            return null; // Ou gérer différemment selon vos besoins
        }
    }
}
