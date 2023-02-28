/*
package by.radyuk.myautobase.model.validator;

import by.radyuk.myautobase.model.entity.Driver;

public final class DriverValidator implements Validator{
    private static final DriverValidator INSTANCE = new DriverValidator();

    private DriverValidator(){}

    public static DriverValidator getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean isValid(Object object){
        if(object == null || object.getClass() != Driver.class)
            return false;
        Driver driver = (Driver) object;
        return driver.getAuto() != null
                && !driver.getAuto().isEmpty
                && driver.getStanding() != null
                && !driver.getStanding().isEmpty;
    }
}
*/
