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

	Image allImg[][]=new Image[4][3];
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			//二维数组
			for(int i=0;i<allImg.length;i++){
				for(int j=0;j<allImg[i].length;j++){
					allImg[i][j]=Image.createImage("/sayo"+j+i*2+".png");
				}
			}


			currentImg=allImg[0][1];
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