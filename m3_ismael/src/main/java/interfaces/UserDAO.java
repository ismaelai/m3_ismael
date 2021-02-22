package interfaces;
import java.util.List;

import entities.User;
public interface UserDAO {
	//definir las operaciones Crud 
	 //It returns one user by id
	 User findOne(Long id);
	//recuperar todo
		 //it returns all users from user table from database
		 List<User> findAll();
	 //crear un usuario
		 //void,boolean o User
		 //it creates a new user in database
		boolean create(User user);
		// it updates current user in database
		 boolean update(User user);
		 boolean delete(long l);
}
