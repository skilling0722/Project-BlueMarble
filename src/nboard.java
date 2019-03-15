import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sun.audio.AudioStream;
@SuppressWarnings("restriction")

public class nboard extends JFrame implements Runnable{
	private Image frameiconimg;								//������ �̹��� ������
	private ImageIcon Diceimg = new ImageIcon("dice.PNG");	//�ֻ��� �̹���
	private JLabel turnn;									//turn ��Ÿ�� ��
	private JLabel player1label, player2label;				//�÷��̾� ���� ��
	private JLabel player1infom1, player2infom1;			//�÷��̾� �ں� ��
	private String player1money, player2money;				//�÷��̾� �ں� ���ڿ�
	private JLabel player1infom2, player2infom2;			//�÷��̾� �ε��� ��
	private String player1building, player2building;		//�÷��̾� �ε��� ���ڿ�
	private int dicevalueint;								//�ֻ��� ��
	private static InputStream sound;						//����� ���� ��ǲ
	private static AudioStream soundd;						//����� ���� ���
	private JButton Dicebutton;								//�ֻ��� ��ư
	private ImageIcon player1winimg, player2winimg;			//�¸� �̹���
	private JLabel player1win, player2win;					//�¸� �̹��� ���
	private ImageIcon pic, pic2;							//�÷��̾� �̹��� ������
	private JLabel player1img, player2img;					//�÷��̾� �̹��� ��
	
