package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonComparatorsTest {
    private Pokemon bulbasaur;
    private Pokemon charmander;
    private Pokemon squirtle;

    @BeforeEach
    void setUp() {
        // Initialisation de quelques Pokémon pour les tests
        bulbasaur = new Pokemon(1, "Bulbasaur", 49, 49, 45, 300, 100, 1000, 25, 100.0);
        charmander = new Pokemon(4, "Charmander", 52, 43, 39, 300, 100, 1000, 25, 100.0);
        squirtle = new Pokemon(7, "Squirtle", 48, 65, 44, 300, 100, 1000, 25, 100.0);
    }

    @Test
    void testCompareByName() {
        // Comparer les Pokémon par nom
        assertTrue(PokemonComparators.NAME.compare(bulbasaur, charmander) < 0); // "Bulbasaur" < "Charmander"
        assertTrue(PokemonComparators.NAME.compare(charmander, squirtle) > 0); // "Charmander" > "Squirtle"
        assertEquals(0, PokemonComparators.NAME.compare(bulbasaur, new Pokemon(1, "Bulbasaur", 49, 49, 45, 300, 100, 1000, 25, 100.0)));
    }

    @Test
    void testCompareByIndex() {
        // Comparer les Pokémon par index
        assertTrue(PokemonComparators.INDEX.compare(bulbasaur, charmander) < 0); // 1 < 4
        assertTrue(PokemonComparators.INDEX.compare(charmander, squirtle) < 0); // 4 < 7
        assertEquals(0, PokemonComparators.INDEX.compare(bulbasaur, new Pokemon(1, "Bulbasaur", 49, 49, 45, 300, 100, 1000, 25, 100.0)));
    }

    @Test
    void testCompareByCp() {
        // Comparer les Pokémon par CP (combat points)
        assertEquals(0, PokemonComparators.CP.compare(bulbasaur, charmander)); // CP égal à 300 pour les deux
        assertTrue(PokemonComparators.CP.compare(bulbasaur, squirtle) > 0); // 300 > 0
        assertTrue(PokemonComparators.CP.compare(squirtle, charmander) < 0); // 300 < 350
    }
}
