//�÷��̾�1 --> �÷��̾�2 --> �÷��̾�1 --> �÷��̾�2 �ݺ�
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
