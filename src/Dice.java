//�ֻ��� Ŭ����
public class Dice{
	private int Dice1;
	private int Dice2;
	private int Dicesum;
	
	public void roll(){
		Dice1 = (int)(Math.random()*6)+1;	//1~6 �� ����
		Dice2 = (int)(Math.random()*6)+1;	//1~6 �� ����
		Dicesum = Dice1 + Dice2;			//Dice1+Dice2
	}
	
	public int Dicesum(){					//�ֻ��� �� ���
		return Dicesum;
	}
}
