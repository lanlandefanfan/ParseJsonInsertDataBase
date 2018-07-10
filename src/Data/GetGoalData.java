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
 * ��ȡ��jsonָ���ֶε�����
 */

public class GetGoalData {

	GetJson getjson;
	String json;

	public GetGoalData(String url) {

		getjson = new GetJson();
		json = getjson.FromUrlLoadJson(url);

	}

	/**
	 * JsonParser����json�����ࡣ�����ַ���Ϊjson��ʽ��Ȼ���ڽ���Ϊһ��һ��jsonelement
	 * jsonelement�������Ϊjson����Ԫ�أ��ȿ�����jsonҲ�������ַ�������Ϳ�json�ĸ��ӳ̶�
	 * jsonArray���ǰ�json���Ͻ�����������������
	 * */
	public List<temperatureBean> goalData() {
		List<temperatureBean> temperaturelist = new ArrayList<temperatureBean>();
		// ����json
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
		// ��ȡ��һ���result��json����
		JsonElement elementResult = jsonObject.get("result");
		JsonObject jsonResult = elementResult.getAsJsonObject();
		// ��ȡ��һ���status��string
		JsonElement elementStatus = jsonObject.get("status");
		String status = elementStatus.getAsString();
		// ��ȡ�ڶ����hourly��json����
		JsonElement hourlyResult = jsonResult.get("hourly");
		JsonObject jsonHourly = hourlyResult.getAsJsonObject();
		// ��ȡ�������temperature��json����
		JsonArray jsonArray = jsonHourly.getAsJsonArray("temperature");

		// ѭ����������
		for (JsonElement user : jsonArray) {
			temperatureBean temperaturebean = new Gson().fromJson(user, new TypeToken<temperatureBean>() {
			}.getType());
			temperaturelist.add(temperaturebean);
		}

		return temperaturelist;
	}

}
