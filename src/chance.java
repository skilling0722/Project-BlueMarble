import java.util.Random;

public class chance extends land {
	int randomvalue;

	public chance(String name, int price, boolean canbuyland, int toll,
			String landlord, int check) {
		super(name, price, canbuyland, toll, landlord, check);
	}
	
	Random random = new Random();
	
	//찬스 메소드
	public void Yeahchance(player player) {
		randomvalue = random.nextInt(4);
		if(randomvalue == 0){
			System.out.println("복권당첨! 10만원 지급");
			player.setplayermoneychanceup();
		}
		else if(randomvalue == 1){
			System.out.println("피곤에 지쳐 무인도로 갑니다.");
			player.setplayerlocation(8);
		}
		else if(randomvalue == 2){
			System.out.println("법규를 위반했습니다. 벌금 5만원 부과!");
			player.setplayermoneychancedown();
		}
		else {
			System.out.println("세계여행권에 당첨되었습니다. 세계여행으로 이동!");
			player.setplayerlocation(24);
		}
	}
	
	public int getrandomvalue(){			//어떤 찬스 걸렸는지 확인 메소드
		return randomvalue;
	}
}
		