package com.obwankenobi.pokedex.services.mappers;


import com.obwankenobi.pokedex.exceptions.PokemonInfoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonInfoStringMapperTest {

    private static PokemonInfoStringMapper pokemonInfoStringMapper;

    @BeforeAll
    public static void setup(){
        pokemonInfoStringMapper = new PokemonInfoStringMapper();
    }

    @Test
    public void givenEmptyTypeData_throwsException() throws PokemonInfoException {
        String typeData = "";
        String descriptionData = "";

        assertThrows(PokemonInfoException.class, ()->pokemonInfoStringMapper.mapJSONStringToPokemonInfo(typeData, descriptionData));
    }
}
