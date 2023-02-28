package by.radyuk.myautobase.model.entity;

public class Application {
    private Long applictionId = -1L;
    private Driver driver;
    private Voyage voyage;

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public Long getApplictionId() {
        return applictionId;
    }

    public void setApplictionId(Long applictionId) {
        applictionId = applictionId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Application application = (Application) o;
        return applictionId.equals(application.applictionId)
                && driver.equals(application.driver)
                && voyage.equals(application.voyage);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Application{")
                .append(", applicationId=").append(applictionId)
                .append(", driver=").append(driver.toString())
                .append(", voyage").append(voyage.toString())
                .append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = applictionId.hashCode();
        result = result * 31 + driver.hashCode();
        result = result * 31 + voyage.hashCode();
        return result;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private final Application application;

        public Builder(){application = new Application();}

        public Builder setApplicationId(Long applicationId){
            application.setApplictionId(applicationId);
            return this;
        }

        public Builder setDriver(Driver driver){
            application.setDriver(driver);
            return this;
        }

        public Builder setVoyage(Voyage voyage){
            application.setVoyage(voyage);
            return this;
        }

        public Application build(){return application;}
    }
}
