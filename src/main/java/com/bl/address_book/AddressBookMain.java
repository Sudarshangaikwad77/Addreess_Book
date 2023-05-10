package com.bl.address_book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class AddressBookMain
{
    private String First_Name;
    private String Last_Name;
    private int Phone_Number;
    private String Email_id;

    public AddressBookMain(int Srnum,String first_Name, String last_Name, int phone_Number, String email_id, String address, String city) {
        First_Name = first_Name;
        Last_Name = last_Name;
        Phone_Number = phone_Number;
        Email_id = email_id;
        Address = address;
        City = city;
    }

    private String Address;
    private String City;

    public AddressBookMain(int srnum, String first_name, String last_name, String address, String state, int zip_code, long phone_number, String email_id) {
    }

    public AddressBookMain() {

    }


    public int getSrnum() {
        return Srnum;
    }

    public void setSrnum(int srnum) {
        this.Srnum = srnum;
    }

    private int Srnum;
    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public double getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(long phone_Number) {
        this.Phone_Number = (int) phone_Number;
    }

    public String getEmail_id() {
        return Email_id;
    }

    public void setEmail_id(String email_id) {
        Email_id = email_id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getZip_Code() {
        return Zip_Code;
    }

    public void setZip_Code(int zip_Code) {
        Zip_Code = zip_Code;
    }

    private String State;
    private int Zip_Code;



    public static void main(String[] args) {
        System.out.println("Welcome To Address Book Programme");
        Scanner ab = new Scanner(System.in);
        // Creating The First Contact
        System.out.println("Enter Your First Name: ");
        String first_name = ab.nextLine();
        System.out.println("Enter Your Last Name: ");
        String last_name = ab.nextLine();
        System.out.println("Enter Your Address: ");
        String address = ab.nextLine();
        System.out.println("Enter Your City: ");
        String city = ab.nextLine();
        System.out.println("Enter Your State: ");
        String state = ab.nextLine();
        System.out.println("Enter Your Email: ");
        long email = ab.nextLong();
        System.out.println("Enter Your Mobile Number: ");
        long phone_number = ab.nextLong();
        System.out.println("Enter Your Zip Code: ");
        int zip_code = ab.nextInt();

        System.out.println("New Contact: " + "\n" + "First Name: " +first_name+ " Last Name: " +last_name+ " Address: "+address+
                " City: " +city+ " State: " + state + " Email: "+ email+ " Mobile: "+ phone_number + " Postal: " + zip_code);

    }
}



