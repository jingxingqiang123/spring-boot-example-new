package client;

import common.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@SpringBootApplication
public class RmiBootClient {
	
	@Bean
	public RmiProxyFactoryBean rmiProxyFactoryBean(){
		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:8888/userService");
		rmiProxyFactoryBean.setServiceInterface(IUserService.class);
		return rmiProxyFactoryBean;
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RmiBootClient.class, args);
	}
}
