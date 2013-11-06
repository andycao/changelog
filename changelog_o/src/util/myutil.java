package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class myutil {

	public static java.util.Date stringToDate(String d) {
		try{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.parse(d);
		}catch(ParseException e){
			System.err.println(e);
			return null;
		}
	}

}
