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

            User user = IUserDAO.findUserByUsernamePassword("leanne", "password");
            checkUserFound(user);

            user = IUserDAO.findUserByUsernamePassword("sean", "password");
            checkUserFound(user);



        }
        catch(DaoException de)
        {
            System.out.println(de.getMessage());
        }

    }

    private static void checkUserFound(User user)
    {
        if(user != null)
        {
            System.out.println("User found: " + user);
        }
        else
        {
            System.out.println("No user with that username and password found");
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
