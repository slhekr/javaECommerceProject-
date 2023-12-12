package eCommerce.Business.abstracts;

import eCommerce.Entities.concretes.User;

public interface UserService {
	
	void signin (User user);
	void login (User user);
	void confirm (User user);
	void signinWithAccount(User user);
	void loginWithAccount(User user);

}
