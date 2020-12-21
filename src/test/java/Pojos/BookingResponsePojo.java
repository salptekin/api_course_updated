package Pojos;

public class BookingResponsePojo {
	//1
	private int bookingid;
	private BookingPojo booking;
	
	//2
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public BookingPojo getBooking() {
		return booking;
	}
	public void setBooking(BookingPojo booking) {
		this.booking = booking;
	}
	
	//3
	public BookingResponsePojo() {

	}
	
	//4
	public BookingResponsePojo(int bookingid, BookingPojo booking) {
		this.bookingid = bookingid;
		this.booking = booking;
	}
	
	//5
	@Override
	public String toString() {
		return "BookingResponsePojo [bookingid=" + bookingid + ", booking=" + booking + "]";
	}

}
