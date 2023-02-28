package by.radyuk.myautobase.controller.command.impl.general;

import by.radyuk.myautobase.controller.command.Command;
import by.radyuk.myautobase.controller.command.PagePath;
import by.radyuk.myautobase.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

public class ShowAddVoyageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return PagePath.ADD_VOYAGES_PAGE;
    }
}
