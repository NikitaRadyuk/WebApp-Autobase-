package by.radyuk.myautobase.model.dao.interfaces;

import by.radyuk.myautobase.exception.DaoException;
import by.radyuk.myautobase.model.entity.Auto;
import by.radyuk.myautobase.model.entity.Driver;

import java.util.List;
import java.util.Optional;

public interface AutoDao {

    /**
     * Add driver. Throws DaoException if writing to data source throws exception.
     *
     * @param auto           the driver to add
     * @return the count of updated rows
     * @throws DaoException if writing to data source throws exception
     */
    int add(Auto auto) throws DaoException;

    /**
     * Update driver. Throws DaoException if writing to data source throws exception.
     *
     * @param auto the updated user
     * @return the count of updated rows
     * @throws DaoException if writing to data source throws exception
     */
    int update(Auto auto) throws DaoException;


}
