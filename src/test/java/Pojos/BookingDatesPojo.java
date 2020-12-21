package Pojos;

public class BookingDatesPojo {
	
	//1)Create "private" variables for every key of Json Data
	private String checkin;
	private String checkout;
	
	//2)Create getters() and setters()
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	
	//3)Create Constructor without parameters
	public BookingDatesPojo() {

	}
	
	//4)Create Constructor with parameters
	public BookingDatesPojo(String checkin, String checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	//5)Create toString()
	@Override
	public String toString() {
		return "bookingDatesPojo [checkin=" + checkin + ", checkout=" + checkout + "]";
	}

}
