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
	Image downImg,downImg1,downImg2,leftImg,leftImg1,leftImg2,rightImg,rightImg1,rightImg2,upImg,upImg1,upImg2,currentImg;
	int x,cx,y,cy;int down,up,left,right;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			downImg=Image.createImage("/sayo10.png");
			downImg1=Image.createImage("/sayo20.png");
			downImg2=Image.createImage("/sayo00.png");

			leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo22.png");
			leftImg2=Image.createImage("/sayo02.png");

			rightImg=Image.createImage("/sayo16.png");
			rightImg1=Image.createImage("/sayo26.png");
			rightImg2=Image.createImage("/sayo06.png");

			upImg=Image.createImage("/sayo14.png");
			upImg1=Image.createImage("/sayo24.png");
			upImg2=Image.createImage("/sayo04.png");

			currentImg=downImg;
			cx=120;cy=100;x=120;y=100;left=0;right=0;up=0;down=0;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,cx,cy,0);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			switch(left){
				case 0:currentImg=leftImg;break;
				case 1:currentImg=leftImg1;break;
				case 2:currentImg=leftImg2;break;
				default:break;
			}
			left=left+1;
			if(left==3){
				left=0;
			}
			x=x-1;cx=x;
		}
		else if(action==RIGHT){
			currentImg=rightImg;
		}
		else if(action==UP){
			currentImg=upImg;
		}
		else if(action==DOWN){
			currentImg=downImg;
		}
		repaint();
	}
}