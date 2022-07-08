package com.obwankenobi.pokedex.feignclients;

import com.obwankenobi.pokedex.feignclients.model.PokemonTableTypes;
import com.obwankenobi.pokedex.model.StrategyRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("${feign.clients.type.name}")
public interface PokemonTableTypesClient {

    @CircuitBreaker(name = "pokemon-tabletypes-client", fallbackMethod = "getPokemonTableTypesFallback")
    @PostMapping(value = "${feign.clients.type.resource}")
    PokemonTableTypes getPokemonTableTypes(@RequestBody StrategyRequest type);

    default PokemonTableTypes getPokemonTableTypesFallback(StrategyRequest strategyRequest, Throwable error){
        return new PokemonTableTypes();
    }

}
