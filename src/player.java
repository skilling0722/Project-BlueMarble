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
	
	public String getplayername() {			//�÷��̾� �̸� ���
		return name;
	}

	public int getplayermoney(){				//�÷��̾� �ں� ���
		return money;
	}
	
	public void setplayermoney(int price){	//�÷��̾� �ں�-�ǹ� ����
		this.money = money-price;
	}
	public void setplayermoneytoll(int toll){	//�÷��̾� �ں�+�����
		this.money = money+toll;
	}
	public void setplayermoneybouse(){		//�������� ���ʽ��Ӵ�
		this.money = money+50000;
	}
	public void setplayermoneychanceup(){	//���� ���Ǵ�÷
		this.money = money+100000;
	}
	public void setplayermoneychancedown(){	//���� ���� ����
		this.money = money-50000;
	}
	public void setplayermoneytax() {		//����û ���ݺΰ�
		this.money = money-70000;
	}
	
	public void salaryplayermoney() {		//�� ���� �������� ����
		this.money += 20000;
	}
	public int getplayerbuilding(){			//�÷��̾ ������ �ε��� �� 
		return building;
	}
	
	public void setplayerbuilding(){		//�ε��� ���Խ� +1
		this.building = building+1;
	}
	
	public int getplayerlocation(){			//�÷��̾� ��ġ
		return location;
	}
	
	public void setplayerlocation(int location) {	//�÷��̾� ��ġ ��ȯ
		this.location = location;
	}
	
	//�ֻ��� ���� ���� �÷��̾� �̵� + ���� �޼ҵ�
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
