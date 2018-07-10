package Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import Data.hourlyBean.temperatureBean;
import sql.FromXml;
import sql.InsertData;

/**
 * 定时器,执行定时任务
 */

public class timer {

	int i;// 执行次数
	int time;// 定时时间
	String url;
	InsertData insert;// 操作数据库类
	GetGoalData data;// 获取数据类
	List<temperatureBean> temperaturelist;
	FromXml xml;// 操作配置文件类

	public timer(String url, int time) {
		i = 0;
		this.time = time;
		this.url = url;
		insert = new InsertData();
		data = new GetGoalData(url);
		temperaturelist = new ArrayList<temperatureBean>();
		xml = new FromXml();
	}

	public void timeHourly() {

		int longtime = time * 60 * 1000;// 定时时间间隔是分钟
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {

				temperaturelist = data.goalData();
				for (temperatureBean temperature : temperaturelist) {
					insert.add(temperature.getDatatime(), temperature.getValue());
				}
				Date day = new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				i++;
				System.out.println("当前时间：" + df.format(day));
				System.out.println("当前插入时间间隔:" + xml.getTime() + "分钟");
				System.out.println("插入第" + i + "次");
			}

		}, 1000, longtime);// 设定指定的时间time,此处为5000毫秒

	}

}
