package io.leanseefeld.openweather;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import io.leanseefeld.openweather.dao.FavoritesDAO;

@WebListener
public class MainListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent context) {
		FavoritesDAO favoritesDAO = (FavoritesDAO) context.getServletContext().getAttribute("favoritesDAO");
		favoritesDAO.close();
	}

	public void contextInitialized(ServletContextEvent context) {
		EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("openweather");
		FavoritesDAO favoritesDAO = new FavoritesDAO(entityManager);
		context.getServletContext().setAttribute("favoritesDAO", favoritesDAO);
	}

}
