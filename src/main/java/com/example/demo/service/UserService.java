package com.example.demo.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;
import com.example.demo.model.UserDto;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public String addUser(UserDto userDto) {
		try {
			String pwd = userDto.getPassword();
			String encryptpwd = passwordEncoder.encode(pwd);
			userDto.setPassword(encryptpwd);
		userRepo.save(usrDtoToModel(userDto));
		return "Success : True";
		}
		catch (Exception e) {
			System.out.println(e);
			return "Failed : False";
		}
	}
	
	
	public User UserPreOrNot(String Name) {
		User usr = userRepo.findByUserName(Name);
		return usr;
	}
	
	
	public User usrDtoToModel( UserDto userDto ) {
		User  user = new User();
		user.setCreated_at(userDto.getCreated_at());
		user.setDeleted_at(userDto.getDeleted_at());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setType(userDto.getType());
		user.setUpdated_at(userDto.getUpdated_at());
		user.setUser_id(userDto.getUser_id());
		user.setUser_mail(userDto.getUser_mail());
		return user;
	}
	
	public List<User> getAllUsers(){
		List<User> users=(List<User>)userRepo.findAll();
		return users;
	}
	
	public User getUserById(int usrID) throws UserPrincipalNotFoundException {
		Optional<User> user = userRepo.findById(usrID);
		
		if( !user.isPresent() )
			throw new UserPrincipalNotFoundException("Id - " + usrID);
		
		return user.get();
	}
	
	public String deleteUser(int usrID) {
		try {
			userRepo.deleteById(usrID);
			return "Success";
			}
			catch (Exception e) {
				System.out.println(e);
				return "Failed";
			}		
	}
	
	public List<User> findAllPaginated( int pageNo , int pageSize ) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<User> pagedResult = userRepo.findAll(paging);
		
		return pagedResult.toList();
	}
	
}
