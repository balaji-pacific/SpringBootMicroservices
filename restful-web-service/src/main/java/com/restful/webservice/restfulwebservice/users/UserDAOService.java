/**
 * 
 */
package com.restful.webservice.restfulwebservice.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Balaji
 *
 */
@Component
public class UserDAOService {
	
private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(1, "Balaji", new Date()));
		users.add(new User(2, "Kamala", new Date()));
		users.add(new User(3, "Yashika", new Date()));
		users.add(new User(4, "Deepa", new Date()));
		users.add(new User(5, "Vasuki", new Date()));
		
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if(null == user.getId()){
			user.setId(users.size()+1);
		}
		users.add(user);
		return user;
	}
	
	public User findUser( Integer id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteUser(Integer id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(id == user.getId()) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
