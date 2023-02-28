package by.radyuk.myautobase.model.dao.interfaces;

import by.radyuk.myautobase.exception.DaoException;
import by.radyuk.myautobase.model.entity.Application;
import by.radyuk.myautobase.model.entity.Voyage;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface VoyageDao {
    /**
     * Add voyage. Throws DaoException if writing to data source throws exception.
     *
     * @param voyage the voyage to add
     * @return the count of updated rows
     * @throws DaoException if writing to data source throws exception
     */
    int add(Voyage voyage) throws DaoException;

    /**
     * Update voyage. Throws DaoException if updating of data source throws exception.
     *
     * @param voyage the updated voyage
     * @return the count of updated rows
     * @throws DaoException if updating of data source throws exception
     */
    int update(Voyage voyage) throws DaoException;

    List<Voyage> findAll() throws DaoException, SQLException;
    public int selectVoyage(Long idVoyage, Long idUser) throws DaoException,SQLException;
}
