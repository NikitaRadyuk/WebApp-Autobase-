package by.radyuk.myautobase.model.service;

import by.radyuk.myautobase.exception.ServiceException;
import by.radyuk.myautobase.model.entity.Voyage;

import java.util.List;

public interface VoyageService {
    public List<Voyage> getVoyages() throws ServiceException;
    public void selectVoyage(Long idVoyage, Long idUser) throws ServiceException;
    public void addVoyage(Voyage voyage) throws ServiceException;
}
