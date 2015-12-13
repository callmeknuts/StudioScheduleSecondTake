package com.Mike;

/**
 * Created by Mike on 12/8/2015.
 */
public class Client {
    private String id;
    private String name;
    private String number;
    private String address;
    private String email;

    public Client(String id, String name, String number,String address,String email) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return name + " - " + number + " - " + address + " - " + email;
    }
}
