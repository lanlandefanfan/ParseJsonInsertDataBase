package sql;

import Data.timer;

/**
 * Ö÷·½·¨
 */

public class main {

	public static void main(String[] args) {
		FromXml xml = new FromXml();
		String url = xml.getUrl();
		int time = xml.getTime();
		timer t = new timer(url, time);
		t.timeHourly();
	}

}
