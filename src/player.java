public class player {
	private int money;
	private int building;
	private int location;
	private String name;
	
	public player(String name) {
		location = 0;
		building = 0;
		money = 300000;
		this.name = name;
	}
	
	public String getplayername() {			//플레이어 이름 얻기
		return name;
	}

	public int getplayermoney(){				//플레이어 자본 얻기
		return money;
	}
	
	public void setplayermoney(int price){	//플레이어 자본-건물 가격
		this.money = money-price;
	}
	public void setplayermoneytoll(int toll){	//플레이어 자본+통행료
		this.money = money+toll;
	}
	public void setplayermoneybouse(){		//시작지점 보너스머니
		this.money = money+50000;
	}
	public void setplayermoneychanceup(){	//찬스 복권당첨
		this.money = money+100000;
	}
	public void setplayermoneychancedown(){	//찬스 법규 위반
		this.money = money-50000;
	}
	public void setplayermoneytax() {		//국세청 세금부과
		this.money = money-70000;
	}
	
	public void salaryplayermoney() {		//한 바퀴 돌때마다 월급
		this.money += 20000;
	}
	public int getplayerbuilding(){			//플레이어가 보유한 부동산 수 
		return building;
	}
	
	public void setplayerbuilding(){		//부동산 구입시 +1
		this.building = building+1;
	}
	
	public int getplayerlocation(){			//플레이어 위치
		return location;
	}
	
	public void setplayerlocation(int location) {	//플레이어 위치 변환
		this.location = location;
	}
	
	//주사위 값에 따른 플레이어 이동 + 월급 메소드
	public void move(int dicesum, player player){
		for(int i=0;i<dicesum;i++){
			this.location++;
			
			if(this.location>31) {
				this.location-=32;
				player.salaryplayermoney();
				
			}
		}
	}
}
