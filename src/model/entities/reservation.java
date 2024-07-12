package model.entities;

import model.entities.exceptions.DomainExceptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class reservation {

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    public reservation(Date checkin, Date checkOut, Integer roomNumber) throws DomainExceptions {
        if(!checkOut.after(checkin)){
            throw  new DomainExceptions("Check-out date must be after check-in date");
        }
        this.checkin = checkin;
        this.checkout = checkOut;
        this.roomNumber = roomNumber;
    }

    private  static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long duration(){
        long diff = checkout.getTime() - checkin.getTime(); // retorna a diferença em mili segundos
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }

    public void UpdateDates(Date checkin,Date checkOut) throws DomainExceptions{
        Date now = new Date();
        if(checkin.before(now) || checkOut.before(now)){
             throw new DomainExceptions("Reservation dates for update must be future dates");
        }
        if(!checkOut.after(checkin)){
             throw  new DomainExceptions("Check-out date must be after check-in date");
        }
        this.checkin = checkin;
        this.checkout = checkOut;
    }

    @Override
    public String toString(){
        return "Room: "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkin)
                + ", checkOut: "
                + sdf.format(checkout)
                + ", "
                + duration()
                + " nights";

    }
}
