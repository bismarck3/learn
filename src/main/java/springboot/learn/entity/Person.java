package springboot.learn.entity;

import java.util.List;

/**
 * xml测试对象 Person
 * @author wangj
 *
 */
public class Person {
	
	private String name;
	private Integer age;
	private List<Computer> computer;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public List<Computer> getComputer() {
		return computer;
	}
	public void setComputer(List<Computer> computer) {
		this.computer = computer;
	}
	
	
}
