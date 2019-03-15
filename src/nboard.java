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
	private Image frameiconimg;								//프레임 이미지 아이콘
	private ImageIcon Diceimg = new ImageIcon("dice.PNG");	//주사위 이미지
	private JLabel turnn;									//turn 나타낼 라벨
	private JLabel player1label, player2label;				//플레이어 정보 라벨
	private JLabel player1infom1, player2infom1;			//플레이어 자본 라벨
	private String player1money, player2money;				//플레이어 자본 문자열
	private JLabel player1infom2, player2infom2;			//플레이어 부동산 라벨
	private String player1building, player2building;		//플레이어 부동산 문자열
	private int dicevalueint;								//주사위 값
	private static InputStream sound;						//오디오 파일 인풋
	private static AudioStream soundd;						//오디오 파일 재생
	private JButton Dicebutton;								//주사위 버튼
	private ImageIcon player1winimg, player2winimg;			//승리 이미지
	private JLabel player1win, player2win;					//승리 이미지 출력
	private ImageIcon pic, pic2;							//플레이어 이미지 아이콘
	private JLabel player1img, player2img;					//플레이어 이미지 라벨
	
	//참조 변수 선언
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
		//땅, 시작지점, 무인도, 찬스, 국세청, 세계여행 객체생성
		DDang = landbuild.getland();
		start = new start("시작지점",0,false,0,"",0);
		desertisland = new desertisland("무인도",0,false,0,"",2);
		chance = new chance("",0,false,0,"",5);
		tax = new tax("국세청",0,false,0,"",4);
		tour = new tour("세계여행",0,false,0,"",3);
		
		ssound = new sound();				//sound 객체 생성
		
 		turn = new turn();					//턴변경 객체 생성
 		
		scanner = new Scanner(System.in);	//스캐너 객체 생성
		
		timer = new Timer();				//타이머 객체 생성
		
		//보드 색
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
 		red = new Color(255,0,0);		//플레이어1 색
 		blue = new Color(0,0,255);		//플레이어2 색
 		
 		//보드 도시 이름
 		String[] msg = {"시작지점", "아부다비", "카트만두", "말레", "찬스1", "하노이", " 바그다드", 
			"방콕", "무인도","아테네", "베를린", "모스크바", "찬스2", "바티칸", "마드리드", "모나코", 
			"국세청", "로마", "런던", "프리하", "찬스3", "부다페스트", "산티아고", "과테말라", "세계여행", 
			"웰링턴", "캔버라", "룩셈부르크", "찬스4",  "파리", "오타와", "서울","1" };
 		JLabel[] l = new JLabel[msg.length];
 		p = new JPanel[33];
 		p1 = new JPanel[32];
 		//보드 생성
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
 		
 		//player 이미지 객체 생성
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
 		
 		//player win 이미지 생성
 		player1winimg = new ImageIcon("player1win.PNG");
 		player2winimg = new ImageIcon("player2win.PNG");
 		
 		//Dice 객체 d 생성
 		Dice d = new Dice();
 		
 		//배경음악 재생 + 타이머 이용하여 반복재생
 		dotimer2 = new TimerTask(){
 			@Override
 			public void run() {
 				ssound.bgmsound(sound,soundd);
 			}
 		};
 		timer.scheduleAtFixedRate(dotimer2, 500, 67000);
			
 		//주사위 이미지(버튼) + 이벤트처리
 		Dicebutton = new JButton(Diceimg);
 		Dicebutton.setBounds(200,500,275,220);
 		Dicebutton.addActionListener(e -> {
 			d.roll();
 			dicevalueint = d.Dicesum();
 			
 			//주사위 사운드 재생
 			ssound.dicesound(sound, soundd);
 			
 			//플레이어 교대로 주사위 던지기
 			if(turn.turning()==1 || turn.turning()==0){
 				dotimer = new TimerTask(){
 					@Override
 					public void run() {
 						turnn.setText("다음은 player2님의 차례입니다.");
 		 				player1.move(dicevalueint,player1);
 		 				System.out.println(dicevalueint+" 나왔습니다."+dicevalueint+"칸 전진!");
 		 				System.out.println("player1님이 "+DDang[player1.getplayerlocation()].getname()+"에 도착하셨습니다.");
 		 				Dicebutton.setEnabled(false);
 		 				check(player1,player2);
 		 				colorland(p);
 		 				Dicebutton.setEnabled(true);
 		 				turn.turnchange1();
 					}
 				};
 				timer.schedule(dotimer,1000);		//타이머 사용하여 주사위 클릭 후 1초 뒤 실행
 			} else {
 				dotimer1 = new TimerTask(){
 					@Override
 					public void run() {
 						turnn.setText("다음은 player1님의 차례입니다.");
 		 				player2.move(dicevalueint, player2);
 		 				System.out.println(dicevalueint+" 나왔습니다."+dicevalueint+"칸 전진!");
 		 				System.out.println("player2님이 "+DDang[player2.getplayerlocation()].getname()+"에 도착하셨습니다.");
 		 				Dicebutton.setEnabled(false);
 		 				check(player2,player1);
 		 				colorland(p);
 		 				Dicebutton.setEnabled(true);
 		 				turn.turnchange2();
 					}
 				};
 				timer.schedule(dotimer1,1000);		//타이머 사용하여 주사위 클릭 후 1초 뒤 실행
 			}
 		});
 		add(Dicebutton);
 		
 		//font 설정
 		Font font = new Font("굴림", Font.BOLD,24);
 		
 		//차례 출력
 		turnn = new JLabel("player1님의 차례입니다.");
 		turnn.setBounds(480,600,400,30);
 		turnn.setFont(font);
 		add(turnn);
 		
 		//player들의 정보(라벨)
 		player1label = new JLabel("플레이어1"); player1label.setBounds(250,200,150,150); player1label.setFont(font);
 		player2label = new JLabel("플레이어2"); player2label.setBounds(550,200,150,150); player2label.setFont(font);
 		player1infom1 = new JLabel(); player1infom1.setBounds(250,240,200,150); player1infom1.setFont(font);
 		player2infom1 = new JLabel(); player2infom1.setBounds(550,240,200,150); player2infom1.setFont(font);
 		player1infom2 = new JLabel(); player1infom2.setBounds(250,280,200,150); player1infom2.setFont(font);
 		player2infom2 = new JLabel(); player2infom2.setBounds(550,280,200,150); player2infom2.setFont(font);
 		add(player1label);  add(player2label);
 		add(player1infom1); add(player2infom1);
 		add(player1infom2); add(player2infom2);
 		
 		add(new JLabel());							//플레이어2의 부동산 라벨이 보이지않는 문제 해결을 위한 공백라벨
 		readimage();								
 		setLayout(null);							//절대위치 사용
 		setSize(1000,1000);							//프레임 크기
 		setDefaultCloseOperation(EXIT_ON_CLOSE);	//종료 버튼
 		setTitle("부루마블");							//프레임 이름
	 	setIconImage(frameiconimg);					//프레임 아이콘 설정
	 	setResizable(false);						//프레임 크기조절 불가									
	 	setVisible(true);							//화면에 출력
 	}
	
	//프레임 아이콘 이미지 파일 읽기
		private void readimage() {
			Toolkit kit = Toolkit.getDefaultToolkit();
			frameiconimg = kit.getImage("frameicon.PNG");
		}
		
	//스레드 사용
		public void run() {
			while(true){
				try {
					Thread.sleep(50);
				}
					catch(InterruptedException e) {
						return;
					}//플레이어 정보 갱신
					player1money = Integer.toString((int)player1.getplayermoney());
					player1infom1.setText("자본 : "+player1money);
					player2money = Integer.toString((int)player2.getplayermoney());
					player2infom1.setText("자본 : "+player2money);
					player1building = Integer.toString((int)player1.getplayerbuilding());
					player1infom2.setText("부동산 : "+player1building);
					player2building = Integer.toString((int)player2.getplayerbuilding());
					player2infom2.setText("부동산 : "+player2building);
					//플레이어 이미지 갱신
					p1[player1.getplayerlocation()].add(player1img);
					p1[player2.getplayerlocation()].add(player2img);
					//다시 찍어주기
					repaint();
					//게임종료조건 player2 승리
					if(player1.getplayermoney()<0){
						System.out.println("player1님이 파산하셨습니다.");
						System.out.println("player2님의 승리!");
						player2win = new JLabel(player2winimg);
						add(player2win); player2win.setBounds(150,400,700,400);
						ssound.winnersound(sound, soundd);	//승리 사운드 재생
						Dicebutton.setEnabled(false);		//주사위 버튼 비활성화
						Dicebutton.setVisible(false);		//주사위 버튼 보이지않게
						turnn.setVisible(false);			//턴 라벨 보이지않게
						break;
					}else if(player2.getplayermoney()<0){
						System.out.println("player2님이 파산하셨습니다.");
						System.out.println("player1님의 승리!");
						player1win = new JLabel(player1winimg);
						add(player1win); player1win.setBounds(150,400,700,400);
						ssound.winnersound(sound, soundd);	//승리 사운드 재생
						Dicebutton.setEnabled(false);		//주사위 버튼 비활성화
						Dicebutton.setVisible(false);		//주사위 버튼 보이지않게
						turnn.setVisible(false);			//턴 라벨 보이지않게
						break;
					} 
				}
		}
		//플레이어가 소유한 땅 색 변경 메소드
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
		//플레이어의 위치에 따른 처리 메소드
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
		
		//찬스, 세계여행 이벤트 처리 메소드
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
		
		//부동산 메소드
		public void buyland(player player, player player1) {
			while(true) {
				if(DDang[player.getplayerlocation()].getcanbuyland()==false){
					if(player.getplayername()!=DDang[player.getplayerlocation()].getlandlord()){
						System.out.println("남의 땅입니다. 통행료 지불! "+DDang[player.getplayerlocation()].gettoll()+"원");
						player.setplayermoney(DDang[player.getplayerlocation()].gettoll());
						player1.setplayermoneytoll(DDang[player.getplayerlocation()].gettoll());
						ssound.opposeDDangsound(sound, soundd);
						}
					break;
				}
				if(DDang[player.getplayerlocation()].getprice() > player.getplayermoney()) {
					System.out.println("돈이 부족해요");
					break;
				}
				else {
					while(true){
						System.out.println("땅을 사시겠습니까? 입력 : yes or no");
						System.out.print("가격 : "+DDang[player.getplayerlocation()].getprice()+"   ");
						System.out.println("통행료 : "+DDang[player.getplayerlocation()].gettoll());
						String decision = scanner.next();
						if (decision.equals("yes")) {
							System.out.println(DDang[player.getplayerlocation()].getname()+" 구매 완료");
							DDang[player.getplayerlocation()].setlandlord(player.getplayername());
							DDang[player.getplayerlocation()].setcanbuyland(false);
							player.setplayermoney(DDang[player.getplayerlocation()].getprice());
							player.setplayerbuilding();
							ssound.DDangsound(sound, soundd);
							break;
						}else if (decision.equals("no")) {
							System.out.println("패스");
							break;
						}else{
							System.out.println("다시 입력해주세요.");
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
//dice 이미지  : Created by Les Kleuver from Noun Project
//men 이미지 : Created by Vladmir Belochkin from Noun Project