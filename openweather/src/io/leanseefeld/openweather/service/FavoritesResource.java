package io.leanseefeld.openweather.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.leanseefeld.openweather.dao.FavoritesDAO;
import io.leanseefeld.openweather.model.City;

@Path("/favorites")
public class FavoritesResource {

	@Context
	private ServletContext context;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<City> getFavorites() {
		return getFavoritesDao(context).getFavorites();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response add(@FormParam("city") String cityName) {
		try {
			return Response.status(Status.CREATED).entity(getFavoritesDao(context).add(cityName)).build();
		} catch (IllegalArgumentException e) {
			throw new BadRequestException(Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build());
		}
	}

	@DELETE
	@Path("/{id}")
	public Response remove(@PathParam("id") int cityId) {
		getFavoritesDao(context).remove(cityId);
		return Response.ok().build();
	}

	private FavoritesDAO getFavoritesDao(ServletContext context) {
		return (FavoritesDAO) context.getAttribute("favoritesDAO");
	}

}
