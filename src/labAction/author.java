package labAction;

public class author {
	
	int authorID;
	String name;
	String age;
	String country;
	
	public int getAuthorID(){
		return authorID;
	}
	
	public void setAuthorID(int authorID){
		this.authorID = authorID;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getAge(){
		return age;
	}
	
	public void setAge(String age){
		this.age = age;
	}
	
	public String getCountry(){
		return country;
	}
	
	public void setCountry(String country){
		this.country = country;
	}
	
	public author(int authorID,String name,String age,String country){
		this.authorID = authorID;
		this.name = name;
		this.age = age;
		this.country = country;
	}

}
