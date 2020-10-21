package server.service;


import common.IUserService;
import common.bean.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

	@Override
	public User getUserByName(String username) {
		User user = null;
		if (username != null && !username.equals("")) {
			user = new User();
			if (username.equals("admin")) {
				user.setUsername("admin");
				user.setPassword("123456");
			}else{
				user.setUsername("xxxxx");
				user.setPassword("111111");
			}
			
		}
		return user;
	}

}
