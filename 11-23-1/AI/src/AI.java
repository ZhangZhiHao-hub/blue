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
	int heroX,heroY;int flag;

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
			heroX=120;heroY=100;flag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);//120：X坐标、100：Y坐标
	}
	//抽取方法
	public void Movehero(int dir){
		if(flag==1){
			currentImg=allImg[dir][0];
			flag++;
		}
		else if(flag==2){
			currentImg=allImg[dir][2];
			flag=1;
		}
		repaint();
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			Movehero(1);
			heroX=heroX-1;
		}
		if(action==RIGHT){
			Movehero(3);
			heroX=heroX+1;
		}
		if(action==UP){
			Movehero(2);
			heroY=heroY-1;
		}
		if(action==DOWN){
			Movehero(0);
			heroY=heroY+1;
		}
	}
}