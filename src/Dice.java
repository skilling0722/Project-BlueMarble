//주사위 클래스
public class Dice{
	private int Dice1;
	private int Dice2;
	private int Dicesum;
	
	public void roll(){
		Dice1 = (int)(Math.random()*6)+1;	//1~6 값 생성
		Dice2 = (int)(Math.random()*6)+1;	//1~6 값 생성
		Dicesum = Dice1 + Dice2;			//Dice1+Dice2
	}
	
	public int Dicesum(){					//주사위 합 얻기
		return Dicesum;
	}
}
