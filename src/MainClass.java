
public class MainClass {

	
	public static void main(String[] args) {
		
		Article article = new Article();
		article.body = "Hej detta �r mitt f�rsta inl�gg!";
		article.title = "F�rsta Inl�gget!";
		
		article.author = new Author("Giaco Palma");
		article.category = new Category("Sport");
		
		BloggList blist = new BloggList();
		blist.articles.add(article);
		
		System.out.println(article.returnContent());
		

	}

}
