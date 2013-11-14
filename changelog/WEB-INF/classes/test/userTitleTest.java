package test;
import mydbsearcher.UserManager;;
public class userTitleTest {

	public userTitleTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserManager um = new UserManager();
		um.editTitleByUserID(343, "edit");
	}

}
