import java.util.ArrayList;


public class Article {
	public String body = "";
	public String title = "";
	public Author author;
	public Category category;
	public ArrayList<Comment> comments = new ArrayList<Comment>();
	
	public String returnContent(){
		String content;
		content = "Title: "+title+"\n";
		content += "Body: "+body+"\n";
		content += "Author: "+author.getName()+"\n";
		content += "Category: "+category.getCategory()+"\n";
		
		if(comments.size() > 0){
			for(int i = 0; i < comments.size();i++){
				content += comments.get(i).getComment()+"\n";
			}
		}
		
		return content;
	}
	
}
