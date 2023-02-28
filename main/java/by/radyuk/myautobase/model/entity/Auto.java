package by.radyuk.myautobase.model.entity;

public class Auto {
    private Long idAuto = -1L;
    private String model;
    private Integer loadCapacity;
    private AutoStatus status;

    public Long getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(Long idAuto) {
        this.idAuto = idAuto;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public AutoStatus getStatus() {
        return status;
    }

    public void setStatus(AutoStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Auto auto = (Auto) o;
        return idAuto.equals(auto.idAuto)
                && model.equals(auto.model)
                && loadCapacity.equals(auto.loadCapacity)
                && status.equals(auto.status);
    }

    @Override
    public int hashCode(){
        int result = idAuto.hashCode();
        result = result * 31 + model.hashCode();
        result = result * 31 + loadCapacity.hashCode();
        result = result * 31 + status.hashCode();
        return result;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Auto")
                .append(", idAuto=").append(idAuto)
                .append(", model=").append(model)
                .append(", loadCapacity=").append(loadCapacity)
                .append(", status=").append(status)
                .append('}');
        return sb.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private final Auto auto;

        public Builder(){
            auto = new Auto();
        }

        public Builder setAutoId(Long autoId){
            auto.setIdAuto(autoId);
            return this;
        }

        public Builder setModel(String model){
            auto.setModel(model);
            return this;
        }

        public Builder setLoadCapacity(Integer loadCapacity){
            auto.setLoadCapacity(loadCapacity);
            return this;
        }
        public Builder setStatus(AutoStatus status){
            auto.setStatus(status);
            return this;
        }

        public Auto build(){
            return auto;
        }
    }
}