	//���� ���� ����
	land[] DDang;
	start start;
	desertisland desertisland;
	chance chance;
	tax tax;
	tour tour;
	player player1 = new player("player1");
	player player2 = new player("player2");
	JPanel[] p1;
	JPanel[] p;
	Color blue, red;
	turn turn;
	Timer timer;
	TimerTask dotimer, dotimer1,dotimer2;
	Scanner scanner;
	sound ssound;
	

	
	public nboard(){
		//��, ��������, ���ε�, ����, ����û, ���迩�� ��ü����
		DDang = landbuild.getland();
		start = new start("��������",0,false,0,"",0);
		desertisland = new desertisland("���ε�",0,false,0,"",2);
		chance = new chance("",0,false,0,"",5);
		tax = new tax("����û",0,false,0,"",4);
		tour = new tour("���迩��",0,false,0,"",3);
		
		ssound = new sound();				//sound ��ü ����
		
 		turn = new turn();					//�Ϻ��� ��ü ����
 		
		scanner = new Scanner(System.in);	//��ĳ�� ��ü ����
		
		timer = new Timer();				//Ÿ�̸� ��ü ����
		
		//���� ��
		Color[] color = {new Color(255,255,255),new Color(255,255,0),new Color(255,255,0),new Color(255,255,0),
				new Color(255,255,255),new Color(255,255,0),new Color(255,255,0),new Color(255,255,0),
				new Color(255,255,255),new Color(255,255,0),new Color(255,255,0),new Color(255,255,0),
				new Color(255,255,255),new Color(255,255,0),new Color(255,255,0),new Color(255,255,0),
				new Color(255,255,255),new Color(255,255,0),new Color(255,255,0),new Color(255,255,0),
 				new Color(255,255,255),new Color(255,255,0),new Color(255,255,0),new Color(255,255,0),
 				new Color(255,255,255),new Color(255,255,0),new Color(255,255,0),new Color(255,255,0),
 				new Color(255,255,255),new Color(255,255,0),new Color(255,255,0),new Color(255,255,0),
 				new Color(255,255,0),new Color(128,128,128) };
 		
 		Color[] color1 = {new Color(255,255,255),new Color(0,0,0),new Color(255,255,255),new Color(0,0,0),
 				new Color(255,255,255),new Color(00,0,0),new Color(255,255,255),new Color(0,0,0),
 				new Color(255,255,255),new Color(0,0,0),new Color(255,255,255),new Color(00,0,00),
 				new Color(255,255,255),new Color(0,0,00),new Color(255,255,255),new Color(0,0,00),
 				new Color(255,255,255),new Color(0,0,0),new Color(255,255,255),new Color(0,0,0), 
				new Color(255,255,255),new Color(0,0,0),new Color(255,255,255),new Color(0,0,0),
				new Color(255,255,255),new Color(0,0,0),new Color(255,255,255),new Color(0,0,0),
				new Color(255,255,255),new Color(0,0,0),new Color(255,255,255),new Color(0,0,0)};
 		red = new Color(255,0,0);		//�÷��̾�1 ��
 		blue = new Color(0,0,255);		//�÷��̾�2 ��
 		
 		//���� ���� �̸�
 		String[] msg = {"��������", "�ƺδٺ�", "īƮ����", "����", "����1", "�ϳ���", " �ٱ״ٵ�", 
			"����", "���ε�","���׳�", "������", "��ũ��", "����2", "��Ƽĭ", "���帮��", "����", 
			"����û", "�θ�", "����", "������", "����3", "�δ��佺Ʈ", "��Ƽ�ư�", "���׸���", "���迩��", 
			"������", "ĵ����", "����θ�ũ", "����4",  "�ĸ�", "��Ÿ��", "����","1" };
 		JLabel[] l = new JLabel[msg.length];
 		p = new JPanel[33];
 		p1 = new JPanel[32];
 		//���� ����
 		for(int i=0; i<32;i++){
 			p1[i]= new JPanel();
 			p1[i].setBackground(color1[i]);
 			if (i < 9){
 				if (i == 0){
							p1[i].setBounds(0,30,150,120);}
 						else if(i ==8){
							p1[i].setBounds((i*100)+50,30,150,120);}
						else
							p1[i].setBounds(((i*100)+50),30,100,120);}
 			else if (i <17){
 						if(i==16){
 							p1[i].setBounds(850,((i-8)*100)+80,150,120);}
 						else
 							p1[i].setBounds(850,((i-8)*100+75),150,75);} 
 			else if (i<25){
 						if(i==24){
 							p1[i].setBounds(850-(((i-16)*100)+50),880,150,120);}
 						else
 							p1[i].setBounds(850-((i-16)*100),880,100,120);}	 						
			else if (i<33){
					p1[i].setBounds(0,800-(((i-24)*100)-75),150,75);}
 			add(p1[i]);
 		}
 		for(int i=0; i<33;i++){
 			p[i]= new JPanel();
 			l[i] = new JLabel(msg[i]);
 			p[i].setBackground(color[i]);
 			if (i < 9){
 				if (i == 0){
 					p[i].setBounds(0,0,150,150);}
 				else if(i ==8){
 					p[i].setBounds((i*100)+50,0,150,150);}
 				else
 					p[i].setBounds(((i*100)+50),0,100,150);}	 					
 				else if (i <17){
 					if(i==16){
 						p[i].setBounds(850,((i-8)*100)+50,150,150);}
 					else
 						p[i].setBounds(850,((i-8)*100+50),150,100);} 				
 					else if (i<25){
 						if(i==24){
 	 						p[i].setBounds(850-(((i-16)*100)+50),850,150,150);}
 	 					else
 						p[i].setBounds(850-((i-16)*100),850,100,150);}	 						
 					else if (i<33){
 						p[i].setBounds(0,850-((i-24)*100),150,100);}	 						
 				p[i].add(l[i]);
 				add(p[i]);
 		}
 		
 		//player �̹��� ��ü ����
 		pic = new ImageIcon("player1.PNG");
 		Image picc = pic.getImage();
 		Image piccc = picc.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
 		ImageIcon picccc = new ImageIcon(piccc);
 		player1img=new JLabel(picccc);
 		
 		pic2 = new ImageIcon("player2.PNG");
 		Image picc1 = pic2.getImage();
 		Image piccc1 = picc1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
 		ImageIcon picccc1 = new ImageIcon(piccc1);
 		player2img=new JLabel(picccc1);
 		
 		//player win �̹��� ����
 		player1winimg = new ImageIcon("player1win.PNG");
 		player2winimg = new ImageIcon("player2win.PNG");
 		
 		//Dice ��ü d ����
 		Dice d = new Dice();
 		
 		//������� ��� + Ÿ�̸� �̿��Ͽ� �ݺ����
 		dotimer2 = new TimerTask(){
 			@Override
 			public void run() {
 				ssound.bgmsound(sound,soundd);
 			}
 		};
 		timer.scheduleAtFixedRate(dotimer2, 500, 67000);
			
 		//�ֻ��� �̹���(��ư) + �̺�Ʈó��
 		Dicebutton = new JButton(Diceimg);
 		Dicebutton.setBounds(200,500,275,220);
 		Dicebutton.addActionListener(e -> {
 			d.roll();
 			dicevalueint = d.Dicesum();
 			
 			//�ֻ��� ���� ���
 			ssound.dicesound(sound, soundd);
 			
 			//�÷��̾� ����� �ֻ��� ������
 			if(turn.turning()==1 || turn.turning()==0){
 				dotimer = new TimerTask(){
 					@Override
 					public void run() {
 						turnn.setText("������ player2���� �����Դϴ�.");
 		 				player1.move(dicevalueint,player1);
 		 				System.out.println(dicevalueint+" ���Խ��ϴ�."+dicevalueint+"ĭ ����!");
 		 				System.out.println("player1���� "+DDang[player1.getplayerlocation()].getname()+"�� �����ϼ̽��ϴ�.");
 		 				Dicebutton.setEnabled(false);
 		 				check(player1,player2);
 		 				colorland(p);
 		 				Dicebutton.setEnabled(true);
 		 				turn.turnchange1();
 					}
 				};
 				timer.schedule(dotimer,1000);		//Ÿ�̸� ����Ͽ� �ֻ��� Ŭ�� �� 1�� �� ����
 			} else {
 				dotimer1 = new TimerTask(){
 					@Override
 					public void run() {
 						turnn.setText("������ player1���� �����Դϴ�.");
 		 				player2.move(dicevalueint, player2);
 		 				System.out.println(dicevalueint+" ���Խ��ϴ�."+dicevalueint+"ĭ ����!");
 		 				System.out.println("player2���� "+DDang[player2.getplayerlocation()].getname()+"�� �����ϼ̽��ϴ�.");
 		 				Dicebutton.setEnabled(false);
 		 				check(player2,player1);
 		 				colorland(p);
 		 				Dicebutton.setEnabled(true);
 		 				turn.turnchange2();
 					}
 				};
 				timer.schedule(dotimer1,1000);		//Ÿ�̸� ����Ͽ� �ֻ��� Ŭ�� �� 1�� �� ����
 			}
 		});
 		add(Dicebutton);
 		
 		//font ����
 		Font font = new Font("����", Font.BOLD,24);
 		
 		//���� ���
 		turnn = new JLabel("player1���� �����Դϴ�.");
 		turnn.setBounds(480,600,400,30);
 		turnn.setFont(font);
 		add(turnn);
 		
 		//player���� ����(��)
 		player1label = new JLabel("�÷��̾�1"); player1label.setBounds(250,200,150,150); player1label.setFont(font);
 		player2label = new JLabel("�÷��̾�2"); player2label.setBounds(550,200,150,150); player2label.setFont(font);
 		player1infom1 = new JLabel(); player1infom1.setBounds(250,240,200,150); player1infom1.setFont(font);
 		player2infom1 = new JLabel(); player2infom1.setBounds(550,240,200,150); player2infom1.setFont(font);
 		player1infom2 = new JLabel(); player1infom2.setBounds(250,280,200,150); player1infom2.setFont(font);
 		player2infom2 = new JLabel(); player2infom2.setBounds(550,280,200,150); player2infom2.setFont(font);
 		add(player1label);  add(player2label);
 		add(player1infom1); add(player2infom1);
 		add(player1infom2); add(player2infom2);
 		
 		add(new JLabel());							//�÷��̾�2�� �ε��� ���� �������ʴ� ���� �ذ��� ���� �����
 		readimage();								
 		setLayout(null);							//������ġ ���
 		setSize(1000,1000);							//������ ũ��
 		setDefaultCloseOperation(EXIT_ON_CLOSE);	//���� ��ư
 		setTitle("�η縶��");							//������ �̸�
	 	setIconImage(frameiconimg);					//������ ������ ����
	 	setResizable(false);						//������ ũ������ �Ұ�									
	 	setVisible(true);							//ȭ�鿡 ���
 	}
	
