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
		search[0] = "세계여행";
		search[1] = "찬스1";
		search[2] = "찬스2";
		search[3] = "찬스3";
		search[4] = "찬스4";
	}
	
	//입력받은 장소 존재여부 확인 메소드
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
	//세계여행 메소드
	public void worldtour (player player, land[] DDang) {
		System.out.println("가고싶은 곳을 입력하세요. ex) 시작지점, 베를린 #찬스와 세계여행은 선택불가능");
		while(true){
			tourcheck(DDang);
			if(i==32){
				System.out.println("다시 입력하세요.");
			}
			if(i!=32){
				break;
			}
		}
		player.setplayerlocation(i);
	}
}

