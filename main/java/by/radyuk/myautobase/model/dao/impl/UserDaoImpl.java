package by.radyuk.myautobase.model.dao.impl;

import by.radyuk.myautobase.exception.ConnectionPoolException;
import by.radyuk.myautobase.exception.DaoException;
import by.radyuk.myautobase.model.dao.interfaces.UserDao;
import by.radyuk.myautobase.model.entity.Role;
import by.radyuk.myautobase.model.entity.User;
import by.radyuk.myautobase.model.pool.CustomConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The implementation of UserDao interface.
 */
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
    private final CustomConnectionPool pool = CustomConnectionPool.getInstance();

    private static final String SQL_INSERT_USER =
            "INSERT INTO user (login, password, user_role_id, email, name, surname) " +
                    "VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE_USER =
            "UPDATE user SET login=?, email=?, name=?, surname=?" +
                    "WHERE idUser=?";

    private static final String SQL_SELECT_USER_BY_ID =
                    "SELECT idUser, login, email, user.name, surname, user_role.name AS 'role' " +
                    "FROM (user " +
                    "JOIN user_role ON user_role.user_role_id=user.user_role_id) " +
                    "WHERE idUser=?";
    private static final String SQL_SELECT_USER_BY_LOGIN =
            "SELECT idUser, login, email, user.name, surname, user_role.name AS 'role' " +
                    "FROM (user " +
                    "JOIN user_role ON user_role.user_role_id=user.user_role_id) " +
                    "WHERE login=?";
    private static final String SQL_SELECT_USER_PASSWORD_BY_LOGIN =
            "SELECT password " +
                    "FROM user " +
                    "WHERE login=?";

    private static final String SQL_SELECT_USERS_BY_ROLE =
            "SELECT idUser, login, email, user.name, surname, user_role.name AS 'role' " +
                    "FROM (user " +
                    "JOIN user_role ON user_role.user_role_id=user.user_role_id) " +
                    "WHERE user.user_role_id=?";
    private static final String SQL_SELECT_ALL_USERS =
            "SELECT idUser, login, email, name, surname, user_role.name AS role_name" +
                    "FROM user " +
                    "JOIN user_role ON user_role.user_role_id=user.user_role_id ";

    private static final class MySqlUserDaoInstanceHolder {
        private static final UserDaoImpl INSTANCE = new UserDaoImpl();
    }

    /**
     * Gets instance.
     *
     * @return the instance of user dao
     */
    public static UserDaoImpl getInstance() {
        return MySqlUserDaoInstanceHolder.INSTANCE;
    }

    @Override
    public int add(User user) throws DaoException {
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setLong(3, user.getRole().getId());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getName());
            statement.setString(6, user.getSurname());

            int rowsUpdate = statement.executeUpdate();
            try(ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    Long key = resultSet.getLong(1);
                    user.setUserId(key);
                }
            }
            return rowsUpdate;
        } catch (SQLException | ConnectionPoolException e) {
            logger.error("Error while adding a user={}", user, e);
            throw new DaoException("Error while adding a user=" + user + e, e);
        }
    }

    @Override
    public int update(User user) throws DaoException {
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER)
        ) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setLong(5, user.getRole().getId());
            statement.setLong(7, user.getUserId());
            return statement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.error("Error while updating a user={}", user, e);
            throw new DaoException("Error while updating a user=" + user, e);
        }
    }

    @Override
    public User findUserByLogin(String login) throws DaoException {
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN)
        ) {
            statement.setString(1, login);
            try{
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return createUser(resultSet);
                }
            }catch (SQLException e){
                throw new DaoException("Error create user", e);
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.error("Error while selecting a user", e);
            throw new DaoException("Error while selecting a user", e);
        }
        return null;
    }

    @Override
    public String findUserPasswordByLogin(String login) throws DaoException {
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_PASSWORD_BY_LOGIN)
        ) {
            statement.setString(1, login);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String password = resultSet.getString(1);
                    return password;
                }
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.error("Error while selecting a password", e);
            throw new DaoException("Error while selecting a password", e);
        }
        return null;
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> users = new ArrayList<>();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_USERS);
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                users.add(createUser(resultSet));
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.error("Error while selecting a users", e);
            throw new DaoException("Error while selecting a users", e);
        }
        return users;
    }

    private User createUser(ResultSet resultSet) throws SQLException {
        return User.builder()
                .setUserId(resultSet.getLong(1))
                .setLogin(resultSet.getString(2))
                .setEmail(resultSet.getString(3))
                .setName(resultSet.getString(4))
                .setSurname(resultSet.getString(5))
                .setRole(Role.valueOf(resultSet.getString(6).toUpperCase()))
                .build();
    }
}