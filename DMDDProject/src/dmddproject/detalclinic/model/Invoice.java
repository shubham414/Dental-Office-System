package dmddproject.detalclinic.model;

import java.util.Date;

public class Invoice {
	protected int id;
	protected int amount;
	protected String date;
	protected String appointment_ID;

	
	public Invoice(int id, int Amount, String Date, String Appointment_ID) {
		super();
		this.id = id;
		this.amount = Amount;
		this.date = Date;
		this.appointment_ID = Appointment_ID;
	}

	public Invoice(int Amount, String Date, String Appointment_ID) {
		super();
		this.amount = Amount;
		this.date = Date;
		this.appointment_ID = Appointment_ID;
	}

	public Invoice(String Appointment_ID) {
		super();
		this.appointment_ID = Appointment_ID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAppointment_ID() {
		return appointment_ID;
	}

	public void setAppointment_ID(String appointment_ID) {
		this.appointment_ID = appointment_ID;
	}
}
