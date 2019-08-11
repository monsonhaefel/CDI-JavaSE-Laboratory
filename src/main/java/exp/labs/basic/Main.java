package exp;

import exp.beans.MyBean;
import exp.cdi.impl.CdiContainer;

public class Main {
	

	public static void main(String[] args) throws Exception{

		try(CdiContainer cdi = new CdiContainer()){
			
			// your code goes here
			
			MyBean bean = (MyBean) cdi.getCdiReference(MyBean.class);
			
			System.out.println("The answer is " + bean.myValue);
			
			System.out.println("The value of Pi = " + bean.myFloat);
			
		}

	}

}
