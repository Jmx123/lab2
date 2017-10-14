package labAction;

public class BookImformation {

	String ISBN;
	String Title;
	String Author;
	String Publisher;
	int PublishDate;
	String Country;
	
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
		this.Author = Author;
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
	
	public String getCountry(){
		return Country;
	}
	
	public void setCountry(String Country){
		this.Country = Country;
	}
	public BookImformation(String ISBN,String Title,String Author,String Publisher,int PublishDate,String Country)
	{
		this.ISBN = ISBN;
		this.Title = Title;
		this.Author = Author;
		this.Publisher = Publisher;
		this.PublishDate = PublishDate;
		this.Country = Country;
	}

}
