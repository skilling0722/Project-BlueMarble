public class land {
	private String name;							//�̸�
	private int price;								//����
	private boolean canbuyland;						//���� ����?
	private int toll;								//�����
	private String landlord;						//����
	private int check;								//��������Ȯ��
	public land(String name, int price, boolean canbuyland, int toll, String landlord,int check){
		super();
		this.name = name;
		this.price = price;
		this.canbuyland = canbuyland;
		this.toll = toll;
		this.landlord = landlord;
		this.check = check;
	}
	
	public String getname() {						//�� �̸� ���
		return name;
	}
	
	public int getprice() {							//�� ���� ���
		return price;
	}
	
	public boolean getcanbuyland() {				//�� ���� ��������
		return canbuyland;
	}
	
	public void setcanbuyland(boolean canbuyland) {	//�� ���� �������� ����
		this.canbuyland = canbuyland;
	}
	
	public String getlandlord() {					//�� ���� ���
		return landlord;
	}
	
	public void setlandlord(String landlord) {		//�� ���� ����
		this.landlord = landlord;
	}
	public int gettoll() {							//����� ���
		return toll;
	}
	public int getcheck() {							//���������� ���� Ȯ���ϴ� �޼ҵ�
		return check;
	}

}

