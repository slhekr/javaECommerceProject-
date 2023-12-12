package eCommerce.Core;

import eCommerce.Entities.concretes.User;
import eCommerce.googleAuth.GoogleAuthManager;


public class GoogleAuthManagerAdapter implements AuthService {
	
	GoogleAuthManager googleAuthManager;
	
	public GoogleAuthManagerAdapter(GoogleAuthManager googleAuthManager) {
		this.googleAuthManager=googleAuthManager;
	}

	@Override
	public void signin(User user) {
		googleAuthManager.signin(user);
		
	}

	@Override
	public void login(User user) {
		googleAuthManager.login(user);
		
	}

}
