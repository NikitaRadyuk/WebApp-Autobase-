package by.radyuk.myautobase.controller.command;

import by.radyuk.myautobase.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

/**
 * The interface Command.
 */
public interface Command {
    /**
     * Execute specified command.
     *
     * @param request the request
     * @return the router with specified next page and type of routing
     */
    String execute(HttpServletRequest request) throws CommandException;

    default String getPageFrom(HttpServletRequest request){
        String pageTo = (String) request.getAttribute("page_from");
        if(pageTo == null || pageTo.isEmpty()){
            pageTo = PagePath.MAIN_PAGE;
        }
        return pageTo;
    }
}
