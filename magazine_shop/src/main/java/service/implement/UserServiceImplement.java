package service.implement;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import dao.UserDao;
import domain.User;
import implement.UserDaoImplement;
import service.UserService;

public class UserServiceImplement implements UserService {

	private static Logger LOGGER = Logger.getLogger(UserServiceImplement.class);
	private static UserService userServiceImplement;
	private UserDao userDao;

	private UserServiceImplement() {

		try {
			userDao = new UserDaoImplement();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error("Error - UserServiceImplement - ", e);
		}
	}

	public static UserService getUserService() {
		if (userServiceImplement == null) {
			userServiceImplement = new UserServiceImplement();
		}
		return userServiceImplement;
	}

	@Override
	public User create(User user) {
		return userDao.create(user);
	}

	@Override
	public User read(Integer id) {
		return userDao.read(id);
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
}
