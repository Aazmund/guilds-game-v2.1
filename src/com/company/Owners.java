package com.company;

import java.util.ArrayList;

public class Owners {

    private ArrayList<Owners> container = new ArrayList<>();

    private int fieldId;
    private int shareCount;
    private String owner;
    private String manufacture;

    public void addNewField(int fieldId, String owner, String manufacture){
        Owners owners = new Owners();
        owners.setFieldId(fieldId);
        owners.setOwner(owner);
        owners.setManufacture(manufacture);
        owners.setShareCount(0);
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
        for (Owners owners : container) {
            if (owners.getFieldId() == id) {
                owners.setOwner(name);
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

    public String getManufactureById(int id) {
        String result = "";
        for (Owners owners : container) {
            if (owners.getFieldId() == id) {
                result = owners.getManufacture();
                break;
            }
        }
        return result;
    }

    public void setManufactureById(int id, String manufacture){
        for (Owners owners : container) {
            if (owners.getFieldId() == id) {
                owners.setManufacture(manufacture);
                break;
            }
        }
    }

    public void removeManufactureById(int id){
        for (Owners owners : container) {
            if (owners.getFieldId() == id) {
                owners.setManufacture("null");
                break;
            }
        }
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public void addShareById(int id, int count){
        for (Owners owners : container) {
            if (owners.getFieldId() == id) {
                owners.setShareCount(owners.getShareCount() + count);
                break;
            }
        }
    }

    public int getShareById(int id){
        int result = 0;
        for (Owners owners : container) {
            if (owners.getFieldId() == id) {
                result = owners.getShareCount();
                break;
            }
        }
        return result;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public void setContainer(ArrayList<Owners> container) {
        this.container = container;
    }

    public ArrayList<Owners> getContainer() {
        return container;
    }
}
