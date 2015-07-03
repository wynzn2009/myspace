package com.bean;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.bzu.entity.Student;
import com.bzu.entity.StudentService;

public class ClassPathXmlApplicationContext implements BeanFactory {
	private Map<String, Object> beans = new HashMap<String, Object>(); 
	
	
	@SuppressWarnings("unchecked")
	public ClassPathXmlApplicationContext() throws Exception,Exception{
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
		Element root = doc.getRootElement();
		List<Element> list = root.getChildren("bean");
		for(int i=0;i<list.size();i++){
			Element element = (Element) list.get(i);
			String id = element.getAttributeValue("id");
			String clazz = element.getAttributeValue("class");
			Object o = Class.forName(clazz).newInstance();
			System.out.println(id);
			System.out.println(clazz);
			beans.put(id, o);
			for(Element propertyElement : (List<Element>)element.getChildren("property")){
				String name = propertyElement.getAttributeValue("name");
				String bean = propertyElement.getAttributeValue("bean");
				Object beanObject = beans.get(bean);
				String methodName = "set"+name.substring(0, 1).toUpperCase()+name.substring(1);
				System.out.println("method name = "+methodName);
				Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
				m.invoke(o, beanObject);
			}
			
		}
	}
	
	@Override
	public Object getBean(String id) {
		// TODO Auto-generated method stub
		return beans.get(id);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext();
		Student stu = new Student();
		StudentService service = (StudentService) con.getBean("stuService");
		service.add(stu);
	}

}
