package io.leanseefeld.openweather.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class City implements Serializable {

	private static final long serialVersionUID = -7260542117140909188L;

	@Id
	private int id;
	private String name;
	private String country;
	private float lat, lon;
	@Column(name = "lastsync")
	private Date lastUpdate;
	private boolean favorite;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + (favorite ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + Float.floatToIntBits(lat);
		result = prime * result + Float.floatToIntBits(lon);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		City other = (City) obj;
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
		if (favorite != other.favorite) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (lastUpdate == null) {
			if (other.lastUpdate != null) {
				return false;
			}
		} else if (!lastUpdate.equals(other.lastUpdate)) {
			return false;
		}
		if (Float.floatToIntBits(lat) != Float.floatToIntBits(other.lat)) {
			return false;
		}
		if (Float.floatToIntBits(lon) != Float.floatToIntBits(other.lon)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
