package springboot.learn.reflect;

public class ReflectClass {

	private String name;
	private int age;
	private String address;
	
//	private final String s ="This is final String.";
	
	
	public ReflectClass() {
		super();
	}




	public ReflectClass(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getNameAndAge(){
		return name+age;
	}
	
	
	
}
