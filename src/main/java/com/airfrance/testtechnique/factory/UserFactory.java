package com.airfrance.testtechnique.factory;

import com.airfrance.testtechnique.dto.UserDTO;
import com.airfrance.testtechnique.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory for User instances.
 * 
 * @author hichem.bouhlel
 */
public class UserFactory {

	public static UserDTO userToUserDTO(User users) {
		return new UserDTO(users.getFirstName(), users.getLastName(), users.getPhoneNumber(), users.getBirthDay(),
				users.getAddress(), users.getDateRegistration());
	}

	public static List<UserDTO> userLiToUsersDTO(List<User> listUsers) {
		List<UserDTO> listUsersDTO = new ArrayList<>();
		for (User users : listUsers) {
			listUsersDTO.add(userToUserDTO(users));
		}
		return listUsersDTO;
	}

	public static User userDtoToUser(UserDTO userDto) {
		User users = new User();
		users.setFirstName(userDto.getFirstName());
		users.setLastName(userDto.getLastName());
		users.setBirthDay(userDto.getBirthDay());
		users.setPhoneNumber(userDto.getPhoneNumber());
		users.setAddress(userDto.getAddress());
		users.setDateRegistration(userDto.getDateRegistration());
		return users;
	}
}
