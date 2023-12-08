package com.robert.ptecnica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robert.ptecnica.models.Personaje;
import com.robert.ptecnica.services.PersonajeService;

@RestController
@RequestMapping("api/v1/personajes")
public class PersonajesController {
	
	@Autowired
	PersonajeService personajeServiceImpl;

	
	@GetMapping("")
	public ResponseEntity<List<Personaje>> getPersonajes(){
		
		List<Personaje> msj = personajeServiceImpl.getPersonajes() ;
		
		return ResponseEntity.ok(msj);
		
	}
	
	@PostMapping("")
	public ResponseEntity<String> addPersonaje(@RequestBody Personaje per){
		
		Personaje resp = personajeServiceImpl.guardarPersonaje(per);
		String msj = "";
		
		if (resp==null) {
			msj="No se puede guardar el personaje";
		} else {
			msj="Personaje guardado";
		}
		
		return ResponseEntity.ok(msj);
		
	}
	
}
