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
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int x,y;int down,up,left,right;

	Image currentImg;
	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];

	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			//下
			for(int i=0;i<heroDownImg.length;i++){
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			}
			/*
			downImg=Image.createImage("/sayo10.png");
			downImg1=Image.createImage("/sayo20.png");
			downImg2=Image.createImage("/sayo00.png");
			*/

			//左
			for(int i=0;i<heroLeftImg.length;i++){
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			}
			/*
			leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo22.png");
			leftImg2=Image.createImage("/sayo02.png");
			*/

			//右
			for(int i=0;i<heroRightImg.length;i++){
				heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
			}
			/*
			rightImg=Image.createImage("/sayo16.png");
			rightImg1=Image.createImage("/sayo26.png");
			rightImg2=Image.createImage("/sayo06.png");
			*/

			//上
			for(int i=0;i<heroUpImg.length;i++){
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			}
			/*
			upImg=Image.createImage("/sayo14.png");
			upImg1=Image.createImage("/sayo24.png");
			upImg2=Image.createImage("/sayo04.png");
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
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			if(left==1){
				currentImg=heroLeftImg[0];
				left++;
			}
			else if(left==2){
				currentImg=heroLeftImg[2];
				left=1;
			}
			x=x-1;
			repaint();
		}
		if(action==RIGHT){
			if(right==1){
				currentImg=heroRightImg[0];
				right++;
			}
			else if(right==2){
				currentImg=heroRightImg[2];
				right=1;
			}
			x=x+1;
			repaint();
		}
		if(action==UP){
			if(up==1){
				currentImg=heroUpImg[0];
				up++;
			}
			else if(up==2){
				currentImg=heroUpImg[2];
				up=1;
			}
			y=y-1;
			repaint();
		}
		if(action==DOWN){
			if(down==1){
				currentImg=heroDownImg[0];
				down++;
			}
			else if(down==2){
				currentImg=heroDownImg[2];
				down=1;
			}
			y=y+1;
			repaint();
		}
	}
}