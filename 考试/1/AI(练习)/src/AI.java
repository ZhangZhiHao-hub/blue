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
	Image[][] hero=new Image[4][3];

	Image currentImg;
	int heroX,heroY,flag;
	public MainCanvas(){
		try{
			for(int i=0;i<hero.length;i++){
				for(int j=0;j<hero[i].length;j++){
						hero[i][j]=Image.createImage("/sayo"+i+j+".png");
				}				
			}
			currentImg=hero[3][0];
			heroX=120;heroY=100;flag=1;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
	}
	//³éÈ¡·½·¨
	public void moveHeroAndTurn(int action){
		switch(action){
			case LEFT:
				currentImg=hero[0][0];heroX--;if(flag==1){currentImg=hero[0][1];flag++;}else if(flag==2){currentImg=hero[0][2];flag--;}
				break;
			case RIGHT:
				currentImg=hero[1][0];heroX++;if(flag==1){currentImg=hero[1][1];flag++;}else if(flag==2){currentImg=hero[1][2];flag--;}
				break;
			case UP:
				currentImg=hero[2][0];heroY--;if(flag==1){currentImg=hero[2][1];flag++;}else if(flag==2){currentImg=hero[2][2];flag--;}
				break;
			case DOWN:
				currentImg=hero[3][0];heroY++;if(flag==1){currentImg=hero[3][1];flag++;}else if(flag==2){currentImg=hero[3][2];flag--;}
				break;
			default:break;
		}
		repaint();
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		moveHeroAndTurn(action);
	}
}