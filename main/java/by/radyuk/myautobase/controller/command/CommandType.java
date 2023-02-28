package by.radyuk.myautobase.controller.command;

import by.radyuk.myautobase.controller.command.impl.general.*;

import by.radyuk.myautobase.controller.command.impl.moveto.general.MoveToLoginPageCommand;
import by.radyuk.myautobase.controller.command.impl.moveto.general.MoveToMainPageCommand;
import by.radyuk.myautobase.controller.command.impl.moveto.general.MoveToSignUpPageCommand;

public enum CommandType {
    LOGIN{{
        current = new SignInCommand();
        adminCommand = false;
    }}

    ,
    SHOW_REGISTER_PAGE{{
        current = new MoveToSignUpPageCommand();
        adminCommand = false;
    }}
    ,
    SHOW_LOGIN_PAGE{{
        current = new MoveToLoginPageCommand();
        adminCommand = false;
    }}
    ,
    REGISTER{{
        current = new SignUpCommand();
        adminCommand = false;
    }}

    , MOVE_TO_MAIN_PAGE{{
        current = (Command) new MoveToMainPageCommand();
        adminCommand = false;
    }}
    ,
    MOVE_TO_SIGNUP_PAGE{{
        current = new MoveToSignUpPageCommand();
        adminCommand = false;
    }}
    ,

    SHOW_ADDVOYAGE_PAGE{{
        current = new ShowAddVoyageCommand();
        adminCommand = true;
    }},
    SHOW_FREEVOYAGES_PAGE{{
        current = new ShowFreeVoyagesCommand();
        adminCommand = false;
    }}
    ,
    SELECT_VOYAGE{{
        current = new SelectVoyageCommand();
        adminCommand = false;
    }},
    ADD_VOYAGE{{
        current = new addVoyageCommand();
        adminCommand = true;
    }},
    DEFAULT;

    Command current = null;
    boolean adminCommand = false;

    public Command getCurrentCommand() {
        return current;
    }
    public boolean getIsAdmin(){
        return adminCommand;
    }
}
