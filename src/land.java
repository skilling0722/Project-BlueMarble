public class land {
	private String name;							//이름
	private int price;								//가격
	private boolean canbuyland;						//구입 가능?
	private int toll;								//통행료
	private String landlord;						//주인
	private int check;								//도착지점확인
	public land(String name, int price, boolean canbuyland, int toll, String landlord,int check){
		super();
		this.name = name;
		this.price = price;
		this.canbuyland = canbuyland;
		this.toll = toll;
		this.landlord = landlord;
		this.check = check;
	}
	
	public String getname() {						//땅 이름 얻기
		return name;
	}
	
	public int getprice() {							//땅 가격 얻기
		return price;
	}
	
	public boolean getcanbuyland() {				//땅 구입 가능유무
		return canbuyland;
	}
	
	public void setcanbuyland(boolean canbuyland) {	//땅 구입 가능유무 변경
		this.canbuyland = canbuyland;
	}
	
	public String getlandlord() {					//땅 주인 얻기
		return landlord;
	}
	
	public void setlandlord(String landlord) {		//땅 주인 변경
		this.landlord = landlord;
	}
	public int gettoll() {							//통행료 얻기
		return toll;
	}
	public int getcheck() {							//도착지점이 뭔지 확인하는 메소드
		return check;
	}

}

