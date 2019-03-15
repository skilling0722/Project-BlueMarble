public class desertisland extends land {

	public desertisland(String name, int price, boolean canbuyland, int toll,
			String landlord, int check) {
		super(name, price,canbuyland, toll, landlord, check);
	}
	//무인도 메소드
	public void desert(player player, turn turn){
		System.out.println("무인도에 오셨네요. 한턴 쉬었다 가세요.");
		if(player.getplayername().equals("player1")){
			turn.turnchange1();
		}else{
			turn.turnchange2();
		}
	}
}
