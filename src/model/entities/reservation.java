package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class reservation {

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    public reservation(Date checkin, Date checkout, Integer roomNumber) {
        this.checkin = checkin;
        this.checkout = checkout;
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

    public void UpdateDates(Date checkin,Date checkout){
        this.checkin = checkin;
        this.checkout = checkout;
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
