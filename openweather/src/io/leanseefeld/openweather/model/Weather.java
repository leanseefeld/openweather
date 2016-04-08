package io.leanseefeld.openweather.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Weather implements Serializable {

	private static final long serialVersionUID = 8161563149594327611L;

	@Id
	private int city;
	@Temporal(TemporalType.TIMESTAMP)
	@Id
	private Calendar day;

	private float temp;
	private float temp_min;
	private float temp_max;
	private float pressure;
	private float sea_level;
	private float grnd_level;
	private float humidity;

	private float windSpeed;
	private float windDeg;

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	/**
	 * Day of forecasted data
	 * 
	 * @return day of forecasted data
	 */
	public Calendar getDay() {
		return day;
	}

	public void setDay(Calendar day) {
		this.day = day;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(float temp_min) {
		this.temp_min = temp_min;
	}

	public float getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(float temp_max) {
		this.temp_max = temp_max;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getSea_level() {
		return sea_level;
	}

	public void setSea_level(float sea_level) {
		this.sea_level = sea_level;
	}

	public float getGrnd_level() {
		return grnd_level;
	}

	public void setGrnd_level(float grnd_level) {
		this.grnd_level = grnd_level;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public float getWindDeg() {
		return windDeg;
	}

	public void setWindDeg(float windDeg) {
		this.windDeg = windDeg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + city;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + Float.floatToIntBits(grnd_level);
		result = prime * result + Float.floatToIntBits(humidity);
		result = prime * result + Float.floatToIntBits(pressure);
		result = prime * result + Float.floatToIntBits(sea_level);
		result = prime * result + Float.floatToIntBits(temp);
		result = prime * result + Float.floatToIntBits(temp_max);
		result = prime * result + Float.floatToIntBits(temp_min);
		result = prime * result + Float.floatToIntBits(windDeg);
		result = prime * result + Float.floatToIntBits(windSpeed);
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
		Weather other = (Weather) obj;
		if (city != other.city) {
			return false;
		}
		if (day == null) {
			if (other.day != null) {
				return false;
			}
		} else if (!day.equals(other.day)) {
			return false;
		}
		if (Float.floatToIntBits(grnd_level) != Float.floatToIntBits(other.grnd_level)) {
			return false;
		}
		if (Float.floatToIntBits(humidity) != Float.floatToIntBits(other.humidity)) {
			return false;
		}
		if (Float.floatToIntBits(pressure) != Float.floatToIntBits(other.pressure)) {
			return false;
		}
		if (Float.floatToIntBits(sea_level) != Float.floatToIntBits(other.sea_level)) {
			return false;
		}
		if (Float.floatToIntBits(temp) != Float.floatToIntBits(other.temp)) {
			return false;
		}
		if (Float.floatToIntBits(temp_max) != Float.floatToIntBits(other.temp_max)) {
			return false;
		}
		if (Float.floatToIntBits(temp_min) != Float.floatToIntBits(other.temp_min)) {
			return false;
		}
		if (Float.floatToIntBits(windDeg) != Float.floatToIntBits(other.windDeg)) {
			return false;
		}
		if (Float.floatToIntBits(windSpeed) != Float.floatToIntBits(other.windSpeed)) {
			return false;
		}
		return true;
	}

}
