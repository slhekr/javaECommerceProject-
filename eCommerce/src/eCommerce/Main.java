package eCommerce;

import eCommerce.Business.abstracts.UserService;
import eCommerce.Business.concretes.UserManager;
import eCommerce.Core.GoogleAuthManagerAdapter;
import eCommerce.DataAccess.concretes.HibernateUserDao;
import eCommerce.Entities.concretes.User;
import eCommerce.googleAuth.GoogleAuthManager;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao(),new GoogleAuthManagerAdapter(new GoogleAuthManager()));
		User user= new User("saliha","Eker","salihaeker@gmail.com","1234567",true);
		User user1= new User("Ahmet","Çýnar","ahmetcinar@gmail.com","12345678",true);
		
		userService.signin(user1);
		userService.login(user1);
		userService.confirm(user1);
		userService.signinWithAccount(user1);
		userService.loginWithAccount(user1);

	}

}
