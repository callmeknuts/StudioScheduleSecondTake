package com.Mike;

/**
 * Created by Mike on 12/8/2015.
 */
public class Client {
    private String name;
    private String number;
    private String address;
    private String email;

    public Client(String name, String number,String address,String email) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
    }

    public String toString() {
        return name + " - " + number + " - " + address + " - " + email;
    }
}
