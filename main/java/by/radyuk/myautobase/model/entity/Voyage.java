package by.radyuk.myautobase.model.entity;

public class Voyage {
    private Long idVoyage = -1L;
    private String typeOfCargo;
    private String route;
    private String time;

    public Long getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(Long idVoyage) {
        this.idVoyage = idVoyage;
    }

    public String getTypeOfCargo() {
        return typeOfCargo;
    }

    public void setTypeOfCargo(String typeOfCargo) {
        this.typeOfCargo = typeOfCargo;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Voyage voyage = (Voyage) o;
        return idVoyage.equals(voyage.idVoyage)
                && typeOfCargo.equals(voyage.typeOfCargo)
                && route.equals(voyage.route)
                && time.equals(voyage.time);
    }

    @Override
    public int hashCode(){
        int result = idVoyage.hashCode();
        result = result * 31 + typeOfCargo.hashCode();
        result = result * 31 + route.hashCode();
        result = result * 31 + time.hashCode();
        return result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Voyage{")
                .append("voyageId=").append(idVoyage)
                .append(", typeOfCargo=").append(typeOfCargo)
                .append(", route=").append(route)
                .append(", time=").append(time)
                .append('}');
        return sb.toString();
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private final Voyage voyage;

        public Builder(){
            voyage = new Voyage();
        }

        public Builder setVoyageId(Long voyageId){
            voyage.setIdVoyage(voyageId);
            return this;
        }

        public Builder setTypeOfCargo(String typeOfCargo){
            voyage.setTypeOfCargo(typeOfCargo);
            return this;
        }

        public Builder setRoute(String route){
            voyage.setRoute(route);
            return this;
        }

        public Builder setTime(String time){
            voyage.setTime(time);
            return this;
        }

        public Voyage build(){return voyage;}
    }
}
