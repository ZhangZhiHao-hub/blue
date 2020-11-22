import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

	/*
	����������
	�﷨���������� �������ƣ���ʶ����;
	*/
	int x,y;int down,up,left,right;

	Image currentImg;
	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];
	Image allImg[][]=new Image[4][3];
	public MainCanvas(){
		try
		{
			/*
			��������ֵ
			�﷨����������=value;
			*/
			//��ά����
			for(int i=0;i<allImg.length;i++){
				for(int j=0;j<allImg[i].length;j++){
					allImg[i][j]=Image.createImage("/sayo"+j+i*2+".png");
				}
			}
			//��
			for(int i=0;i<heroDownImg.length;i++){
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			}
			/*
			downImg=Image.createImage("/sayo10.png");
			downImg1=Image.createImage("/sayo20.png");
			downImg2=Image.createImage("/sayo00.png");
			*/

			//��
			for(int i=0;i<heroLeftImg.length;i++){
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			}
			/*
			leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo22.png");
			leftImg2=Image.createImage("/sayo02.png");
			*/

			//��
			for(int i=0;i<heroUpImg.length;i++){
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			}
			/*
			upImg=Image.createImage("/sayo14.png");
			upImg1=Image.createImage("/sayo24.png");
			upImg2=Image.createImage("/sayo04.png");
			*/

			//��
			for(int i=0;i<heroRightImg.length;i++){
				heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
			}
			/*
			rightImg=Image.createImage("/sayo16.png");
			rightImg1=Image.createImage("/sayo26.png");
			rightImg2=Image.createImage("/sayo06.png");
			*/

			currentImg=heroDownImg[1];
			x=120;y=100;left=1;right=1;up=1;down=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120��X���ꡢ100��Y����
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/
		if(action==LEFT){
			if(left==1){
				currentImg=allImg[1][0];
				left++;
			}
			else if(left==2){
				currentImg=allImg[1][2];
				left=1;
			}
			x=x-1;
			repaint();
		}
		if(action==RIGHT){
			if(right==1){
				currentImg=allImg[3][0];
				right++;
			}
			else if(right==2){
				currentImg=allImg[3][2];
				right=1;
			}
			x=x+1;
			repaint();
		}
		if(action==UP){
			if(up==1){
				currentImg=allImg[2][0];
				up++;
			}
			else if(up==2){
				currentImg=allImg[2][2];
				up=1;
			}
			y=y-1;
			repaint();
		}
		if(action==DOWN){
			if(down==1){
				currentImg=allImg[0][0];
				down++;
			}
			else if(down==2){
				currentImg=allImg[0][2];
				down=1;
			}
			y=y+1;
			repaint();
		}
	}
}