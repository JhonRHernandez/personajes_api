package com.robert.ptecnica.models.api;

import java.util.List;

public class RespuestaListaPersonajeApi {
	private InfoApi info;
	
	
	public InfoApi getInfo() {
		return info;
	}
	public void setInfo(InfoApi info) {
		this.info = info;
	}
	public List<PersonajeApi> getResults() {
		return results;
	}
	public void setResults(List<PersonajeApi> results) {
		this.results = results;
	}
	private List<PersonajeApi> results;
	//private Location location;
	//private Episode episode;
}
