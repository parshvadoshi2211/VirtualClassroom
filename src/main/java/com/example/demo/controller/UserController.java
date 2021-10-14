package com.example.demo.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.filter.jwtFilter;
import com.example.demo.model.AuthRequest;
import com.example.demo.model.User;
import com.example.demo.model.UserDto;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;

@RestController
@RequestMapping("/")
public class UserController {
	
	private static final ServletResponse HttpServletResponse = null;

	private static final ServletRequest HttpServletRequest = null;
	
	public static int userType;

	@Autowired
	private UserService userService;
	
	@Autowired 
	AuthRequest authenticationRequest;
	
	@Autowired
	private JwtUtil jwtUtil;
		
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/")
	public ResponseEntity<String> Welcome() {
		String val = "Hello With Http Code";
		
		if( HttpStatus.INTERNAL_SERVER_ERROR == null ) {
			return new ResponseEntity<String>("insernal Server error" , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else if( HttpStatus.FORBIDDEN == null ) {
			return new ResponseEntity<String>("Forbidden Error" , HttpStatus.FORBIDDEN);
		}
		
		return new ResponseEntity<String>(val , HttpStatus.OK);
	}
	
	@PostMapping("/authenticate")
	public String generateToken( @RequestBody AuthRequest authenticationRequest){
		
		String str1;
		
		
		User presentUsr = UserPreOrNot(authenticationRequest.getUsrname());
		
		if( presentUsr == null ) {
		UserDto user = new UserDto();
		user.setCreated_at(null);
		user.setDeleted_at(null);
		user.setName(null);
		user.setPassword(authenticationRequest.getPassword());
		user.setType(authenticationRequest.getUser_type());
		user.setUpdated_at(null);
		user.setUser_mail(authenticationRequest.getUsrname());
		String response=userService.addUser(user);
		}
		
		
		userType=authenticationRequest.getUser_type();
		
		String str = jwtUtil
				.generateToken(authenticationRequest.getUsrname()  ,authenticationRequest.getUser_type() );
		str1 = "Token : " + str;
		return str1;
	}
		private User UserPreOrNot(String usrname) {
		User usr = userService.UserPreOrNot(usrname);
		return usr;
	}

	@PostMapping("/user/add-user")
	public String addUser(@RequestBody UserDto userDto){
		String response=userService.addUser(userDto);
		return response;
	}
	
	@GetMapping("/user/get-users")
	public List<User> getAllUsers(){
		List<User> users=userService.getAllUsers();
		return users;
	}
	
	@GetMapping("/user/get-paginated-users/{pageNo}/{pageSize}")
	public List<User> findAllPaginated(@PathVariable int pageNo , @PathVariable int pageSize ) {
		List<User> paginatedUsers =  userService.findAllPaginated(pageNo, pageSize);
		return paginatedUsers;
	}
	
	@GetMapping("/user/{usrID}")
	public User getUserById( @PathVariable("usrID") int usrID) throws UserPrincipalNotFoundException {
		User user = userService.getUserById(usrID);
		return user;
	}
	
	@DeleteMapping("/user/{usrID}")
	public String deleteUser(@PathVariable("usrID") int usrID){
		String response=userService.deleteUser(usrID);
		return response;
	}
}
