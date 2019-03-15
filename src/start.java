
public class start extends land {

	public start(String name, int price, boolean canbuyland, int toll,String landlord,int check) {
		super(name, price,canbuyland, toll, landlord, check);
		
	}
	//시작지점 보너스머니지급 메소드
	public void startbouse(player player) {
		System.out.println("보너스머니(5만원) 지급!");
		player.setplayermoneybouse();
		
	}
}
