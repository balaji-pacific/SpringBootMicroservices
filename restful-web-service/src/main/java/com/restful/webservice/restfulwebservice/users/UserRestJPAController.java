/**
 * 
 */
package com.restful.webservice.restfulwebservice.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restful.webservice.restfulwebservice.users.exception.CustomResponseEntityExceptionHandler;
import com.restful.webservice.restfulwebservice.users.exception.UserNotFoundException;

/**
 * @author Balaji
 *
 */
@RestController
public class UserRestJPAController extends CustomResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserDAOService userDAOService;
	
	@Autowired
	private UserJPARepository jpaRepository;
	
	@Autowired
	private PostsJPARepository postsRepository;
	
	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers(){
		return jpaRepository.findAll();
	}
	
	@GetMapping(path = "/jpa/print")
	public String printStatement(){
		return "Welcome Minishift";
	}

	@GetMapping(path = "/jpa/users/{id}")
	public Optional<User> findUser(@PathVariable Integer id) {
		Optional<User> findUser = jpaRepository.findById(id);
		if(!findUser.isPresent() ) {
			throw new UserNotFoundException("id = " + id);			
		}
		
		return findUser;
	}
	
	@PostMapping("/jpa/save")
	public ResponseEntity<Object> save(@Valid @RequestBody User user){
		User savedUser = jpaRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/delete/{id}")
	public void delete(@PathVariable Integer id) {
		jpaRepository.deleteById(id);
	}
	
	@GetMapping(path = "/jpa/good-morning-internationalization")
	public String goodMorningInternationalization(){
		return messageSource.getMessage("message.good.morning", null, "Good morning in for all language people :-)", LocaleContextHolder.getLocale());
	}
	
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Posts> findPosts(@PathVariable Integer id) {
		Optional<User> findUser = jpaRepository.findById(id);
		if(!findUser.isPresent() ) {
			throw new UserNotFoundException("id = " + id);			
		}
		
		return findUser.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/save-posts")
	public ResponseEntity<Object> savePosts(@PathVariable int id, @RequestBody Posts posts){
		
		Optional<User> findUser = jpaRepository.findById(id);
		if(!findUser.isPresent() ) {
			throw new UserNotFoundException("id = " + id);			
		}
		
		User user = findUser.get();
		
		posts.setUser(user);
		
		postsRepository.save(posts);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(posts.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}