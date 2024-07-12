package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import  model.entities.reservation;
public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkin)){
            System.out.println("Error ...");
        }
        else{
            reservation res = new reservation(checkin,checkOut,number);
            System.out.print("Reservation: " + res);

            System.out.println();
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out dare (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            String error = res.UpdateDates(checkin,checkOut);
            if(error != null){
                System.out.print("Error in reservation");
            }
            else {
                System.out.println("Reservation: " + res);
            }
        }
        sc.close();
    }
}