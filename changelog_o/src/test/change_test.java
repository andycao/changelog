package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import changelog.*;

public class change_test {
	public static void main (String args[]){
		myDb mydb = new myDb();
		String changedetail = "I have changed .... as the file in .... need ....." +
				"now .... is in the format of .......";
		String url = "/...../.../...jsp;..../.../...css";
		mydb.addChange(1, 1, new Date(0), changedetail, url);
	}
}
