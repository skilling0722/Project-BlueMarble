public class landbuild {
	public static land[] getland() {
		land[] DDang = new land[32];
		
		DDang[0] = new start("��������",0, false, 0,"", 0);
		DDang[1] = new land("�ƺδٺ�",10000, true, 5000,"",1);
		DDang[2] = new land("īƮ����",11000, true, 6000,"",1);
		DDang[3] = new land("����",12000, true, 7000,"",1);
		DDang[4] = new chance("����1",0, false, 0,"",5);
		DDang[5] = new land("�ϳ���",13000, true, 9000,"",1);
		DDang[6] = new land("���״ٵ�",14000,true, 10000,"",1);
		DDang[7] = new land("����",15000,true, 11000,"",1);
		DDang[8] = new desertisland("���ε�",0,false, 0,"",2);
		DDang[9] = new land("���׳�",16000,true, 12000,"",1);
		DDang[10] = new land("������",17000,true, 13000,"",1);
		DDang[11] = new land("��ũ��",18000,true, 14000,"",1);
		DDang[12] = new chance("����2",0,false, 0,"",5);
		DDang[13] = new land("��Ƽĭ",19000,true, 15000,"",1);
		DDang[14] = new land("���帮��",20000,true, 16000,"",1);
		DDang[15] = new land("����",23000,true, 17000,"",1);
		DDang[16] = new tax("����û",0,false, 0,"",4);
		DDang[17] = new land("�θ�",25000,true, 17500,"",1);
		DDang[18] = new land("����",30000,true, 18000,"",1);
		DDang[19] = new land("������",35000,true, 18500,"",1);
		DDang[20] = new chance("����3",0,false, 0,"",5);
		DDang[21] = new land("�δ��佺Ʈ",40000,true, 19000,"",1);
		DDang[22] = new land("��Ƽ�ư�",45000,true, 19500,"",1);
		DDang[23] = new land("���׸���",50000,true, 20000,"",1);
		DDang[24] = new tour("���迩��",0,false, 0,"",3);
		DDang[25] = new land("������",60000,true, 23000,"",1);
		DDang[26] = new land("ĵ����",70000,true, 25000,"",1);
		DDang[27] = new land("����θ�ũ",80000,true, 30000,"",1);
		DDang[28] = new chance("����4",0,false, 0,"",5);
		DDang[29] = new land("�ĸ�",100000,true, 40000,"",1);
		DDang[30] = new land("��Ÿ��",120000,true, 50000,"",1);
		DDang[31] = new land("����",150000,true, 70000,"",1);
		
		return DDang;
	}
}
