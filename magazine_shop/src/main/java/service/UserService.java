package service;

import abstractInterface.AbstractCRUD;
import domain.User;

public interface UserService extends AbstractCRUD<User>{

	User getUserByEmail(String email);
}
