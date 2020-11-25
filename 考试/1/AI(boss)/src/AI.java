import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;

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
class MainCanvas extends Canvas implements Runnable
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	Thread thread;
	int heroX,heroY,bossX,bossY;
	int flag;
	Image heroImg[][]=new Image[4][3];
	Image bossImg;
	//4个方向、每个方向3张图片，0表示left、1表示right、2表示up、3表示down
	/*
	规则二维数组
	*/
	Random rd=new Random();
	Image currentImg;

	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			bossImg=Image.createImage("/zuzu000.png");
			currentImg=heroImg[3][1];
			heroX=120;
			heroY=100;

			bossX=0;
			bossY=0;

			flag=1;
			
			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	/*
	在多线程里写一个死循环，不停的比较boss和hero的坐标
	*/
	public void run(){
		while(true){
			int rdNumber=rd.nextInt(10);
			
			try
			{
				Thread.sleep(200);//FPS：屏幕刷新率
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(rdNumber%3==0){
				if(bossX<heroX){
					bossX++;
				}
				else{
					bossX--;
				}

				if(bossY<heroY){
					bossY++;
				}else{
					bossY--;
				}
			}
			repaint();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);//设置背景色
		g.fillRect(0,0,getWidth(),getHeight());//填充矩形（以上面设置的颜色填充）
		g.drawImage(currentImg,heroX,heroY,0);//120：X坐标、100：Y坐标，把一个图片显示在屏幕上
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			changePicAndDirection(0);
			heroX=heroX-1;
		}
		if(action==UP){
			changePicAndDirection(2);
			heroY=heroY-1;
		}
		if(action==RIGHT){
			changePicAndDirection(1);
			heroX=heroX+1;
		}
		if(action==DOWN){
			changePicAndDirection(3);
			heroY=heroY+1;
		}
	}
	void changePicAndDirection(int direction){
		if(flag==1){
			currentImg=heroImg[direction][0];
			flag++;
		}
		else if(flag==2){
			currentImg=heroImg[direction][2];
			flag=1;
		}
	}
}