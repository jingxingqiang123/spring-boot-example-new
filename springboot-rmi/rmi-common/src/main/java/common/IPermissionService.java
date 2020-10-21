package common;


import common.bean.Permission;

public interface IPermissionService {

	
	Permission getPermissionByName(String pName);
}
