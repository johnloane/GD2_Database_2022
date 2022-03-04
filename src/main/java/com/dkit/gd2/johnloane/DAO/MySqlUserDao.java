package com.dkit.gd2.johnloane.DAO;

/* DAO for the user table with mysql specific code
    This is a concrete class that implements the interface
 */

import com.dkit.gd2.johnloane.DTO.User;
import com.dkit.gd2.johnloane.Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao extends MySqlDao implements UserDaoInterface
{

    @Override
    public List<User> findAllUsers() throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();

        try
        {
            //Get a connection to the database
            con = this.getConnection();
            String query = "SELECT * FROM USER";
            ps = con.prepareStatement(query);

            //Use the prepared statement to execute the sql
            rs = ps.executeQuery();
            while(rs.next())
            {
                int userId = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String userName = rs.getString("username");
                String password = rs.getString("password");
                User u = new User(userId, firstName, lastName, userName, password);
                users.add(u);
            }
        }
        catch(SQLException sqe)
        {
            throw new DaoException("findAllUsers() " + sqe.getMessage());
        }
        finally
        {
            try
            {
                if(rs != null)
                {
                    rs.close();
                }
                if(ps != null)
                {
                    ps.close();
                }
                if(con != null)
                {
                    freeConnection(con);
                }
            }
            catch(SQLException sqe)
            {
                throw new DaoException("findAllUsers() " + sqe.getMessage());
            }
        }
        return users;
    }

    @Override
    public User findUserByUsernamePassword(String uname, String pword) throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try
        {
            //Get a connection to the database
            con = this.getConnection();
            String query = "select * from user where username = ? and password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pword);

            //Use the prepared statement to execute the sql
            rs = ps.executeQuery();
            while(rs.next())
            {
                int userId = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                u = new User(userId, firstName, lastName, userName, password);
            }
        }
        catch(SQLException sqe)
        {
            throw new DaoException("findAllUsers() " + sqe.getMessage());
        }
        finally
        {
            try
            {
                if(rs != null)
                {
                    rs.close();
                }
                if(ps != null)
                {
                    ps.close();
                }
                if(con != null)
                {
                    freeConnection(con);
                }
            }
            catch(SQLException sqe)
            {
                throw new DaoException("findAllUsers() " + sqe.getMessage());
            }
        }
        return u;
    }
}
