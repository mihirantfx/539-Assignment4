
import hotel.booking.BookingCTL;
import hotel.checkin.CheckinCTL;
import hotel.checkout.CheckoutCTL;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.entities.RoomType;
import hotel.entities.ServiceCharge;
import hotel.entities.ServiceType;
import hotel.service.RecordServiceCTL;
import hotel.utils.IOUtils;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {

        Guest guest = new Guest("Mihiran", "Melbourne", 426383884);
        Room room = new Room(111, RoomType.DOUBLE);
        CreditCard creditcard = new CreditCard(CreditCardType.VISA, 4, 111);
        Booking booking = new Booking(guest, room, new Date(), 1, 1, creditcard);

        long confirmationNumber = booking.getConfirmationNumber();

        System.out.println("Booking is created. Confirmation No: " + confirmationNumber);
        
        booking.checkIn();
        System.out.println("Booking checked in!");
        
        booking.addServiceCharge(ServiceType.ROOM_SERVICE, 50);
        System.out.println("Service charge added 50.0");
        
        List<ServiceCharge> serivceTypeList = booking.getCharges();
        System.out.println("\nDisplay added service charges:");
        for (ServiceCharge serviceCharge : serivceTypeList) {
            System.out.println(serviceCharge.getType() + " : " + serviceCharge.getCost());
        }
        
    }
}
