package by.radyuk.myautobase.model.validator;

import by.radyuk.myautobase.model.entity.Application;

public final class ApplicationValidator implements Validator{

    private static final ApplicationValidator INSTANCE = new ApplicationValidator();
    private ApplicationValidator(){}

    public static ApplicationValidator getInstance(){
        return  INSTANCE;
    }
    @Override
    public boolean isValid(Object object) {
        if (object == null || object.getClass() != Application.class)
            return false;
        Application application = (Application) object;
        return application.getVoyage() != null;
                //только стринги для исЭмпти;
    }
}
