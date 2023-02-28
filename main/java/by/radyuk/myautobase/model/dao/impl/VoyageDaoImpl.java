package by.radyuk.myautobase.model.dao.impl;

import by.radyuk.myautobase.exception.ConnectionPoolException;
import by.radyuk.myautobase.exception.DaoException;
import by.radyuk.myautobase.model.dao.interfaces.VoyageDao;
import by.radyuk.myautobase.model.entity.Application;
import by.radyuk.myautobase.model.entity.Voyage;
import by.radyuk.myautobase.model.pool.CustomConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoyageDaoImpl implements VoyageDao {
    private static final Logger logger = LogManager.getLogger(VoyageDaoImpl.class);
    private final CustomConnectionPool pool = CustomConnectionPool.getInstance();

    private static final String SQL_INSERT_VOYAGE =
            "INSERT INTO voyage (typeOfCargo, route, time) " +
                    "VALUES (?,?,?)";

    private static final String SQL_SELECT_ALL_FREE_VOYAGES =
            "SELECT idVoyage,typeOfCargo, route, time " +
                    "FROM voyage " +
                    "WHERE idVoyage NOT IN (SELECT idApplication FROM applications)";

    private static final String SQL_UPDATE_VOYAGE =
            "UPDATE voyage  SET typeOfCargo=?, route=?, time=? " +
                    "WHERE idVoyage=?";

    private static final String SQL_DELETE_VOYAGE =
            "DELETE FROM voyage " +
                    "WHERE idVoyage=?";

    private static final String SQL_SELECT_ALL_NOT_FREE_VOYAGES =
            "SELECT idVoyage,typeOfCargo, route, time " +
                    "FROM voyage " +
                    "WHERE idVoyage NOT IN (SELECT idApplication FROM applications)";

    private static final String SQL_CHOOSE_VOYAGE =
            "INSERT INTO applications (idApplication, idDriver) " +
                                      "VALUES (?,?)";
    private static final class MySqlUserDaoInstanceHolder {
        private static final VoyageDaoImpl INSTANCE = new VoyageDaoImpl();
    }

    public static VoyageDaoImpl getInstance() {
        return VoyageDaoImpl.MySqlUserDaoInstanceHolder.INSTANCE;
    }

    @Override
    public int add(Voyage voyage) throws DaoException {
        try(
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT_VOYAGE, Statement.RETURN_GENERATED_KEYS)
        ){
            statement.setString(1, voyage.getTypeOfCargo().toString());
            statement.setString(2, voyage.getRoute().toString());
            statement.setString(3, voyage.getTime().toString());
            int rowsUpdate = statement.executeUpdate();
            try(ResultSet resultSet = statement.getGeneratedKeys()){
                if (resultSet.next()){
                    Long key = resultSet.getLong(1);
                    voyage.setIdVoyage(key);
                }
            }
            return rowsUpdate;
        }
        catch (SQLException| ConnectionPoolException e){
            logger.error("Error while adding voyage ", voyage, e);
            throw new DaoException("Error while adding voyage" + voyage + e);
        }
    }

    @Override
    public int update(Voyage voyage) throws DaoException {
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_VOYAGE)
        ) {
            statement.setString(1,  voyage.getTypeOfCargo().toString());
            statement.setString(2, voyage.getRoute().toString());
            statement.setString(3, voyage.getTime().toString());
            return statement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.error("Error while updating a voyage={}", voyage, e);
            throw new DaoException("Error while updating a voyage=" + voyage, e);
        }
    }

    @Override
    public List<Voyage> findAll() throws DaoException, SQLException {
        List<Voyage> voyages = new ArrayList<>();
        try(
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_FREE_VOYAGES);
                ResultSet resultSet = statement.executeQuery();
                ){
            while (resultSet.next()){
                voyages.add(createVoyage(resultSet));
            }
        }
        catch(SQLException | ConnectionPoolException e){
            logger.error("Error while selecting all free Voyages ", e);
            throw new DaoException("Error while selecting voyages");
        }
        return voyages;
    }

    public int selectVoyage(Long idVoyage, Long idUser) throws DaoException,SQLException{
        try(Connection connection = pool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_CHOOSE_VOYAGE);
            ){
            statement.setLong(1,idVoyage);
            statement.setLong(2,idUser);
            return statement.executeUpdate();
        }
        catch(SQLException | ConnectionPoolException e){
            logger.error("Error while selecting Voyages ", e);
            throw new DaoException("Error while selecting voyages" + e + idVoyage);
        }
    }

    private Voyage createVoyage(ResultSet resultSet) throws SQLException{
        Voyage voyage = new Voyage();
        voyage.setIdVoyage(resultSet.getLong(1));
        voyage.setTypeOfCargo(resultSet.getString(2));
        voyage.setRoute(resultSet.getString(3));
        voyage.setTime(resultSet.getString(4));
        return voyage;
    }
}
