package common;


import common.bean.User;

public interface IUserService {

	User getUserByName(String username);
	
}
