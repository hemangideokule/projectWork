package net.bp.onlineshoppingBackend.dao;

import java.util.List;

import net.bp.onlineshoppingBackend.dto.Address;
import net.bp.onlineshoppingBackend.dto.User;

public interface AddressDAO {
	Address get(int id);

	List<Address> list();

	boolean add(Address address);

	boolean update(Address address);

	boolean delete(Address address);

	public Address getAddressByUser(User user);

}
