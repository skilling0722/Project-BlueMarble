public class tax extends land {

	public tax(String name, int price, boolean canbuyland, int toll, String landlord, int check) {
		super(name, price, canbuyland, toll, landlord, check);
	}
	//국세청 벌금 메소드
	public void taximpose(player player) {
		System.out.println("세금(7만원) 부과!");
		player.setplayermoneytax();
	}

}
