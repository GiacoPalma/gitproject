
public class Author {
	public String firstName;
	public String lastName;
	public String name;
	public String email;
	public int age;
	
	public Author(String name){
		this.name = name;
	}
	
	public String getName(){
		return firstName+" "+lastName;
	}
	
	public String getInfo(){
		String content;
		content =  "Author: "+getName()+"\n";
		content += "e-mail: "+email+"\n";
		content += "age: "+age+"\n";
		
		return content;
	}
}
