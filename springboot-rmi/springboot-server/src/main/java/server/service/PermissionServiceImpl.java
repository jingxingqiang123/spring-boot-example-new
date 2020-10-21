package server.service;


import common.IPermissionService;
import common.bean.Permission;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements IPermissionService {

	@Override
	public Permission getPermissionByName(String pName) {
		Permission permission = null;
		if (pName != null && pName.equals("")) {
			permission = new Permission();
			if (pName.equals("ROLE_ADMIN")) {
				permission.setpName("ROLE_ADMIN");
				permission.setUrlPattern("/**");
			}else{
				permission.setpName("ROLE_ABEL");
				permission.setUrlPattern("/abel**");
			}
		}
		return permission;
	}

}
