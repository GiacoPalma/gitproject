import java.util.ArrayList;


public class BloggList {
	public ArrayList<Article> articles = new ArrayList<Article>();
	public ArrayList<Category> categories = new ArrayList<Category>();
	
	public void CreateCategories(){
		Category category = new Category("Sport");
		categories.add(category);
		
		category = new Category("Science");
		categories.add(category);
		
		category = new Category("History");
		categories.add(category);
		
		category = new Category("Movies");
		categories.add(category);
		
		category = new Category("Games");
		categories.add(category);
		
		category = new Category("Everyday Life");
		categories.add(category);
		
	}
}
