package by.radyuk.myautobase.model.dao.interfaces;

import by.radyuk.myautobase.exception.DaoException;
import by.radyuk.myautobase.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    /**
     * Add user. Throws DaoException if writing to data source throws exception.
     *
     * @param user           the user to add
     * @return the count of updated rows
     * @throws DaoException if writing to data source throws exception
     */
    int add(User user) throws DaoException;

    /**
     * Update user. Throws DaoException if writing to data source throws exception.
     *
     * @param user the updated user
     * @return the count of updated rows
     * @throws DaoException if writing to data source throws exception
     */
    int update(User user) throws DaoException;

    /**
     * Find all users. Throws DaoException if reading of data source throws exception.
     *
     * @return the list of users
     * @throws DaoException if reading of data source throws exception
     */
    List<User> findAll() throws DaoException;

    public User findUserByLogin(String login) throws DaoException;
    public String findUserPasswordByLogin(String login) throws DaoException;
}
