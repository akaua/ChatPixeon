package model;

public class User {
	private String id;
	private String name;
	private String givenName;
	private String imageUrl;
	private String idToken;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getIdToken() {
		return idToken;
	}
	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", givenName=" + givenName + ", imageUrl=" + imageUrl
				+ ", idToken=" + idToken + "]";
	}
	
}
