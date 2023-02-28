package by.radyuk.myautobase.model.entity;

public class Driver {
    private Long idDriver = -1L;
    private Integer standing;
    private Auto auto;
    private User user;

    public Long getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Long idDriver) {
        this.idDriver = idDriver;
    }

    public Integer getStanding() {
        return standing;
    }

    public void setStanding(int standing) {
        this.standing = standing;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Driver driver = (Driver) o;
        return idDriver.equals(driver.idDriver)
                && standing.equals(driver.standing)
                && auto.equals(driver.auto)
                && user.equals(driver.user);
    }

    @Override
    public int hashCode(){
        int result = idDriver.hashCode();
        result = result * 31 + standing.hashCode();
        result = result * 31 + auto.hashCode();
        result = result * 31 + user.hashCode();
        return result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Driver{")
                .append(", idDriver=").append(idDriver)
                .append(", standing=").append(standing)
                .append(", auto=").append(auto.toString())
                .append(", user=").append(user.toString())
                .append('}');
        return sb.toString();
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private final Driver driver;

        public Builder(){
            driver = new Driver();
        }

        public Builder setDriverId(Long driverId){
            driver.setIdDriver(driverId);
            return this;
        }

        public Builder setStanding(Integer standing){
            driver.setStanding(standing);
            return this;
        }

        public Builder setAuto(Auto auto){
            driver.setAuto(auto);
            return this;
        }

        public Builder setUser(User user){
            driver.setUser(user);
            return this;
        }

        public Driver build(){
            return driver;
        }
    }
}
