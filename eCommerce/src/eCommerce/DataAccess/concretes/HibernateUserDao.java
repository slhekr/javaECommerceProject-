package eCommerce.DataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.DataAccess.abstracts.UserDao;
import eCommerce.Entities.concretes.User;

public class HibernateUserDao implements UserDao {
	
	
	List<User> users= new ArrayList<User>();

	@Override
	public void signin(User user) {
		System.out.println( user.getName() + " Kaydedildi");
		
	}

	@Override
	public void login(User user) {
		System.out.println( user.getName() + " Giriþ Yaptý");
		
		
	}

	@Override
	public void confirm(User user) {
		System.out.println( user.getEmail() + "E-mail Adresi Doðrulandý");
		user.setVerify(true);
		
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return this.users;
	}

	

}
