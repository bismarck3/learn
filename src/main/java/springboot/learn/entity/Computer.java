package springboot.learn.entity;

/**
 * xml测试Person.computer
 * @author wangj
 *
 */
public class Computer {

	private String name;
	private String cpu;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	@Override
	public String toString() {
		return "Computer [name=" + name + ", cpu=" + cpu + "]";
	}
	
}
