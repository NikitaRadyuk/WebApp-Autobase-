package by.radyuk.myautobase.controller.command.impl.general;

import by.radyuk.myautobase.controller.command.Command;
import by.radyuk.myautobase.controller.command.PagePath;
import by.radyuk.myautobase.exception.CommandException;
import by.radyuk.myautobase.exception.ServiceException;
import by.radyuk.myautobase.model.entity.Role;
import by.radyuk.myautobase.model.entity.User;
import by.radyuk.myautobase.model.service.UserService;
import by.radyuk.myautobase.model.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class SignUpCommand implements Command {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "email";
    private static final String CONFIRM_PASSWORD = "confirm_password";
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        if(!request.getParameter(PASSWORD).equals(request.getParameter(CONFIRM_PASSWORD))){
            throw new CommandException("Password are not equals" + request.getParameter(PASSWORD) + "congf = "
                    + request.getParameter(CONFIRM_PASSWORD));
        }
        try{
            UserService service = UserServiceImpl.getInstance();
            User user = createUser(request);
            if(service.Register(user)){
                request.getSession().setAttribute("user_data",user);
                return PagePath.USER_PAGE;
            }
            else {
                return PagePath.SIGNUP_PAGE;
            }
        }
        catch(ServiceException e){
            throw new CommandException("DB error: " + e,e);
        }
    }
    private User createUser(HttpServletRequest request){
        return User.builder()
                .setLogin(request.getParameter(LOGIN))
                .setPassword(request.getParameter(PASSWORD))
                .setName(request.getParameter(NAME))
                .setSurname(request.getParameter(SURNAME))
                .setEmail(request.getParameter(EMAIL))
                .setRole(Role.USER)
                .build();
    }
}
