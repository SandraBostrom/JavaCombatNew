package org.example.MockTest;

import org.example.JustAMockTest.SpecialPokemons;
import org.example.JustAMockTest.SpecialPokemonsImpl;
import org.example.Models.AllPoke;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpecialPokemonsImplMockTest {
    @Test
    public void test() {
        SpecialPokemons specialPokemons = mock(SpecialPokemons.class);
        List<String> pokemons = Arrays.asList("Raichu", "Ponyta", "Charizad");
        when(specialPokemons.retrievePokemons("Start")).thenReturn(pokemons);

        SpecialPokemonsImpl pokemon = new SpecialPokemonsImpl(specialPokemons);
        List<String> filteredPokemons = pokemon.retrieveSpeicalPokemons("Start");
        assertEquals(1, filteredPokemons.size());
    }
}


