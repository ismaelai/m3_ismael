package interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.User;
import util.JPAUtil;

public class UserDAOImpl implements UserDAO {
	EntityManager manager;
@Override
	public User findOne(Long id) {
		User user = null;
		try {
			manager = JPAUtil.getEntityManager();
			user = manager.find(User.class, id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
}
		return user;
	}

	@Override
	public List<User> findAll() {

try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<User> namedQuery = manager.createNamedQuery("User.findAll",User.class);
			List<User> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
return new ArrayList<User>();
		}

	@Override
	public boolean create(User user) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.persist(user); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(User user) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			manager.merge(user); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public boolean delete(long l) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();   
			User user = manager.find(User.class, id);
			if (user != null) {
				manager.remove(user);
				manager.getTransaction().commit(); 
				flag = true;
			}
manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
