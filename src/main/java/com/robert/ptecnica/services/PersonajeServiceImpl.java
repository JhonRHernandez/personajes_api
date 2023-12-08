package com.robert.ptecnica.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robert.ptecnica.models.Personaje;
import com.robert.ptecnica.models.api.PersonajeApi;
import com.robert.ptecnica.models.api.RespuestaListaPersonajeApi;
import com.robert.ptecnica.repositories.PersonajeDao;
import com.robert.ptecnica.repositories.PersonajeFeign;

@Service
public class PersonajeServiceImpl implements PersonajeService{

	@Autowired
	PersonajeFeign personajeClienteApi;
	
	@Autowired
	PersonajeDao personajeDao;
	
	@Override
	public List<Personaje> getPersonajes() {
		// TODO Auto-generated method stub
		RespuestaListaPersonajeApi respuesta = personajeClienteApi.listar();
		
		List<Personaje> personajes = new ArrayList<>();
		
		for (PersonajeApi personaje : respuesta.getResults()) {
			Personaje pers = new Personaje();
			pers.setId(personaje.getId());
			pers.setName(personaje.getName());
			pers.setGender(personaje.getGender());
			pers.setStatus(personaje.getStatus());
			pers.setImage(personaje.getImage());
			
			personajes.add(pers);
		}
		
		
		return personajes;
	}

	@Override
	public Personaje guardarPersonaje(Personaje per) {
		// TODO Auto-generated method stub
		
		Personaje personaje;
		
		//Validar si personaje existe en API Externo
		try {
			RespuestaListaPersonajeApi respuesta = personajeClienteApi.consultarPorNombre(per.getName());
			
			//Si existe entonces respondemos con que no se puede guardar, esto lo hacemos con un null
			return null;
		} catch (Exception e) {
			//Si no existe validar en la base de datos local si existe
			List<Personaje> personajes= personajeDao.findByName(per.getName());
			
			//Si existe en bd local responder que no se puede guardar
			if (!personajes.isEmpty()) {
				return null;
			} else {
				//Si no existe en bd local proceder a guardar y retornar el objeto guardado.
				personaje = personajeDao.save(per);
			}
		}		
		
		return personaje;
	} 
	
	

}
