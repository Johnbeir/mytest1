package cn.com.cathay;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import cn.com.cathay.service.UserServiceImpl;

public class PublishServer {

	public static void main(String[] args) {
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		factory.setAddress("http://localhost:8081/rs");
		factory.setServiceBean(new UserServiceImpl());
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.create();
		System.out.println("服务启动.........");
	}

}
