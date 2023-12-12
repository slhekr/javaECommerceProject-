package eCommerce.Core;

import eCommerce.Entities.concretes.User;

public interface AuthService {
	
	void signin(User user);
	
	void login(User user);

}
