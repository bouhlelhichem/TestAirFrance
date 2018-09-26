package com.airfrance.testtechnique;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.airfrance.testtechnique.entity.User;
import com.airfrance.testtechnique.repository.UserRepository;

/**
 *
 * @author hichem.bouhlel
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTechniqueApplicationTests {

	@Autowired
	UserRepository userRepository;

	/**
	 * Create a valid user.
	 * <p>
	 * User will be persisted without any errors
	 * </p>
	 */
	@Test
	public void testInsertUser() {
		User user = new User();
		user.setFirstName("Hichem");
		user.setLastName("BOUHLEL");
		user.setBirthDay(new Date("27/06/1992"));
		user.setAddress("7 Rue dunoyer de zogonzac 06200 Nice France");
		userRepository.save(user);
		assertNotEquals(userRepository.count(), 0);
	}

	/**
	 * Get user.
	 * <p>
	 * User will be returned by Id without any errors
	 * </p>
	 */
	@Test
	public void testGetUser() {
		User user = null;
		user = userRepository.findById("5ba8ee6a546a2c1b540ec23e").get();
		assertNotNull(user);
	}

	/**
	 * Get list of all users.
	 * <p>
	 * List of users will be returned without any errors
	 * </p>
	 */
	@Test
	public void testGetAllUser() {
		List<User> users = null;
		users = userRepository.findAll();
		assertNotNull(users);
	}

}
