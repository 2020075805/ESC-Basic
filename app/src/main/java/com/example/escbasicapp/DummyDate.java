package com.example.escbasicapp;

import java.util.ArrayList;

public class DummyDate {

    public static ArrayList<Contact> contacts = new ArrayList<>();

    static {
        contacts.add(new Contact("곽용무", "010-3744-0844", "kkolbuy@gmail.com"));
        contacts.add(new Contact("윤무원", "010-5510-3499", "sample@gmail.com"));
        contacts.add(new Contact("박호연", "010-7199-5703", "twinspark1221@naver.com"));
    }
}
