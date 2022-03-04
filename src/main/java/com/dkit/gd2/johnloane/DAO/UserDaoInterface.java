package com.dkit.gd2.johnloane.DAO;

/* Declare the methods that all UserDAO types must implement
It could a Mysql database or a Mongo database or any other
 */

import com.dkit.gd2.johnloane.DTO.User;
import com.dkit.gd2.johnloane.Exceptions.DaoException;

import java.util.List;

public interface UserDaoInterface
{
    public List<User> findAllUsers() throws DaoException;
    public User findUserByUsernamePassword(String uname, String pword) throws DaoException;
}
