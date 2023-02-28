package by.radyuk.myautobase.controller.command;

import by.radyuk.myautobase.controller.command.impl.general.*;

import java.util.EnumMap;

/**
 * The class CommandProvider. It helps to find a command with specified name.
 */
public final class CommandProvider {
    private static CommandProvider INSTANCE = null;
    private final EnumMap<CommandType, Command> commands = new EnumMap(CommandType.class);

    private CommandProvider() {
        addGeneralCommands();
        /*addUserCommands();
        addAdminCommands();*/
    }

    /**
     * Gets instance.
     *
     * @return the instance of command provider
     */
    public static CommandProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommandProvider();
        }
        return INSTANCE;
    }

    /**
     * Gets command.
     *
     * @param commandName the command name
     * @return the command with specified name
     */
    public Command getCommand(String commandName) {
        Command command = null;
        CommandType key = null;

        commandName = commandName.replace('-', '_').toUpperCase();
        key = CommandType.valueOf(commandName);

        command = key.getCurrentCommand();

        if(command == null){
            //command = new UnknownCommand();
        }

        return command;
    }

    private void addGeneralCommands() {
        commands.put(CommandType.SHOW_LOGIN_PAGE, new SignInCommand());
        /*commands.put(CommandType.SIGN_UP, new SignUpCommand());
        commands.put(CommandType.DEFAULT, new DefaultCommand());
        commands.put(CommandType.GET_APPLICATION_LIST, new GetApplicationListCommand());
        commands.put(CommandType.CHANGE_LOCALE, new ChangeLocaleCommand());
        commands.put(CommandType.MOVE_TO_MAIN_PAGE, new MoveToMainPageCommand());
        commands.put(CommandType.MOVE_TO_LOGIN_PAGE, new MoveToLoginPageCommand());
        commands.put(CommandType.MOVE_TO_SIGNUP_PAGE, new MoveToSignUpPageCommand());
        commands.put(CommandType.EMAIL_VERIFICATION, new EmailVerificationCommand());*/
    }
/*
    private void addAdminCommands() {
        commands.put(CommandType.GET_USERS, new AddUsersCommand());
        commands.put(CommandType.CHANGE_USER_ROLE, new ChangeUserRoleCommand());
        commands.put(CommandType.MOVE_TO_ADD_APPLICATION_PAGE, new MoveToAddAppPageCommand());
        commands.put(CommandType.MOVE_TO_EDIT_APPLICATION_PAGE, new MoveToEditAppPageCommand());
        commands.put(CommandType.EDIT_APPLICATION, new EditAppCommand());
        commands.put(CommandType.DELETE_APPLICATION, new DeleteAppCommand());
        commands.put(CommandType.ADD_APPLICATION, new AddAppCommand());
    }

    private void addUserCommands() {
        commands.put(CommandType.SIGN_OUT, new SignOutCommand());
        commands.put(CommandType.TAKE_APPLICATION, new TakeAppCommand());
        commands.put(CommandType.ADD_STATUS_OF_AUTO, new AddStatusOfAutoCommand());
    }*/
}
