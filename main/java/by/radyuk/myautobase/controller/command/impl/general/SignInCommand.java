package by.radyuk.myautobase.controller.command.impl.general;

import by.radyuk.myautobase.controller.command.Command;
import by.radyuk.myautobase.controller.command.PagePath;
import by.radyuk.myautobase.exception.CommandException;
import by.radyuk.myautobase.exception.ServiceException;
import by.radyuk.myautobase.model.entity.User;
import by.radyuk.myautobase.model.service.UserService;
import by.radyuk.myautobase.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class SignInCommand implements Command {
        private static final String LOGIN = "login";
        private static final String PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        try{
            UserService service = UserServiceImpl.getInstance();

            User user = service.login(login,password);
            if(user != null){
                request.getSession().setAttribute("user_data",user);
                return PagePath.USER_PAGE;
            }
            else {
                return PagePath.MAIN_PAGE;
            }
            //return PageName.USER_PAGE;
        }
        catch(ServiceException e){
            throw new CommandException("DB error: " + e, e);
        }

    }
}
