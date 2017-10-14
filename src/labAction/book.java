package labAction;

public class book {

	String ISBN;
	String Title;
	String Author;
	String Publisher;
	int PublishDate;
	float Price;
	
	public String getISBN(){
		return ISBN;
	}
	
	public void setISBN(String ISBN){
		this.ISBN = ISBN;
	}
	
	public String getTitle(){
		return Title;
	}
	
	public void setTitle(String Title){
		this.Title = Title;
	}
	
	public String getAuthor(){
		return Author;
	}
	
	public void setAuthor(String Author){
		this.Author= Author;
	}
	
	public String getPublisher(){
		return Publisher;
	}
	
	public void setPublisher(String Publisher){
		this.Publisher = Publisher;
	}
	
	public int getPublishDate(){
		return PublishDate;
	}
	
	public void setPublishDate(int PublishDate){
		this.PublishDate = PublishDate;
	}
	
	public float getPrice(){
		return Price;
	}
	
	public void setPrice(float Price){
		this.Price = Price;
	}
	
	public book(String ISBN,String Title,String Author,String Publisher,int PublishDate,float Price)
	{
		this.ISBN = ISBN;
		this.Title = Title;
		this.Author = Author;
		this.Publisher = Publisher;
		this.PublishDate = PublishDate;
		this.Price = Price;
	}
}
