package by.radyuk.myautobase.controller.command.impl.general;

import by.radyuk.myautobase.controller.command.Command;
import by.radyuk.myautobase.controller.command.PagePath;
import by.radyuk.myautobase.exception.CommandException;
import by.radyuk.myautobase.exception.ServiceException;
import by.radyuk.myautobase.model.entity.Voyage;
import by.radyuk.myautobase.model.service.VoyageService;
import by.radyuk.myautobase.model.service.impl.VoyageServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.List;

public class ShowFreeVoyagesCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try{
                VoyageService service = VoyageServiceImpl.getInstance();
            List<Voyage> freeVoyages = service.getVoyages();
            if (freeVoyages.size() > 0){
                request.getSession().setAttribute("free_voyages",freeVoyages);

            }
            //throw new CommandException("all good"+ freeVoyages.size());
                }catch(ServiceException e){
                throw new CommandException("Show chotatam" + e, e);
        }
        return PagePath.SHOW_FREE_VOYAGE_PAGE;
    }
}
