package com.sxt.serjplayground.DTOs;


public class DTOComment
{
    public int postId;
    public int id;
    public String name;
    public String email;
    public String body;


    @Override
    public String toString() {
        return String.format("%s - %s", name, email);
    }
}
