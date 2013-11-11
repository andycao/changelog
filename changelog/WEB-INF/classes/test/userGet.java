package test;
import mydbsearcher.UserManager;
public class userGet {

	public userGet() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserManager um = new UserManager();
		String username = um.getUserNameByID(61);
		System.out.println(username+"");
		
		um.deleteUser(101);
	}

}
