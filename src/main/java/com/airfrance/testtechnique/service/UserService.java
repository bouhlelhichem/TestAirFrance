package com.airfrance.testtechnique.service;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.airfrance.testtechnique.dto.UserDTO;
import com.airfrance.testtechnique.entity.User;
import com.airfrance.testtechnique.factory.UserFactory;
import com.airfrance.testtechnique.repository.UserRepository;

/**
 *
 * @author hichem.bouhlel
 */

@Service
public class UserService {

	private final UserRepository userRepository;
	private final Logger log = LoggerFactory.getLogger(UserService.class);

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	/**
	 * Find all user persisted in database.
	 * 
	 * @return List<?>
	 */
	public List<UserDTO> getAll() {
		Long startTime = Instant.now().toEpochMilli();
		List<UserDTO> listUser = UserFactory.userLiToUsersDTO(userRepository.findAll());
		Long endTime = Instant.now().toEpochMilli();
		Long elapsedTime = endTime - startTime;
		log.info("Request to get All Users, Elapsed time in milli seconds " + elapsedTime);
		return listUser;
	}

	/**
	 * create a new user based on the configuration set on the factory.
	 * 
	 * @param userDto
	 * @return UserDTO
	 */
	public UserDTO save(UserDTO userDto) {
		Long startTime = Instant.now().toEpochMilli();
		User users = UserFactory.userDtoToUser(userDto);
		users = userRepository.save(users);
		UserDTO resultDto = UserFactory.userToUserDTO(users);
		Long endTime = Instant.now().toEpochMilli();
		Long elapsedTime = endTime - startTime;
		log.info("Request to save UserDto : {0}; Elapsed time in milli seconds: {1}", userDto, elapsedTime);
		return resultDto;

	}

	/**
	 * gets detailed information about a specified user by id.
	 * 
	 * @param userId
	 * @return UserDTO
	 */
	public UserDTO getUser(String userId) {
		Long startTime = Instant.now().toEpochMilli();
		User users = userRepository.findById(userId).get();
		UserDTO resultDto = UserFactory.userToUserDTO(users);
		Long endTime = Instant.now().toEpochMilli();
		Long elapsedTime = endTime - startTime;
		log.info("Request to get User : {0}; Elapsed time in milli seconds: {1}", userId, elapsedTime);
		return resultDto;

	}

}
