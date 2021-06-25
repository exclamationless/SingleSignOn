
public class UserInfo {
	
	private String Url;
	private String username;
	private String password;
	
	
	public UserInfo() {
	}
	
	public UserInfo(String url, String username, String password) {

		Url = url;
		this.username = username;
		this.password = password;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