	//������ ������ �̹��� ���� �б�
		private void readimage() {
			Toolkit kit = Toolkit.getDefaultToolkit();
			frameiconimg = kit.getImage("frameicon.PNG");
		}
		
	//������ ���
		public void run() {
			while(true){
				try {
					Thread.sleep(50);
				}
					catch(InterruptedException e) {
						return;
					}//�÷��̾� ���� ����
					player1money = Integer.toString((int)player1.getplayermoney());
					player1infom1.setText("�ں� : "+player1money);
					player2money = Integer.toString((int)player2.getplayermoney());
					player2infom1.setText("�ں� : "+player2money);
					player1building = Integer.toString((int)player1.getplayerbuilding());
					player1infom2.setText("�ε��� : "+player1building);
					player2building = Integer.toString((int)player2.getplayerbuilding());
					player2infom2.setText("�ε��� : "+player2building);
					//�÷��̾� �̹��� ����
					p1[player1.getplayerlocation()].add(player1img);
					p1[player2.getplayerlocation()].add(player2img);
					//�ٽ� ����ֱ�
					repaint();
					//������������ player2 �¸�
					if(player1.getplayermoney()<0){
						System.out.println("player1���� �Ļ��ϼ̽��ϴ�.");
						System.out.println("player2���� �¸�!");
						player2win = new JLabel(player2winimg);
						add(player2win); player2win.setBounds(150,400,700,400);
						ssound.winnersound(sound, soundd);	//�¸� ���� ���
						Dicebutton.setEnabled(false);		//�ֻ��� ��ư ��Ȱ��ȭ
						Dicebutton.setVisible(false);		//�ֻ��� ��ư �������ʰ�
						turnn.setVisible(false);			//�� �� �������ʰ�
						break;
					}else if(player2.getplayermoney()<0){
						System.out.println("player2���� �Ļ��ϼ̽��ϴ�.");
						System.out.println("player1���� �¸�!");
						player1win = new JLabel(player1winimg);
						add(player1win); player1win.setBounds(150,400,700,400);
						ssound.winnersound(sound, soundd);	//�¸� ���� ���
						Dicebutton.setEnabled(false);		//�ֻ��� ��ư ��Ȱ��ȭ
						Dicebutton.setVisible(false);		//�ֻ��� ��ư �������ʰ�
						turnn.setVisible(false);			//�� �� �������ʰ�
						break;
					} 
				}
		}
		//�÷��̾ ������ �� �� ���� �޼ҵ�
		public void colorland(JPanel p[]){
			for(int col=0; col<32; col++){
				if(DDang[col].getlandlord().equals("player1")){
					p[col].setBackground(red);
				}
				if(DDang[col].getlandlord().equals("player2")){
					p[col].setBackground(blue);
				}
			}
		}
		//�÷��̾��� ��ġ�� ���� ó�� �޼ҵ�
		public void check(player player, player player1){
			switch(DDang[player.getplayerlocation()].getcheck()){
			case 0: { start.startbouse(player); ssound.yessound(sound, soundd);break;}
			case 1: { buyland(player, player1); break;}
			case 2:	{ desertisland.desert(player, turn); ssound.noosound(sound,soundd); break;}
			case 3:	{ tour.worldtour(player, DDang); ssound.yessound(sound, soundd);
					incheck(player, player1); break;}
			case 4:	{ tax.taximpose(player); ssound.noosound(sound,soundd); break;}
			case 5:	{ chance.Yeahchance(player);
						if(chance.getrandomvalue()==0){ssound.yessound(sound, soundd);break;};
						if(chance.getrandomvalue()==3){ssound.yessound(sound, soundd); 
						incheck(player, player1);incheck(player, player1); break;};
						if(chance.getrandomvalue()==2){ssound.noosound(sound,soundd); break;};
						if(chance.getrandomvalue()==1){incheck(player, player1); ssound.noosound(sound,soundd); 
						break;};
					}
			}
		}
		
