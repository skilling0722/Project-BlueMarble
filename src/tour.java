import java.util.Scanner;

public class tour extends land {

	Scanner scanner;
	private String want;
	private int i;
	private String[] search;
	
	public tour(String name, int price, boolean canbuyland, int toll,
			String landlord,int check) {
		super(name, price, canbuyland, toll, landlord,check);
		scanner = new Scanner(System.in);
		search = new String[5];
		search[0] = "���迩��";
		search[1] = "����1";
		search[2] = "����2";
		search[3] = "����3";
		search[4] = "����4";
	}
	
	//�Է¹��� ��� ���翩�� Ȯ�� �޼ҵ�
	public int tourcheck(land[] DDang){
		want = scanner.next();
		for(i=0;i<32;i++){
			if(want.equals(DDang[i].getname())){
				break;
			}
		}
		for(int k=0;k<5;k++){
			if(want.equals(search[k])){
				i=32;
			}
		}
		return i;
	}
	//���迩�� �޼ҵ�
	public void worldtour (player player, land[] DDang) {
		System.out.println("������� ���� �Է��ϼ���. ex) ��������, ������ #������ ���迩���� ���úҰ���");
		while(true){
			tourcheck(DDang);
			if(i==32){
				System.out.println("�ٽ� �Է��ϼ���.");
			}
			if(i!=32){
				break;
			}
		}
		player.setplayerlocation(i);
	}
}

