package kevin_project;

public class DraftKing_Fantasy_Calculator {
	private String player_name;
	private Double fan_point;
	private Double salary;
	private Double fps_result;
	
	DraftKing_Fantasy_Calculator(String name, Double fan_point, Double salary){
		this.player_name = name;
		this.fan_point = fan_point;
		this.salary = salary;
		this.fps_result = new Double(0);
	}
	
	Double result() {
		this.fps_result = this.fan_point / this.salary;
		return this.fps_result;
	}

	public String getPlayer_name() {
		return player_name;
	}

	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}

	public Double getFan_point() {
		return fan_point;
	}

	public void setFan_point(Double fan_point) {
		this.fan_point = fan_point;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	

}
