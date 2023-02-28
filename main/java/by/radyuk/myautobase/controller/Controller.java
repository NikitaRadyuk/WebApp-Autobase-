package by.radyuk.myautobase.controller;

import by.radyuk.myautobase.controller.command.Command;
import by.radyuk.myautobase.controller.command.CommandProvider;

import by.radyuk.myautobase.exception.CommandException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "controller", value = "/controller")
public class Controller extends HttpServlet {
    //private static final Logger logger = LogManager.getLogger(Controller.class);
    private static final String COMMAND_NAME = "command";
    private static final String APPLICATION_CONTEXT = "/controller";

    public void init(){}
    private final CommandProvider commandProvider = CommandProvider.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String commandName = request.getParameter(COMMAND_NAME);
        if (commandName == null) return;
        request.setAttribute("contextPath", getServletContext().getContextPath());
        Command command = CommandProvider.getInstance().getCommand(commandName);

        String router = null;

        try {
            router = command.execute(request);
        } catch (CommandException e) {
            response.getWriter().print(e);
            return;
        }

        if (router != null & request.getParameter("isRedirect") == null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(router);
            dispatcher.forward(request, response);
        }else {
            if (request.getParameter("isRedirect") != null){
                response.sendRedirect(getServletContext().getContextPath()
                + request.getParameter("redirectURL"));
            }
            else {
                response.sendRedirect(getServletContext().getContextPath() + APPLICATION_CONTEXT);
            }
        }
    }
}
