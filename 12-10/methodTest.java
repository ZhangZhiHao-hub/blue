public class methodTest{

	public void m1(){
		boolean result=login("xx","xxx");
		if(result==true)
			System.out.println("��¼�ɹ�");
		else
			System.out.println("��¼ʧ��");
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