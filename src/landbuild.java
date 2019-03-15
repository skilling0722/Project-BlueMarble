public class landbuild {
	public static land[] getland() {
		land[] DDang = new land[32];
		
		DDang[0] = new start("시작지점",0, false, 0,"", 0);
		DDang[1] = new land("아부다비",10000, true, 5000,"",1);
		DDang[2] = new land("카트만두",11000, true, 6000,"",1);
		DDang[3] = new land("말레",12000, true, 7000,"",1);
		DDang[4] = new chance("찬스1",0, false, 0,"",5);
		DDang[5] = new land("하노이",13000, true, 9000,"",1);
		DDang[6] = new land("마그다드",14000,true, 10000,"",1);
		DDang[7] = new land("방콕",15000,true, 11000,"",1);
		DDang[8] = new desertisland("무인도",0,false, 0,"",2);
		DDang[9] = new land("아테네",16000,true, 12000,"",1);
		DDang[10] = new land("베를린",17000,true, 13000,"",1);
		DDang[11] = new land("모스크바",18000,true, 14000,"",1);
		DDang[12] = new chance("찬스2",0,false, 0,"",5);
		DDang[13] = new land("바티칸",19000,true, 15000,"",1);
		DDang[14] = new land("마드리드",20000,true, 16000,"",1);
		DDang[15] = new land("모나코",23000,true, 17000,"",1);
		DDang[16] = new tax("국세청",0,false, 0,"",4);
		DDang[17] = new land("로마",25000,true, 17500,"",1);
		DDang[18] = new land("런던",30000,true, 18000,"",1);
		DDang[19] = new land("프라하",35000,true, 18500,"",1);
		DDang[20] = new chance("찬스3",0,false, 0,"",5);
		DDang[21] = new land("부다페스트",40000,true, 19000,"",1);
		DDang[22] = new land("산티아고",45000,true, 19500,"",1);
		DDang[23] = new land("과테말라",50000,true, 20000,"",1);
		DDang[24] = new tour("세계여행",0,false, 0,"",3);
		DDang[25] = new land("웰링턴",60000,true, 23000,"",1);
		DDang[26] = new land("캔버라",70000,true, 25000,"",1);
		DDang[27] = new land("룩셈부르크",80000,true, 30000,"",1);
		DDang[28] = new chance("찬스4",0,false, 0,"",5);
		DDang[29] = new land("파리",100000,true, 40000,"",1);
		DDang[30] = new land("오타와",120000,true, 50000,"",1);
		DDang[31] = new land("서울",150000,true, 70000,"",1);
		
		return DDang;
	}
}
