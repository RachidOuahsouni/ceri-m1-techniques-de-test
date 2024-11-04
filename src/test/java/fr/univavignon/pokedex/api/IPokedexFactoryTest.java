package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokedexFactoryTest {
    private IPokedexFactory iPokedexFactory;
    private IPokemonFactory iPokemonFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokedex iPokedex;

    @BeforeEach
    public void setUp(){
        iPokedexFactory= Mockito.mock(IPokedexFactory.class);
        iPokemonFactory=Mockito.mock(IPokemonFactory.class);
        metadataProvider=Mockito.mock(IPokemonMetadataProvider.class);

    }


    
    @Test
    public void testCreatePokedex(){
        when(iPokedexFactory.createPokedex(metadataProvider,iPokemonFactory)).thenReturn(iPokedex);
        assertEquals(iPokedex,iPokedexFactory.createPokedex(metadataProvider,iPokemonFactory));
    }
}
