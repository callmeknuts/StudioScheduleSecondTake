package com.Mike;

/**
 * Created by Mike on 12/8/2015.
 */
public class Client {
    private String id;
    private String fName;
    private String lName;
    private String number;
    private String address;
    private String email;

    public Client(String id, String fName,String lName, String number,String address,String email) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.number = number;
        this.address = address;
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return fName + " " + lName + " - " + number + " - " + address + " - " + email;
    }
}
