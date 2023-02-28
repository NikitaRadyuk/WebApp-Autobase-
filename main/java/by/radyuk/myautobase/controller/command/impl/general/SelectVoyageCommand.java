package by.radyuk.myautobase.controller.command.impl.general;

import by.radyuk.myautobase.controller.command.Command;
import by.radyuk.myautobase.controller.command.PagePath;
import by.radyuk.myautobase.exception.CommandException;
import by.radyuk.myautobase.exception.ServiceException;
import by.radyuk.myautobase.model.entity.User;
import by.radyuk.myautobase.model.service.VoyageService;
import by.radyuk.myautobase.model.service.impl.VoyageServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class SelectVoyageCommand implements Command {
    private static final String ID = "id";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        Long id = Long.parseLong(request.getParameter(ID));
        try{
            VoyageService service = VoyageServiceImpl.getInstance();
            User user = (User)request.getSession().getAttribute("user_data");
            service.selectVoyage(id, user.getUserId());
        }
        catch (ServiceException e){
            throw new CommandException("Select" + e);
        }
        return PagePath.USER_PAGE;
    }
}
