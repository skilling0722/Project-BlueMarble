import java.util.Random;

public class chance extends land {
	int randomvalue;

	public chance(String name, int price, boolean canbuyland, int toll,
			String landlord, int check) {
		super(name, price, canbuyland, toll, landlord, check);
	}
	
	Random random = new Random();
	
	//���� �޼ҵ�
	public void Yeahchance(player player) {
		randomvalue = random.nextInt(4);
		if(randomvalue == 0){
			System.out.println("���Ǵ�÷! 10���� ����");
			player.setplayermoneychanceup();
		}
		else if(randomvalue == 1){
			System.out.println("�ǰ￡ ���� ���ε��� ���ϴ�.");
			player.setplayerlocation(8);
		}
		else if(randomvalue == 2){
			System.out.println("���Ը� �����߽��ϴ�. ���� 5���� �ΰ�!");
			player.setplayermoneychancedown();
		}
		else {
			System.out.println("���迩��ǿ� ��÷�Ǿ����ϴ�. ���迩������ �̵�!");
			player.setplayerlocation(24);
		}
	}
	
	public int getrandomvalue(){			//� ���� �ɷȴ��� Ȯ�� �޼ҵ�
		return randomvalue;
	}
}
		