package eCommerce.Business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerce.Business.abstracts.UserService;
import eCommerce.Core.AuthService;
import eCommerce.DataAccess.abstracts.UserDao;
import eCommerce.Entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private AuthService authService;  

	public UserManager(UserDao userDao, AuthService authService) {
		this.userDao = userDao;
		this.authService = authService;
	}

	@Override
	public void signin(User user) {
		if(user.getPassword().length() <6) {
			System.out.println("�ifreniz en az alt� karekterden olu�mal�d�r");
		}
		
		final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
		final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(user.getEmail());
		if(!matcher.matches()) {
			System.out.println(user.getEmail() + "E-posta format�na uygun de�il");
		}
		for(User users:userDao.getAll()) {
			
			if(users.getEmail().equals(user.getEmail())) {
				System.out.println(user.getEmail() + "Bu E-posta adresi sistemde bulunmaktad�r");
				
			}
		}
		
		if(user.getName().length() <2 && user.getSurname().length()<2 ) {
			System.out.println("Ad ve soyad en az iki karakterden olu�mal�d�r.");
		}
		
			
		
	}

	@Override
	public void login(User user) {
		if(user.isVerify()==true) {
			userDao.login(user);
			
		}else {
			System.out.println("Giri� yap�lamad�. E-posta hesab�n�z� kontrol edin");
		}		
		
	}

	@Override
	public void confirm(User user) {
		if(user.isVerify()==true) {
			userDao.confirm(user);
			System.out.println("E-posta adresiniz do�ruland�");
		}else {
			System.out.println("E-posta adresiniz do�rulay�n");
		}
		
	}

	@Override
	public void signinWithAccount(User user) {
		user.setVerify(true);
		this.authService.signin(user);
		
	}

	@Override
	public void loginWithAccount(User user) {
		if(user.isVerify()==true) {
			this.authService.login(user);
		}else {
			System.out.println("Kay�tl� de�il");
		}
		
	}
	
	

}
