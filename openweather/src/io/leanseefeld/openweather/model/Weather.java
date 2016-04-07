package io.leanseefeld.openweather.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Weather {

	private City city;
	@Temporal(TemporalType.TIMESTAMP)
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
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

}
