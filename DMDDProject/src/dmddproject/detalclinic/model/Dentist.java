package dmddproject.detalclinic.model;

public class Dentist {
	protected int id;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String contact;
	protected String licenseno;
	protected String licenseStart;
	protected String licenseEnd;
	protected int specializationno;
	protected String specializationName;
	
	public Dentist(int id, String firstName, String lastName, String email, String contact, String licenseno, String licenseStart, String licenseEnd, int specializationno, String specializationName  ) {
		super();
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.contact=contact;
		this.licenseno=licenseno;
		this.licenseStart=licenseStart;
		this.licenseEnd=licenseEnd;
		this.specializationno=specializationno;
		this.specializationName=specializationName;
		
	}
	
	public Dentist(int specializationno, String specializationName) {
		super();
		this.specializationno=specializationno;
		this.specializationName=specializationName;
		
	}
	

	
	public Dentist(int id, String firstName, String lastName, String email, String contact) {
		super();
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.contact=contact;
		
	}
	
	public Dentist(String firstName, String lastName, String email, String contact) {
		super();
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.contact=contact;		
	}
	
	public Dentist(String firstName, String lastName, String email, String contact, String licenseno, String licenseStart, String licenseEnd, int specializationno, String specializationName  ) {
		super();
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.contact=contact;
		this.licenseno=licenseno;
		this.licenseStart=licenseStart;
		this.licenseEnd=licenseEnd;
		this.specializationno=specializationno;
		this.specializationName=specializationName;
		
	}
	
		
	public int getSpecializationno() {
		return specializationno;
	}

	public void setSpecializationno(int specializationno) {
		this.specializationno = specializationno;
	}

	public String getLicenseno() {
		return licenseno;
	}

	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}

	public String getLicenseStart() {
		return licenseStart;
	}

	public void setLicenseStart(String licenseStart) {
		this.licenseStart = licenseStart;
	}

	public String getLicenseEnd() {
		return licenseEnd;
	}

	public void setLicenseEnd(String licenseEnd) {
		this.licenseEnd = licenseEnd;
	}

	public String getSpecializationName() {
		return specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
}
