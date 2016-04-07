package io.leanseefeld.openweather.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.leanseefeld.openweather.model.Weather;

@Path("/weather")
@Produces(MediaType.APPLICATION_JSON)
public class WeatherResource {
	
	@GET
	@Path("{id}")
	public List<Weather> get(String cityId) {
		// TODO
		return null;
	}

}
