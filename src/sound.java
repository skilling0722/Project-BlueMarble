import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.*;
@SuppressWarnings("restriction")
public class sound {

	//�ֻ��� ���� ���
	public void dicesound(InputStream sound, AudioStream soundd){
		try {
				sound = new FileInputStream("dicesound.wav");
				soundd = new AudioStream(sound);
				
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}
			AudioPlayer.player.start(soundd);
	}
	//������� ���
	public void bgmsound(InputStream sound, AudioStream soundd){
		try {
			sound = new FileInputStream("bgm.wav");
			soundd = new AudioStream(sound);
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}AudioPlayer.player.start(soundd);
	}
	//�¸����� �޼��� ���
	public void winnersound(InputStream sound, AudioStream soundd){
		try {
			sound = new FileInputStream("winnersound.wav");
			soundd = new AudioStream(sound);
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}AudioPlayer.player.start(soundd);
	}
	//�� ���Ž� ���
	public void DDangsound(InputStream sound, AudioStream soundd){
		try {
			sound = new FileInputStream("DDangsound.wav");
			soundd = new AudioStream(sound);
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}AudioPlayer.player.start(soundd);
	}
	//���� �� ������ ���
	public void opposeDDangsound(InputStream sound, AudioStream soundd){
		try {
			sound = new FileInputStream("opposeDDang.wav");
			soundd = new AudioStream(sound);
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}AudioPlayer.player.start(soundd);
	}
	//����û, ���� �� �߻��� ���
	public void noosound(InputStream sound, AudioStream soundd){
		try {
			sound = new FileInputStream("noosound.wav");
			soundd = new AudioStream(sound);
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}AudioPlayer.player.start(soundd);
	}
	//����, �������� �� �߻��� ���
	public void yessound(InputStream sound, AudioStream soundd){
		try {
			sound = new FileInputStream("yessound.wav");
			soundd = new AudioStream(sound);
	 		} catch (IOException e1) {
				e1.printStackTrace();
			}AudioPlayer.player.start(soundd);
	}

}
