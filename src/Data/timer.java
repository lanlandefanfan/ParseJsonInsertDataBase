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
 * ��ʱ��,ִ�ж�ʱ����
 */

public class timer {

	int i;// ִ�д���
	int time;// ��ʱʱ��
	String url;
	InsertData insert;// �������ݿ���
	GetGoalData data;// ��ȡ������
	List<temperatureBean> temperaturelist;
	FromXml xml;// ���������ļ���

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

		int longtime = time * 60 * 1000;// ��ʱʱ�����Ƿ���
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
				System.out.println("��ǰʱ�䣺" + df.format(day));
				System.out.println("��ǰ����ʱ����:" + xml.getTime() + "����");
				System.out.println("�����" + i + "��");
			}

		}, 1000, longtime);// �趨ָ����ʱ��time,�˴�Ϊ5000����

	}

}
