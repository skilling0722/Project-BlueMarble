public class desertisland extends land {

	public desertisland(String name, int price, boolean canbuyland, int toll,
			String landlord, int check) {
		super(name, price,canbuyland, toll, landlord, check);
	}
	//���ε� �޼ҵ�
	public void desert(player player, turn turn){
		System.out.println("���ε��� ���̳׿�. ���� ������ ������.");
		if(player.getplayername().equals("player1")){
			turn.turnchange1();
		}else{
			turn.turnchange2();
		}
	}
}
