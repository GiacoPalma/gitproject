
public class Comment {
	public String text;
	public Author author;
	
	public Comment(String text){
		this.text = text;
	}
	
	public String getComment(){
		String content;
		content = "Author: "+author.getName()+"\n";
		content += text+"\n";
		
		return content;
	}
	
}
