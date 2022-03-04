package com.dkit.gd2.johnloane;

import com.dkit.gd2.johnloane.DAO.MySqlUserDao;
import com.dkit.gd2.johnloane.DAO.UserDaoInterface;
import com.dkit.gd2.johnloane.DTO.User;
import com.dkit.gd2.johnloane.Exceptions.DaoException;

import java.util.List;

/**
 * Databases using DAO, DTO pattern
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserDaoInterface IUserDAO = new MySqlUserDao();

        try
        {
            List<User> users = IUserDAO.findAllUsers();

            if(users.isEmpty())
            {
                System.out.println("There are no users");
            }

            printAllUsers(users);
        }
        catch(DaoException de)
        {
            System.out.println(de.getMessage());
        }

    }

    private static void printAllUsers(List<User> users)
    {
        for(User user : users)
        {
            System.out.println(user);
        }
    }
}
