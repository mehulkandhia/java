import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MainApp {

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		BeanFactory fact=new XmlBeanFactory(new FileSystemResource("Beans.xml"));
	      HelloWorld obj = (HelloWorld) fact.getBean("helloWorld");
	      obj.getMessage();
	}

}
