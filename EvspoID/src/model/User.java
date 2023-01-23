package model;

public class User {
	private String username;
	private String password;
	private String address;

	public User(String username, String password, String address) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
