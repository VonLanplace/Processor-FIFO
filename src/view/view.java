package view;
import controller.Controller;

public class view{
	public static void main(String[] args) {
		try{
			Controller obj = new Controller();
			System.out.println(obj.teste());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
