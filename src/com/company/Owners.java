package com.company;

import java.util.ArrayList;

public class Owners {

    private ArrayList<Owners> container = new ArrayList<>();

    private int fieldId;
    private String owner;
    private String manufacture;

    public void addNewField(int fieldId, String owner, String manufacture){

        Owners owners = new Owners();
        owners.setFieldId(fieldId);
        owners.setOwner(owner);
        owners.setManufacture(manufacture);

        container.add(owners);
    }

    public String getOwnerById(int id){
        String result = "";
        for (int i = 0; i < container.size(); i++){
            if (container.get(i).getFieldId() == id){
                result = container.get(i).getOwner();
                break;
            }
        }
        return result;
    }

    public void changeFieldOwner(int id, String name){
        for (int i = 0; i < container.size(); i++){
            if (container.get(i).getFieldId() == id){
                container.get(i).setOwner(name);
                break;
            }
        }
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