		//����, ���迩�� �̺�Ʈ ó�� �޼ҵ�
		public void incheck(player player, player player1){
			switch(DDang[player.getplayerlocation()].getcheck()){
			case 0: { start.startbouse(player); ssound.yessound(sound, soundd);break;}
			case 1: { buyland(player, player1);break;}
			case 2:	{ desertisland.desert(player, turn); ssound.noosound(sound,soundd);break;}
			case 3:	{ tour.worldtour(player, DDang);break;}
			case 4:	{ tax.taximpose(player); ssound.noosound(sound,soundd);break;}
			case 5:	{ chance.Yeahchance(player);break;}
			}
		}
		
		//�ε��� �޼ҵ�
		public void buyland(player player, player player1) {
			while(true) {
				if(DDang[player.getplayerlocation()].getcanbuyland()==false){
					if(player.getplayername()!=DDang[player.getplayerlocation()].getlandlord()){
						System.out.println("���� ���Դϴ�. ����� ����! "+DDang[player.getplayerlocation()].gettoll()+"��");
						player.setplayermoney(DDang[player.getplayerlocation()].gettoll());
						player1.setplayermoneytoll(DDang[player.getplayerlocation()].gettoll());
						ssound.opposeDDangsound(sound, soundd);
						}
					break;
				}
				if(DDang[player.getplayerlocation()].getprice() > player.getplayermoney()) {
					System.out.println("���� �����ؿ�");
					break;
				}
				else {
					while(true){
						System.out.println("���� ��ðڽ��ϱ�? �Է� : yes or no");
						System.out.print("���� : "+DDang[player.getplayerlocation()].getprice()+"   ");
						System.out.println("����� : "+DDang[player.getplayerlocation()].gettoll());
						String decision = scanner.next();
						if (decision.equals("yes")) {
							System.out.println(DDang[player.getplayerlocation()].getname()+" ���� �Ϸ�");
							DDang[player.getplayerlocation()].setlandlord(player.getplayername());
							DDang[player.getplayerlocation()].setcanbuyland(false);
							player.setplayermoney(DDang[player.getplayerlocation()].getprice());
							player.setplayerbuilding();
							ssound.DDangsound(sound, soundd);
							break;
						}else if (decision.equals("no")) {
							System.out.println("�н�");
							break;
						}else{
							System.out.println("�ٽ� �Է����ּ���.");
						}
					}
					break;
				}
			}
		}
}
//winner sound : http://freesound.org/people/Podsburgh/sounds/370743/
//yes sound : http://freesound.org/people/Artmasterrich/sounds/345422/
//noo sound : http://freesound.org/people/Kloudkicker1/sounds/234907/
//opposeDDang sound : http://freesound.org/people/fins/sounds/171672/
//bgm sound : https://www.freesound.org/people/FoolBoyMedia/sounds/347848/
//DDang sound : https://www.freesound.org/people/rhodesmas/sounds/320887/
//dice sound : https://www.freesound.org/people/Kastenfrosch/sounds/162456/
//dice �̹���  : Created by Les Kleuver from Noun Project
//men �̹��� : Created by Vladmir Belochkin from Noun Project