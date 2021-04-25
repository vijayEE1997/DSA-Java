package patientintake;

public enum Doctor {
	dhakad("Vijay Dhakad"),
	meena("Lalita Meena"),
	verma("Chandrakant Verma");
	
	private String name;
	
	Doctor(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
}
