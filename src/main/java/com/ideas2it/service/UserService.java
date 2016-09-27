package com.ideas2it.service;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.User;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Web Service interface so hierarchy of Generic Manager isn't carried through.
 */
@WebService
@Path("/users")
public interface UserService {
	/**
	 * Retrieves a user by userId. An exception is thrown if user not found
	 *
	 * @param userId
	 *            the identifier for the user
	 * @return User
	 */
	@GET
	@Path("{id}")
	User getUser(@PathParam("id") String userId);

	/**
	 * Finds a user by their username.
	 *
	 * @param username
	 *            the user's username used to login
	 * @return User a populated user object
	 */
	User getUserByUsername(@PathParam("username") String username);

	/**
	 * Retrieves a list of all users.
	 *
	 * @return List
	 */
	@GET
	List<User> getUsers();

	/**
	 * Saves a user's information
	 *
	 * @param user
	 *            the user's information
	 * @return updated user
	 * @throws UserExistsException
	 *             thrown when user already exists
	 */
	@POST
	User saveUser(User user) throws UserExistsException;

	/**
	 * Removes a user from the database by their userId
	 *
	 * @param userId
	 *            the user's id
	 */
	@DELETE
	void removeUser(String userId);

	/**
	 * Add new User
	 *
	 * @return True or Fales
	 */
	boolean addUser(User user) throws DataException;

	/**
	 * Update User
	 *
	 * @return True or Fales
	 */
	boolean updateUser(User user) throws DataException;

	/**
	 * Delete User
	 *
	 * @return True or Fales
	 */
	boolean deleteUser(long userId) throws DataException;

	/**
	 * Search User
	 *
	 * @return User
	 */
	User searchUser(long userId) throws DataException;

	/**
	 * Search User by given Username
	 *
	 * @return User
	 */
	User searchUserByUserName(String userUserName) throws DataException;

	/**
	 * Get All Users
	 *
	 * @return List
	 */
	List<User> retrieveUsers() throws DataException;

	/**
	 * Get All Users for given designation
	 *
	 * @return List
	 */
	List<User> getUserByDesignation(int designationId) throws DataException;
}
