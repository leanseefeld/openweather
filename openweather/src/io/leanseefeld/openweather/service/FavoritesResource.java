package io.leanseefeld.openweather.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.leanseefeld.openweather.model.City;

@Path("/favorites")
public class FavoritesResource {

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<City> getFavorites() {
		// TODO
		ArrayList<City> arr = new ArrayList<>();
		City c = new City();
		c.setCountry("BR");
		c.setName("Blumenau");
		arr.add(c);
		return arr;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Boolean add(@FormParam("city") String cityName) {
		// TODO
		return Boolean.FALSE;
	}

	@DELETE
	@Path("/{id}")
	public Boolean remove(@PathParam("id") String cityId) {
		// TODO
		return Boolean.FALSE;
	}

}
