package Data;

import java.util.List;

/**
 * json数据的内层的对象类
 * */

public class hourlyBean {

	private List<temperatureBean> temperature;

	public static class temperatureBean {
		private double value;
		private String datetime;

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		public String getDatatime() {
			return datetime;
		}

		public void setDatatime(String datatime) {
			this.datetime = datatime;
		}
	}

	private String status;
	private String description;
	private String skycon;
	private String cloudrate;
	private String aqi;

	public List<temperatureBean> getTemperature() {
		return temperature;
	}

	public void setTemperature(List<temperatureBean> temperature) {
		this.temperature = temperature;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSkycon() {
		return skycon;
	}

	public void setSkycon(String skycon) {
		this.skycon = skycon;
	}

	public String getCloudrate() {
		return cloudrate;
	}

	public void setCloudrate(String cloudrate) {
		this.cloudrate = cloudrate;
	}

	public String getAqi() {
		return aqi;
	}

	public void setAqi(String aqi) {
		this.aqi = aqi;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPres() {
		return pres;
	}

	public void setPres(String pres) {
		this.pres = pres;
	}

	public String getPm25() {
		return pm25;
	}

	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}

	public String getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(String precipitation) {
		this.precipitation = precipitation;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	private String humidity;
	private String pres;
	private String pm25;
	private String precipitation;
	private String wind;

}
