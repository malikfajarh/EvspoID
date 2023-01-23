package factory;

import model.User;

public class UserFactory {
	
	public User makeUser(String username, String password, String address) {
		return new User(username, password, address);
	}
}
