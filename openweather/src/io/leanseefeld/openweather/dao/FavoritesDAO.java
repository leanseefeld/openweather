package io.leanseefeld.openweather.dao;

import java.io.Closeable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import io.leanseefeld.openweather.model.City;

public class FavoritesDAO implements Closeable {

	private final EntityManager entityManager;

	public FavoritesDAO(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	public City add(String cityStr) throws IllegalArgumentException {
		City city = findCity(cityStr);
		if (city == null) {
			throw new IllegalArgumentException("Unknown city '" + cityStr
					+ "'. Follow the standard 'City Name, CC', being CC the ISO country code for the city.");
		}

		entityManager.getTransaction().begin();

		city.setFavorite(true);
		entityManager.persist(city);

		entityManager.getTransaction().commit();
		return city;
	}

	public void remove(int cityId) {
		City city = findCity(cityId);
		if (city != null && city.isFavorite()) {
			entityManager.getTransaction().begin();

			city.setFavorite(false);
			entityManager.persist(city);

			entityManager.getTransaction().commit();
		}

	}

	public List<City> getFavorites() {
		TypedQuery<City> q = entityManager.createQuery("SELECT c FROM City c WHERE c.favorite is true", City.class);
		return q.getResultList();
	}

	private City findCity(String city) {
		if (city != null && !"".equals(city.trim())) {
			String[] parts = city.split(",");
			if (parts.length > 1) {
				TypedQuery<City> q = entityManager
						.createQuery("SELECT c FROM City c WHERE c.name = :name AND c.country = :country", City.class);
				q.setParameter("name", parts[0].trim());
				q.setParameter("country", parts[1].trim().toUpperCase());

				List<City> resultList = q.getResultList();
				if (!resultList.isEmpty()) {
					return resultList.get(0);
				}
			}
		}
		return null;
	}

	private City findCity(int id) {
		return entityManager.find(City.class, id);
	}

	@Override
	public void close() {
		entityManager.close();
	}

}
