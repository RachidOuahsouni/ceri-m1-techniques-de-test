package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PokemonTrainerFactoryTest {

    private IPokedexFactory pokedexFactory;
    private PokemonTrainerFactory trainerFactory;

    @BeforeEach
    void setUp() {
        // Créer un mock de IPokedexFactory
        pokedexFactory = mock(IPokedexFactory.class);
        // Initialiser PokemonTrainerFactory
        trainerFactory = new PokemonTrainerFactory();
    }

    @Test
    void testCreateTrainer() {
        // Configurer le mock pour retourner un Pokedex simulé
        IPokedex mockPokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(any(IPokemonMetadataProvider.class), any(IPokemonFactory.class)))
                .thenReturn(mockPokedex);

        // Créer un entraîneur en utilisant la méthode createTrainer
        String trainerName = "Ash";
        Team team = Team.VALOR;
        PokemonTrainer trainer = trainerFactory.createTrainer(trainerName, team, pokedexFactory);

        // Vérifier les attributs de l'entraîneur créé
        assertEquals(trainerName, trainer.getName());
        assertEquals(team, trainer.getTeam());
        assertEquals(mockPokedex, trainer.getPokedex());
    }

    @Test
    void testCreateTrainerWithDifferentTeam() {
        // Configurer le mock pour retourner un Pokedex simulé
        IPokedex mockPokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(any(IPokemonMetadataProvider.class), any(IPokemonFactory.class)))
                .thenReturn(mockPokedex);

        // Tester la création d'un entraîneur avec une autre équipe
        String trainerName = "Misty";
        Team team = Team.MYSTIC;
        PokemonTrainer trainer = trainerFactory.createTrainer(trainerName, team, pokedexFactory);

        // Vérifier les attributs de l'entraîneur créé
        assertEquals(trainerName, trainer.getName());
        assertEquals(team, trainer.getTeam());
        assertEquals(mockPokedex, trainer.getPokedex());
    }
}
