import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;


public class MainWindow {

	protected Shell shell;
	private Text title_add;
	private static List list;
	private Button btnRemoveItem;
	static BloggList blist;
	private Text body;
	private Text title;
	private Text author;
	private Text author_add;
	private Label lblTitle_1;
	private Label lblNewLabel;
	private Text body_text;
	private Label lblBody;
	private Text category;
	private Label label;
	private Label lblBody_1;
	private List category_add;
	private Label lblCategories;

	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			blist = new BloggList();
			blist.CreateCategories();
			Article article = new Article();
			article.body = "Hej detta är mitt första inlägg!";
			article.title = "Första Inlägget!";
			
			article.author = new Author("Giaco Palma");
			article.category = new Category(blist.categories.get(2).name);
			
		    
			blist.articles.add(article);
			
			Article article2 = new Article();
			article2.body = "Hej Detta är mitt andra inlägg!!";
			article2.title = "Andra Inlägget!";
			article2.author = article.author;
			article2.category = new Category(blist.categories.get(0).name);
			
			blist.articles.add(article2);
			
			Article article3 = new Article();
			article3.body = "Hej detta är mitt tredje inlägg!";
			article3.title = "Tredje Inlägget!";
			article3.author = article.author;
			article3.category = new Category(blist.categories.get(4).name);
			
			blist.articles.add(article3);
			
			
			
			
			
			
			MainWindow window = new MainWindow();
			window.open();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(705, 492);
		shell.setText("SWT Application");
		
		title_add = new Text(shell, SWT.BORDER);
		title_add.setBounds(66, 11, 141, 23);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Article articlenew = new Article();
				articlenew.title = title_add.getText();
				articlenew.body = body_text.getText();
				articlenew.author = new Author(author_add.getText());
				int selected_cat = category_add.getSelectionIndex();
				articlenew.category = new Category(blist.categories.get(selected_cat).name);
				list.add(articlenew.title);
				blist.articles.add(articlenew);
				title_add.setText("");
				author_add.setText("");
				body_text.setText("");
				category_add.setSelection(1, 0);
				
			}
		});
		btnNewButton.setBounds(255, 286, 75, 25);
		btnNewButton.setText("Add Post");
		
		list = new List(shell, SWT.BORDER);
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int i = list.getSelectionIndex();
				title.setText(blist.articles.get(i).title);
				body.setText(blist.articles.get(i).body);
				author.setText(blist.articles.get(i).author.name);
				category.setText(blist.articles.get(i).category.name);
			}
		});
		list.setBounds(21, 335, 231, 93);
		
		for(int i = 0; i < blist.articles.size();i++){
			list.add(blist.articles.get(i).title);
		}
		
		btnRemoveItem = new Button(shell, SWT.NONE);
		btnRemoveItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
				int i = list.getSelectionIndex();
				list.remove(i);
				blist.articles.remove(i);
				}catch(Exception err){
					System.err.println(err.getMessage());
					
				}
			}
		});
		btnRemoveItem.setBounds(270, 403, 75, 25);
		btnRemoveItem.setText("Remove Item");
		
		body = new Text(shell, SWT.BORDER);
		body.setBounds(463, 107, 154, 204);
		
		title = new Text(shell, SWT.BORDER);
		title.setBounds(463, 11, 154, 21);
		
		author = new Text(shell, SWT.BORDER);
		author.setBounds(463, 38, 136, 21);
		
		Label lblAuthor = new Label(shell, SWT.NONE);
		lblAuthor.setBounds(410, 38, 55, 15);
		lblAuthor.setText("Author");
		
		Label lblTitle = new Label(shell, SWT.NONE);
		lblTitle.setBounds(410, 14, 55, 15);
		lblTitle.setText("Title");
		
		author_add = new Text(shell, SWT.BORDER);
		author_add.setBounds(65, 40, 119, 23);
		
		lblTitle_1 = new Label(shell, SWT.NONE);
		lblTitle_1.setBounds(10, 11, 55, 15);
		lblTitle_1.setText("Title");
		
		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 41, 55, 15);
		lblNewLabel.setText("Author");
		
		body_text = new Text(shell, SWT.BORDER);
		body_text.setBounds(66, 208, 162, 103);
		
		lblBody = new Label(shell, SWT.NONE);
		lblBody.setBounds(10, 208, 55, 15);
		lblBody.setText("Body");
		
		category = new Text(shell, SWT.BORDER);
		category.setBounds(463, 65, 76, 21);
		
		label = new Label(shell, SWT.NONE);
		label.setText("Category");
		label.setBounds(410, 65, 55, 15);
		
		lblBody_1 = new Label(shell, SWT.NONE);
		lblBody_1.setBounds(410, 107, 55, 15);
		lblBody_1.setText("Body");
		
		category_add = new List(shell, SWT.BORDER);
		category_add.setBounds(66, 96, 141, 106);
		
		for(int i = 0; i < blist.categories.size();i++){
			category_add.add(blist.categories.get(i).name);
		}
		
		lblCategories = new Label(shell, SWT.NONE);
		lblCategories.setBounds(10, 95, 55, 15);
		lblCategories.setText("Categories");

	}
	public List getList() {
		return list;
	}
}
