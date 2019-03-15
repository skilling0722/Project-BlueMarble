//플레이어1 --> 플레이어2 --> 플레이어1 --> 플레이어2 반복
public class turn {
	private int turnvalue;
	
	public turn() {
		turnvalue = 1;
	}
	
	public int turning() {
		return turnvalue;
	}
	
	public int turnchange1() {
		return turnvalue++;
	}
	public int turnchange2() {
		return turnvalue--;
	}
}
