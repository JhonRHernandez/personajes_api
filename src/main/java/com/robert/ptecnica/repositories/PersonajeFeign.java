package com.robert.ptecnica.repositories;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.robert.ptecnica.models.Personaje;
import com.robert.ptecnica.models.api.RespuestaListaPersonajeApi;

@FeignClient(name="personajes", url="https://rickandmortyapi.com/api/character")
public interface PersonajeFeign {

	@GetMapping("")
	public RespuestaListaPersonajeApi listar();
	
	@GetMapping("/?name={name}")
	public RespuestaListaPersonajeApi consultarPorNombre(@PathVariable String name);
	
}
