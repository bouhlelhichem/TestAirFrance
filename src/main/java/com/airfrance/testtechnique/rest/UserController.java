package com.airfrance.testtechnique.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airfrance.testtechnique.dto.UserDTO;
import com.airfrance.testtechnique.exception.UserNotFoundException;
import com.airfrance.testtechnique.service.UserService;

/**
 * This controller class that manages a user's profile.
 * 
 * @author hichem.bouhlel
 */
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * This action will get the all entity.
	 * 
	 * @return List<UserDTO>
	 */

	@GetMapping("/user")
	public List<UserDTO> retrieveAllUsers() {
		return userService.getAll();
	}

	/**
	 * This action will Create a new user.
	 * 
	 * @param userDto
	 * @param bindingResult
	 * @return ResponseEntity<UserDTO>
	 * @throws MethodArgumentNotValidException
	 * @throws URISyntaxException
	 */
	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto, BindingResult bindingResult)
			throws MethodArgumentNotValidException, URISyntaxException {
		if (bindingResult.hasErrors()) {
			throw new MethodArgumentNotValidException(null, bindingResult);
		}
		/**
		 * We can use annotation @France or simple condition but the best practice still
		 * to test this in Front-end if
		 * (userDto.getAddress().toLowerCase().contains("france"))
		 */

		UserDTO result = userService.save(userDto);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	/**
	 * This action will get the entity with the given ID.
	 * 
	 * @param userId
	 * @return UserDTO
	 */
	@GetMapping(path = "/users/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Resource<UserDTO> retrieveUser(@PathVariable String userId) {
		UserDTO user = userService.getUser(userId);
		if (user != null)
			throw new UserNotFoundException("User Not Found Exception id - " + userId);
		Resource<UserDTO> resource = new Resource<>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

}
