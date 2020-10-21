package server;


import common.IPermissionService;
import common.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;

import java.rmi.RemoteException;

@SpringBootApplication
public class RmiBootServer {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IPermissionService permissionService;
	
	@Bean
	public RmiServiceExporter rmiServiceExporter(){
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		rmiServiceExporter.setServiceName("userService");
		rmiServiceExporter.setService(userService);
		rmiServiceExporter.setServiceInterface(IUserService.class);
		rmiServiceExporter.setRegistryPort(8888);// 默认为1099，注意占用问题
		try {
			rmiServiceExporter.afterPropertiesSet();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return rmiServiceExporter;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RmiBootServer.class, args);
	}
}
