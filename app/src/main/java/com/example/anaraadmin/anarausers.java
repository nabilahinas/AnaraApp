package com.example.anaraadmin;

public class anarausers
{
    private String email;
    private String message;
    private String name;
    public anarausers(){}
    public anarausers(String email, String message, String name)
    {
        this.email = email;
        this.message = message;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
