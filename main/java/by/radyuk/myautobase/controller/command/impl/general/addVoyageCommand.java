package by.radyuk.myautobase.controller.command.impl.general;

import by.radyuk.myautobase.controller.command.Command;
import by.radyuk.myautobase.controller.command.PagePath;
import by.radyuk.myautobase.exception.CommandException;
import by.radyuk.myautobase.exception.ServiceException;
import by.radyuk.myautobase.model.entity.Voyage;
import by.radyuk.myautobase.model.service.VoyageService;
import by.radyuk.myautobase.model.service.impl.VoyageServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class addVoyageCommand implements Command {
    private static final String TYPE = "typeOfCargo";
    private static final String ROUTE = "route";
    private static final String TIME = "time";
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String type = request.getParameter(TYPE);
        String route = request.getParameter(ROUTE);
        String time = request.getParameter(TIME);
        Voyage voyage = new Voyage();
        voyage.setTypeOfCargo(type);
        voyage.setRoute(route);
        voyage.setTime(time);
        try{
            VoyageService service = VoyageServiceImpl.getInstance();
            service.addVoyage(voyage);
        }catch (ServiceException e){
            throw new CommandException("get voyage exception" + e);
        }
        return PagePath.USER_PAGE;
    }
}
