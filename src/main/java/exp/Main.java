package exp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
	

	public static void main(String[] args) throws Exception{
		
		PrintStream out = new PrintStream(new FileOutputStream("errors.txt"));
		System.setErr(out);
		
		try(CdiContainer cdi = new CdiContainer()){
		
			MyBean bean = (MyBean) cdi.getCdiReference(MyBean.class);
			
			System.out.println(bean.myValue);
			
		}

	}

}
