package exp;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

public class MyApplication {

	private static ContainerLifecycle lifecycle = null;

	
	public static void main(String [] args) throws IOException {
	
		PrintStream out = new PrintStream(new FileOutputStream("errors.txt"));
		System.setErr(out);
	
		lifecycle = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
		lifecycle.startApplication(null);

		final BeanManager beanManager = lifecycle.getBeanManager();
		final Bean<?> bean = beanManager.getBeans(MyBean.class).iterator().next();

		final MyBean myBean = (MyBean) beanManager.getReference(bean, MyBean.class, beanManager.createCreationalContext(bean));
		
		// YOUR TEST CODE GOES HERE
		
		System.out.println("MyValue = "+myBean.myValue);
		
		////////////////////////////////

		lifecycle.stopApplication(null);
	}
}
