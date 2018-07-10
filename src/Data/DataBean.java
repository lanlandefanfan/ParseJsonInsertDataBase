package Data;

import java.util.List;

/**
 * json数据的外层的对象类
 * */

public class DataBean {

	private resultBean result;

	public static class resultBean {
		private List<hourlyBean> hourly;
		private int primary;
		private String minutely;

		public List<hourlyBean> getHourly() {
			return hourly;
		}

		public void setHourly(List<hourlyBean> hourly) {
			this.hourly = hourly;
		}

		public int getPrimary() {
			return primary;
		}

		public void setPrimary(int primary) {
			this.primary = primary;
		}

		public String getMinutely() {
			return minutely;
		}

		public void setMinutely(String minutely) {
			this.minutely = minutely;
		}

		public String getDaily() {
			return daily;
		}

		public void setDaily(String daily) {
			this.daily = daily;
		}

		private String daily;
	}

	private String status;
	private String lang;
	private int server_time;
	private String api_status;
	private int tzshift;
	private String api_version;
	private String unit;
	private String location;

	public resultBean getResult() {
		return result;
	}

	public void setResult(resultBean result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public int getServer_time() {
		return server_time;
	}

	public void setServer_time(int server_time) {
		this.server_time = server_time;
	}

	public String getApi_status() {
		return api_status;
	}

	public void setApi_status(String api_status) {
		this.api_status = api_status;
	}

	public int getTzshift() {
		return tzshift;
	}

	public void setTzshift(int tzshift) {
		this.tzshift = tzshift;
	}

	public String getApi_version() {
		return api_version;
	}

	public void setApi_version(String api_version) {
		this.api_version = api_version;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
