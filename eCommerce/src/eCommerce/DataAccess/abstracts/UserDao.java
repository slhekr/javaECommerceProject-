package eCommerce.DataAccess.abstracts;

import java.util.List;

import eCommerce.Entities.concretes.User;

public interface UserDao {
	
	void signin (User user);
	void login (User user);
	void confirm(User user);
	
	List<User> getAll();

}
