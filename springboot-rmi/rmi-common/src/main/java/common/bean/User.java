package common.bean;

import java.io.Serializable;
/**
 * 网络间的传输必须实现序列化接口，不然在客户端反序列化的时候就会报错
 */
public class User implements Serializable {

	private String username;
	private String password;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
