package by.radyuk.myautobase.model.validator;

import by.radyuk.myautobase.model.entity.Auto;

public final class AutoValidator implements Validator{
    private static final AutoValidator INSTANCE = new AutoValidator();
    private AutoValidator(){}

    public static AutoValidator getInstance(){return INSTANCE;}

    @Override
    public boolean isValid(Object object) {
        if(object == null || object.getClass() != Auto.class)
            return false;
        Auto auto = (Auto) object;
        return auto.getModel() != null
                && !auto.getModel().isEmpty();
    }
}
