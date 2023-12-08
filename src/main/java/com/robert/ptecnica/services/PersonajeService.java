package com.robert.ptecnica.services;

import java.util.List;

import com.robert.ptecnica.models.Personaje;
import com.robert.ptecnica.models.api.RespuestaListaPersonajeApi;

public interface PersonajeService {
	
	public List<Personaje> getPersonajes();
	
	public Personaje guardarPersonaje(Personaje per);
	
}
