package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RocketPokemonFactoryTest {

    private IPokemonFactory factory;

    @BeforeEach
    public void initialiser() {
        factory = new RocketPokemonFactory();
    }

    @Test
    public void creerPokemonAvecPuissanceCombatNegative() throws PokedexException {
        Pokemon pokemon = factory.createPokemon(0, -5, 50, 100, 10);
        assertNotNull(pokemon, "Le Pokémon doit être créé même si la puissance de combat est négative.");
    }

    @Test
    public void creerPokemonAvecPoussieresNegative() throws PokedexException {
        Pokemon pokemon = factory.createPokemon(0, 10, 50, -100, 10);
        assertNotNull(pokemon, "Le Pokémon doit être créé même si les poussières d'étoile sont négatives.");
    }

    @Test
    public void creerPokemonAvecPointsVieNegatifs() throws PokedexException {
        Pokemon pokemon = factory.createPokemon(0, 10, -50, 100, 10);
        assertNotNull(pokemon, "Le Pokémon doit être créé même si les points de vie sont négatifs.");
    }

    @Test
    public void creerPokemonAvecBonbonsNegatifs() throws PokedexException {
        Pokemon pokemon = factory.createPokemon(0, 10, 50, 100, -10);
        assertNotNull(pokemon, "Le Pokémon doit être créé même si le nombre de bonbons est négatif.");
    }

    @Test
    public void creerPokemonAvecIndiceNegatif() throws PokedexException {
        Pokemon pokemon = factory.createPokemon(-1, 0, 0, 0, 0);
        assertNotNull(pokemon, "Un Pokémon avec un indice négatif doit être créé.");
        assertEquals("Ash's Pikachu", pokemon.getName(), "Le nom du Pokémon doit être 'Ash's Pikachu' pour un indice négatif.");
    }

    @Test
    public void creerPokemonAvecIndiceTropGrand() throws PokedexException {
        Pokemon pokemon = factory.createPokemon(200, 10, 50, 100, 10);
        assertNotNull(pokemon, "Le Pokémon doit être créé même si l'indice est supérieur à la limite.");
        assertEquals("MISSINGNO", pokemon.getName(), "Le nom du Pokémon doit être 'MISSINGNO' pour un indice inconnu.");
    }

    @Test
    public void testCreationPokemonValide() throws PokedexException {
        int index = 1;
        int cp = 20;
        int hp = 100;
        int dust = 300;
        int candy = 5;

        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);
        assertNotNull(pokemon, " Le Pokémon doit être correctement créé avec des paramètres valides.");
        assertEquals(index, pokemon.getIndex(), "L'indice du Pokémon doit correspondre à celui passé en paramètre.");
        assertEquals(cp, pokemon.getCp(), "La puissance de combat doit correspondre à celle passée en paramètre.");
        assertEquals(hp, pokemon.getHp(), "Les points de vie doivent correspondre à ceux passés en paramètre.");
        assertEquals(dust, pokemon.getDust(), "Les poussières d'étoile doivent correspondre à celles passées en paramètre.");
        assertEquals(candy, pokemon.getCandy(), "Le nombre de bonbons doit correspondre à celui passé en paramètre.");
    }
}
