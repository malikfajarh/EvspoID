package repository;

import java.util.ArrayList;

import model.User;

public class UsersRepository {
	
	private ArrayList<User> userList;
	private static UsersRepository usersRepository;
	
	private UsersRepository() {
		userList = new ArrayList<>();
	}
	
//	Singleton design pattern
	public static UsersRepository getUsersRepository() {
		if(usersRepository == null) {
			usersRepository = new UsersRepository();
		}
		return usersRepository;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void addUserList(User users) {
		userList.add(users);
	}
	
}

