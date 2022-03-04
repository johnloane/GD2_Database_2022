package com.dkit.gd2.johnloane.Exceptions;

import java.sql.SQLException;

public class DaoException extends SQLException
{
    public DaoException()
    {
    }

    public DaoException(String reason)
    {
        super(reason);
    }
}
