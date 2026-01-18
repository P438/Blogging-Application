package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.UserDto;
import com.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Post-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createdUserDto = this.userService.createUser(userDto);

		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
	}


//Put-update User
@PutMapping("/{userId}")
public ResponseEntity<UserDto>updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
	UserDto updatedUser=this.userService.updateUser(userDto, uid);
	return ResponseEntity.ok(updatedUser);
}

@PreAuthorize("hasRole('ADMIN')")
// Delete- delete User
@DeleteMapping("/{userId}")
public ResponseEntity<ApiResponse>deleteUser(@PathVariable("userId")Integer uid){
	this.userService.deleteUser(uid);
	//return new ResponseEntity(Map.of("message","User Deleted Succesfully"),HttpStatus.OK);

	return new ResponseEntity(new ApiResponse("User Deleted Succsefully",true),HttpStatus.OK);

}

// Get-user get
@GetMapping("/")
public ResponseEntity<List<UserDto>>getAllUsers(){
	List<UserDto>usersList=this.userService.getAllUsers();
	return ResponseEntity.ok(usersList);
}
@GetMapping("/{userId}")
public ResponseEntity<UserDto>getSingleUser(@PathVariable Integer userId){
	UserDto singleUserDto=this.userService.getUserById(userId);
	return ResponseEntity.ok(singleUserDto);
}
}