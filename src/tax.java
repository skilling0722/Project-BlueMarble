public class tax extends land {

	public tax(String name, int price, boolean canbuyland, int toll, String landlord, int check) {
		super(name, price, canbuyland, toll, landlord, check);
	}
	//����û ���� �޼ҵ�
	public void taximpose(player player) {
		System.out.println("����(7����) �ΰ�!");
		player.setplayermoneytax();
	}

}
