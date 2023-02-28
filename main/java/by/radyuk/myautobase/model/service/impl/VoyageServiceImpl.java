package by.radyuk.myautobase.model.service.impl;

import by.radyuk.myautobase.exception.DaoException;
import by.radyuk.myautobase.exception.ServiceException;
import by.radyuk.myautobase.model.dao.impl.VoyageDaoImpl;
import by.radyuk.myautobase.model.dao.interfaces.VoyageDao;
import by.radyuk.myautobase.model.entity.Voyage;
import by.radyuk.myautobase.model.service.VoyageService;

import java.sql.SQLException;
import java.util.List;

public class VoyageServiceImpl implements VoyageService {
    private static final VoyageServiceImpl INSTANCE = new VoyageServiceImpl();
    private static final VoyageDao dao = VoyageDaoImpl.getInstance();

    private VoyageServiceImpl() {
    }

    public static VoyageService getInstance() {
        return INSTANCE;
    }

    public List<Voyage> getVoyages() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    public void selectVoyage(Long idVoyage, Long idUser) throws ServiceException {
        try {
            int resultVoyage = dao.selectVoyage(idVoyage, idUser);
            if (resultVoyage < 0){
                throw new ServiceException("error");
            }
        } catch (DaoException | SQLException e) {
            throw new ServiceException("select voyage" + e);
        }
    }

    public void addVoyage(Voyage voyage) throws ServiceException{
        try {
            int resultVoyage = dao.add(voyage);
            if (resultVoyage < 0){
                throw new ServiceException("error");
            }
        } catch (DaoException e) {
            throw new ServiceException("select voyage" + e);
        }
    }
}
