package net.bp.onlineshoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.bp.onlineshoppingBackend.dao.UserDAO;
import net.bp.onlineshoppingBackend.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;

	private static UserDAO userDAO;

	private User user;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.bp");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	// @Test
	public void testAddUser() {
		user = new User();

		user.setFirstName("Aniket");
		user.setLastName("Kfsdfhasdfn");
		user.setEmail("aniket@niit.com");
		user.setUserName("sdf sdf");
		user.setPassword("123");
		user.setRole("User");

		assertEquals("Successfully added a user inside a table", true, userDAO.add(user));
	}

	/*
	 * @Test public void testGetUser(){ user=userDAO.get(1);
	 * 
	 * assertEquals("Successfully fetched user inside a table", "Admin",
	 * user.getRole()); }
	 */

	@Test
	public void testUpdateUser() {
		user = userDAO.get(1);

		user.setEmail("sdf@gmail.com");
		assertEquals("Successfully updated data inside a table", true, userDAO.update(user));
	}

	/*
	 * @Test public void testDeleteUser() { user = userDAO.get(1);
	 * 
	 * assertEquals("Successfully deleted from a table", true,
	 * userDAO.delete(user)); }
	 */
}
