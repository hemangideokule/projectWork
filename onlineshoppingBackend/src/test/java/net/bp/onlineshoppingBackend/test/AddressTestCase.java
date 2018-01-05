 package net.bp.onlineshoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.bp.onlineshoppingBackend.dao.AddressDAO;
import net.bp.onlineshoppingBackend.dao.UserDAO;
import net.bp.onlineshoppingBackend.dto.Address;

public class AddressTestCase {

	private static AnnotationConfigApplicationContext context;

	private static AddressDAO addressDAO;
	
	private static UserDAO userDAO;

	private Address address;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.bp");
		context.refresh();
		addressDAO = (AddressDAO) context.getBean("addressDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	/*@Test
	public void testAddCategory() {
		address = new Address();

		address.setShippingAddress("sector20,gurgaon");
		address.setBillingAddress("sector14,rosewood apartment hotel,gurgaon");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setPincode("425201");
		
		address.setUser(userDAO.get(1));
		

		assertEquals("Successfully added a category inside a table", true, addressDAO.add(address));

	}*/
}

