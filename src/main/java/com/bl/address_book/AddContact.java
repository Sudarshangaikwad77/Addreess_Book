package com.bl.address_book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AddContact {

    public static void main(String[] args) {

        // Collection<AddressBook> a = new ArrayList<AddressBook>();
        List<AddressBookMain> a = new ArrayList<AddressBookMain>();

        Aplication1 a2 = new Aplication1();
        Scanner s1 = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int ch;
        do  {
            System.out.println("Press 1 for Insert");
            System.out.println("Press 2 for Display");
            System.out.println("Press 3 for Search");
            System.out.println("Press 4 for Delete");
            System.out.println("Press 5 for Update");
            System.out.println("Press 0 for exit");
            System.out.print("Enter your choice: ");
            ch = s1.nextInt();
            switch (ch) {
                case 1:
                    a2.insertion();
                    break;

                case 2:
                    a2.display();
                    break;

                case 3:
                    a2.search();
                    break;


            }
        } while (ch != 0);
    }
        }
