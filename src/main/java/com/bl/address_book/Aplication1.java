package com.bl.address_book;

import java.util.*;

public class Aplication1
{
    List<AddressBookMain> a = new ArrayList<AddressBookMain>();
        AddressBookMain obj = new AddressBookMain();
        Scanner s1 = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        public void insertion() {
            System.out.print("Enter Serial number: ");
            obj.setSrnum(sc.nextInt());
            System.out.print("Enter First name: ");
            obj.setFirst_Name(sc.next());
            System.out.print("Enter last name: ");
            obj.setLast_Name(sc.next());
            System.out.print("Enter address: ");
            obj.setAddress(sc.nextLine());
            System.out.print("Enter state: ");
            obj.setState(sc.nextLine());
            System.out.print("Enter zip: ");
            obj.setZip_Code(s1.nextInt());
            System.out.print("Enter phone: ");
            obj.setPhone_Number(s2.nextLong());
            System.out.print("Enter email: ");
            obj.setEmail_id(sc.nextLine());
            a.addAll(Collections.singleton(obj));
        }

        public void display() {
            System.out.println("***********************************");
            Iterator<AddressBookMain> i = a.iterator();
            while (i.hasNext()) {
                AddressBookMain addr = i.next();
                System.out.println(addr);
            }
            System.out.println("***********************************");
        }

        public void search() {
            Iterator<AddressBookMain> i = a.iterator();
            boolean found = false;
            System.out.println("Enter serial number to search: ");
            int srno = s1.nextInt();
            System.out.println("***********************************");
            i = a.iterator();
            while (i.hasNext()) {
                AddressBookMain addr = i.next();
                if (addr.getSrnum() == srno) {
                    System.out.println(addr);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Entered Number Record Not matched");
            }
            System.out.println("***********************************");
        }

}

