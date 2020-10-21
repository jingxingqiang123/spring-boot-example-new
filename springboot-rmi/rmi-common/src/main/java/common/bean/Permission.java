package common.bean;

import java.io.Serializable;

/**
 * 网络间的传输必须实现序列化接口，不然在客户端反序列化的时候就会报错
 */
public class Permission implements Serializable {

	private static final long serialVersionUID = -3628385215556564613L;
	
	private String pName;
	private String urlPattern;

	public Permission() {
	}

	public Permission(String pName, String urlPattern) {
		this.pName = pName;
		this.urlPattern = urlPattern;
	}

	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getUrlPattern() {
		return urlPattern;
	}
	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}
	
	
}
