package by.radyuk.myautobase.controller.command.impl.general;

import by.radyuk.myautobase.controller.command.Command;
import by.radyuk.myautobase.controller.command.PagePath;
import by.radyuk.myautobase.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

public class SignOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException{
        deleteSession(request);
        createNewSession(request);
        return PagePath.MAIN_PAGE;
    }

    private void deleteSession(HttpServletRequest request){
        request.getSession().invalidate();
    }

    private void createNewSession(HttpServletRequest request){request.getSession();}
}
