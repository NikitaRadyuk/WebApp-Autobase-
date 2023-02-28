package by.radyuk.myautobase.controller.command.impl.moveto.general;

import by.radyuk.myautobase.controller.command.Command;
import by.radyuk.myautobase.controller.command.PagePath;
import by.radyuk.myautobase.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

public class MoveToMainPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return PagePath.MAIN_PAGE;
    }
}
