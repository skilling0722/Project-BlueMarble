import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.*;
@SuppressWarnings("restriction")
public class sound {

	//주사위 사운드 재생
	public void dicesound(InputStream sound, AudioStream soundd){
		try {
				sound = new FileInputStream("dicesound.wav");
				soundd = new AudioStream(sound);
				
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}
			AudioPlayer.player.start(soundd);
	}
	//배경음악 재생
	public void bgmsound(InputStream sound, AudioStream soundd){
		try {
			sound = new FileInputStream("bgm.wav");
			soundd = new AudioStream(sound);
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}AudioPlayer.player.start(soundd);
	}
	//승리조건 달성시 재생
	public void winnersound(InputStream sound, AudioStream soundd){
		try {
			sound = new FileInputStream("winnersound.wav");
			soundd = new AudioStream(sound);
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}AudioPlayer.player.start(soundd);
	}
	//땅 구매시 재생
	public void DDangsound(InputStream sound, AudioStream soundd){
		try {
			sound = new FileInputStream("DDangsound.wav");
			soundd = new AudioStream(sound);
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}AudioPlayer.player.start(soundd);
	}
	//상대방 땅 밟을시 재생
	public void opposeDDangsound(InputStream sound, AudioStream soundd){
		try {
			sound = new FileInputStream("opposeDDang.wav");
			soundd = new AudioStream(sound);
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}AudioPlayer.player.start(soundd);
	}
	//국세청, 벌금 등 발생시 재생
	public void noosound(InputStream sound, AudioStream soundd){
		try {
			sound = new FileInputStream("noosound.wav");
			soundd = new AudioStream(sound);
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}AudioPlayer.player.start(soundd);
	}
	//복권, 시작지점 등 발생시 재생
	public void yessound(InputStream sound, AudioStream soundd){
		try {
			sound = new FileInputStream("yessound.wav");
			soundd = new AudioStream(sound);
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}AudioPlayer.player.start(soundd);
	}

}
