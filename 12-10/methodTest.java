public class methodTest{

	public void m1(){
		boolean result=login("xx","xxx");
		if(result==true)
			System.out.println("µÇÂ¼³É¹¦");
		else
			System.out.println("µÇÂ¼Ê§°Ü");
	}
	public boolean login(String name,String password){
		if(name=="xx" && password=="xxx")
		return true;
		else 
		return false;
	}
	public static void main(String argv[]){
		methodTest m=new methodTest();
		m.m1();
	}

}