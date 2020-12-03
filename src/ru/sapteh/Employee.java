package ru.sapteh;

public class Employee {
    private int id;
    private String fio;
    private String position;
    private int paycheck;
    private String organization;

    public Employee(int id,String fio,String position,int paycheck,String organization){
        this.fio = fio;
        this.position = position;
        this.paycheck = paycheck;
        this.organization = organization;
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public String getPosition() {
        return position;
    }

    public int getPaycheck() {
        return paycheck;
    }

    public String getOrganization() {
        return organization;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setPaycheck(int paycheck) {
        this.paycheck = paycheck;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString(){
        return String.format("%d %s %s %d %s",getId(),getFio(),getPosition(),getPaycheck(),getOrganization());
    }
}
