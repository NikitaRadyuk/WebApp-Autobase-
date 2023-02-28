package by.radyuk.myautobase.model.dao.impl;

import by.radyuk.myautobase.exception.ConnectionPoolException;
import by.radyuk.myautobase.exception.DaoException;
import by.radyuk.myautobase.model.dao.interfaces.DriverDao;
import by.radyuk.myautobase.model.entity.Auto;
import by.radyuk.myautobase.model.entity.Driver;
import by.radyuk.myautobase.model.pool.CustomConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DriverDaoImpl implements DriverDao {
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
    private final CustomConnectionPool pool = CustomConnectionPool.getInstance();

    private static final String SQL_INSERT_DRIVER =
            "INSERT INTO driver (standing, idAuto) " +
                    "VALUES (?,?)";

    private static final String SQL_UPDATE_DRIVER =
            "UPDATE driver SET standing=?, idAuto=?" +
                    "WHERE idDriver=?";

    private static final String SQL_SELECT_DRIVER_BY_CAR =
            "SELECT * FROM " +
                    "(SELECT Driver.idDriver, standing,  Auto.idAuto, Auto.model, Auto.load_capacity, Auto.status FROM Driver " +
                    "INNER JOIN Auto ON Auto.idAuto=Driver.idAuto) AS T " +
                    "WHERE T.idAuto = ?";

    @Override
    public int add(Driver driver, String hashedPassword) throws DaoException {
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT_DRIVER, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setInt(1, driver.getStanding());
            statement.setString(2, hashedPassword);
            statement.setString(3, driver.getAuto().toString());
            statement.setString(4, driver.getUser().toString());
            int rowsUpdate = statement.executeUpdate();
            try(ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    Long key = resultSet.getLong(1);
                    driver.setIdDriver(key);
                }
            }
            return rowsUpdate;
        } catch (SQLException | ConnectionPoolException e) {
            logger.error("Error while adding a driver={}", driver, e);
            throw new DaoException("Error while adding a driver=" + driver, e);
        }
    }

    @Override
    public int update(Driver driver) throws DaoException {
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_DRIVER)
        ) {
            statement.setInt(1, driver.getStanding());
            statement.setString(2, driver.getAuto().toString());
            statement.setString(3, driver.getUser().toString());
            return statement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.error("Error while updating a driver={}", driver, e);
            throw new DaoException("Error while updating a driver=" + driver, e);
        }    }


    private Driver createDriver(ResultSet resultSet) throws SQLException {
        return Driver.builder()
                .setDriverId(resultSet.getLong(1))
                .setAuto(Auto.builder().build())
                .setStanding(resultSet.getInt(2))
                .build();
    }
}
