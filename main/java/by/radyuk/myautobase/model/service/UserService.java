package by.radyuk.myautobase.model.service;

import by.radyuk.myautobase.exception.ServiceException;
import by.radyuk.myautobase.model.entity.User;

public interface UserService {
    User login(String login, String password)throws ServiceException;
    public boolean Register(User user) throws ServiceException;
}
