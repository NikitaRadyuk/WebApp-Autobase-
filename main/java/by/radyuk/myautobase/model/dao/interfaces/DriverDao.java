package by.radyuk.myautobase.model.dao.interfaces;

import by.radyuk.myautobase.exception.DaoException;
import by.radyuk.myautobase.model.entity.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverDao {
    /**
     * Add driver. Throws DaoException if writing to data source throws exception.
     *
     * @param driver           the driver to add
     * @param hashedPassword the hashed password
     * @return the count of updated rows
     * @throws DaoException if writing to data source throws exception
     */
    int add(Driver driver, String hashedPassword) throws DaoException;

    /**
     * Update driver. Throws DaoException if writing to data source throws exception.
     *
     * @param driver the updated user
     * @return the count of updated rows
     * @throws DaoException if writing to data source throws exception
     */
    int update(Driver driver) throws DaoException;



}
