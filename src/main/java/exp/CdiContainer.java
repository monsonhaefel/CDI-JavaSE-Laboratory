package exp;

import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

public class CdiContainer implements java.lang.AutoCloseable {
	
	private static ContainerLifecycle lifecycle = null;
	
	public Object getCdiReference(java.lang.Class beanType) {
		
		lifecycle = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
		lifecycle.startApplication(null);

		final BeanManager beanManager = lifecycle.getBeanManager();
		final Bean<?> bean = beanManager.getBeans(beanType).iterator().next();

		final Object myBean = beanManager.getReference(bean, beanType, beanManager.createCreationalContext(bean));
		
		return myBean;
	
	}
	
	public void close() throws Exception {
		lifecycle.stopApplication(null);
	}
	
	

}
