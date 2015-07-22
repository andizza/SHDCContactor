package sensorapp.shdccontactor;

public class DCMember {
    private String chiName;
    private String engName;
    private String email;
    private String mobNumber;

    public String getChiName(){
        return chiName;
    }

    public String getEngName(){
        return engName;
    }

    public String getEmail(){
        return email;
    }

    public String getMobNumber(){
        return mobNumber;
    }

    public void setChiName(String chiName){
        this.chiName = chiName;
    }

    public void setEngName(String engName){
        this.engName = engName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setMobNumber(String mobNumber){
        this.mobNumber = mobNumber;
    }
}
