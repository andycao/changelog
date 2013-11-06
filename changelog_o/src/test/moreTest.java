package test;
import java.sql.Date;

import changelog.*;
public class moreTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		myDb mydb = new myDb();
		//mydb.addUser(3, "hehe", "hehe", "hehe");
		Date today = Date.valueOf("2013-1-1");
	//	mydb.addProject(1, "Venus",today , "go go go");
	//	mydb.addProgram(3, 1, "like", today, "la la la");
		mydb.addVersion("1.1", 1, "complete another version haha haha 哇哇");
	}

}
