package com.example.demo.userservice;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserRESTService {
	
	@Autowired
	public UserRepository userRepository;
	 
	@Autowired
	public PostRespository postRespository;
	
	@Autowired
	public ApplicationDAO dao;
	
	@GetMapping("/users")
	public List<UserEntity> findAll(){
		//return userRepository.findAll();	
		return dao.getUsers();	
	}
	@GetMapping("/users/v1")
	public List<UserEntity> findAllV1(){
		return userRepository.findAll();		
	}
	
	@GetMapping(value="/users/param", params="v=1")
	public List<UserEntity> findAllParamV1(){
		return userRepository.findAll();		
	}
	@GetMapping(value="/users/header", headers="X-API-V=1")
	public List<UserEntity> findAllHeaderV1(){
		return userRepository.findAll();	
	}

	@GetMapping(value="/users/produce", produces="application/vnd.company.app-v1+xml")
	public List<UserEntity> findAllMediaOrProducesXML(){
		return userRepository.findAll();		
	}

	@GetMapping(value="/users/produce", produces="application/vnd.company.app-v1+json")
	public List<UserEntity> findAllMediaOrProducesJSON(){
		return userRepository.findAll();		
	}	

	@GetMapping("/users/{id}")
	public UserEntity retreive(@PathVariable Integer id) {
		Optional<UserEntity> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("Id="+id);
		}
		return user.get();
	}
	
	@GetMapping("/users/{id}/posts")
	public List<PostsEntity> retreivePosts(@PathVariable Integer id) {
		Optional<UserEntity> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("Id="+id);
		}
		
		return user.get().getPosts();
	}	
	
	@PostMapping("/users/{id}/post")
	public void createPosts(@RequestBody PostsEntity post, @PathVariable Integer id) {
		Optional<UserEntity> user = userRepository.findById(id);
		
		if (!user.isPresent()) {
			throw new UserNotFoundException("Id="+id);
		}
		
		UserEntity userEntity = user.get();
		System.out.println("posts->"+userEntity.getPosts());
		post.setUser(userEntity);
		userEntity.addPost(post);
		userRepository.save(userEntity);
//		post.setUser(userEntity);
//		postRespository.save(post);

	}	
		
	
	@PostMapping("/user")
	public UserEntity createUser(@Valid @RequestBody UserEntity user)  throws Exception {
		if (user.getId() != null) {
			throw new Exception("I am an Exception..");
		}
		UserEntity createdUser = userRepository.save(user);
		if (createdUser.getId() == null) {
			throw new Exception("I am an Exception..");
		}
		
		return createdUser;
	}
	
	@PutMapping("/user")
	public UserEntity updateUser(@Valid @RequestBody UserEntity user)  throws Exception {
		if (user.getId() == null) {
			throw new Exception("I am an Exception..");
		}		
		UserEntity updatedUser =userRepository.save(user);
		
		return updatedUser;
	}	
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Integer id)  throws Exception {

		userRepository.deleteById(id);

	}	
}
