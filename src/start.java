
public class start extends land {

	public start(String name, int price, boolean canbuyland, int toll,String landlord,int check) {
		super(name, price,canbuyland, toll, landlord, check);
		
	}
	//�������� ���ʽ��Ӵ����� �޼ҵ�
	public void startbouse(player player) {
		System.out.println("���ʽ��Ӵ�(5����) ����!");
		player.setplayermoneybouse();
		
	}
}
