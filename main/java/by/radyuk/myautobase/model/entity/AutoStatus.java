package by.radyuk.myautobase.model.entity;

public enum AutoStatus {
    ALL_GOOD(0),
    SMTH_WRONG(1);

    private int statusId;

    AutoStatus(int statusId){
        this.statusId=statusId;
    }

    public int getStatusId(){
        return statusId;
    }
}
