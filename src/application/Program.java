package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.exceptions.DomainExceptions;
import  model.entities.reservation;
public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room Number: ");
            int number = sc.nextInt();
            System.out.print("check-in date (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.print("check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            reservation res = new reservation(checkin, checkOut, number);
            System.out.print("Reservation: " + res);

            System.out.println();
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out dare (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            res.UpdateDates(checkin, checkOut);
            System.out.println("Reservation: " + res);
        }
        catch (ParseException e){
            System.out.println("Invalid date format");
        }
        catch (DomainExceptions e){
            System.out.print("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.print("Unexpected error");
        }

        sc.close();
    }
}