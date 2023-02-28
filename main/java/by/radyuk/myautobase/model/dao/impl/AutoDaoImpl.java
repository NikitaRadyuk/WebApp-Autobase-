package by.radyuk.myautobase.model.dao.impl;

import by.radyuk.myautobase.exception.DaoException;
import by.radyuk.myautobase.model.dao.interfaces.AutoDao;
import by.radyuk.myautobase.model.entity.Auto;
import by.radyuk.myautobase.model.entity.Driver;

import java.util.List;

public class AutoDaoImpl implements AutoDao {

    public static final String SQL_INSERT_AUTO = "INSERT INTO auto (model, load_capacity, status)" +
            "VALUES (?,?,?)";

    public static final String SQL_UPDATE_AUTO = "UPDATE auto SET model=?, load_capacity=?, status=? WHERE idAuto=?";

    @Override
    public int add(Auto auto) throws DaoException {
        return 0;
    }

    @Override
    public int update(Auto auto) throws DaoException {
        return 0;
    }

}
