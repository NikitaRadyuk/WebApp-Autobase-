package by.radyuk.myautobase.model.service.impl;

import by.radyuk.myautobase.exception.DaoException;
import by.radyuk.myautobase.exception.ServiceException;
import by.radyuk.myautobase.model.dao.impl.UserDaoImpl;
import by.radyuk.myautobase.model.dao.interfaces.UserDao;
import by.radyuk.myautobase.model.entity.User;
import by.radyuk.myautobase.model.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private static final UserServiceImpl INSTANCE = new UserServiceImpl();
    private static UserDao userDao = UserDaoImpl.getInstance();

    private UserServiceImpl(){};

    public static UserService getInstance(){return INSTANCE;}

    public User login(String login, String password) throws ServiceException{
        if(!isValid(login, password)){
            throw new ServiceException("NotValid");
        }
        UserDao dao = UserDaoImpl.getInstance();
        try{
            String pass = dao.findUserPasswordByLogin(login);
            if(pass != null){
                if(pass.equals(password)){
                    User user = dao.findUserByLogin(login);
                    if(user != null){
                        return user;
                    }
                }
            }
        } catch (DaoException e) {
            throw new ServiceException("dao exception while login");
        }
        return null;
    }


    public boolean isValid(String login, String password) {
        if(login == null || login.isEmpty())
            return false;
        if(password == null || password.isEmpty())
            return false;
        return true;
    }

    private boolean validReg(User user){
        return user.getLogin() != null && user.getPassword() != null && user.getName() != null
                && user.getSurname() != null && user.getEmail() != null;
    }

    @Override
    public boolean Register(User user) throws ServiceException{
        try{
            if (validReg(user)){
                if (userDao.add(user) < 0){
                    return false;
                }
                return true;
            }
            else{
                throw new ServiceException("invalid");
            }
        }
        catch(DaoException e){
            throw new ServiceException("dao exception while register" + e);
        }
    }

}
