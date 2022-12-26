package dao;

import abstractInterface.AbstractCRUD;
import domain.User;

public interface UserDao extends AbstractCRUD<User> {

	User getUserByEmail(String email);
}
