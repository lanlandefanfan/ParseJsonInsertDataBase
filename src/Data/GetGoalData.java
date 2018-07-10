package Data;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import Data.hourlyBean.temperatureBean;

/**
 * 获取到json指定字段的数据
 */

public class GetGoalData {

	GetJson getjson;
	String json;

	public GetGoalData(String url) {

		getjson = new GetJson();
		json = getjson.FromUrlLoadJson(url);

	}

	/**
	 * JsonParser类是json解析类。解析字符串为json格式，然后在解析为一个一个jsonelement
	 * jsonelement可以理解为json的子元素，既可以是json也可以是字符串，这就看json的复杂程度
	 * jsonArray就是把json不断解析，最后解析到数组
	 * */
	public List<temperatureBean> goalData() {
		List<temperatureBean> temperaturelist = new ArrayList<temperatureBean>();
		// 解析json
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
		// 获取第一层的result的json对象
		JsonElement elementResult = jsonObject.get("result");
		JsonObject jsonResult = elementResult.getAsJsonObject();
		// 获取第一层的status的string
		JsonElement elementStatus = jsonObject.get("status");
		String status = elementStatus.getAsString();
		// 获取第二层的hourly的json对象
		JsonElement hourlyResult = jsonResult.get("hourly");
		JsonObject jsonHourly = hourlyResult.getAsJsonObject();
		// 获取第三层的temperature的json数组
		JsonArray jsonArray = jsonHourly.getAsJsonArray("temperature");

		// 循环遍历数组
		for (JsonElement user : jsonArray) {
			temperatureBean temperaturebean = new Gson().fromJson(user, new TypeToken<temperatureBean>() {
			}.getType());
			temperaturelist.add(temperaturebean);
		}

		return temperaturelist;
	}

}
