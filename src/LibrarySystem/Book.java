package LibrarySystem;
import LibrarySystem.ISBN;

public class Book extends ISBN {
	String book_name;
	String book_author;
	String book_genre;
	private String book_isbn;
	private Double book_price;
	
	Book(){}
	//the set method checks if an isbn is valid then assigns it to book_isbn
	//to assign the isbn number we use the setisbn() method from the ISBN class and 
	// to check the validity of the isbn we use the check_isbn() method from the ISBN class
	public void setBook_isbn(String book_isbn){
		super.setisbn(book_isbn);
		if(super.check_isbn(super.getisbn()) == true) 
			this.book_isbn = super.getisbn();
			else 
				this.book_isbn = "Invalid ISBN number";
	}
	public String getBook_isbn() {
		if(super.check_isbn(super.getisbn()) == true)
		return this.book_isbn;
		else
			return this.book_isbn = "Invalid ISBN number";
	}
	public void setBookPrice(Double price) {
		if(price < 0 )
			this.book_price = null;
		else
			this.book_price = price;
	}
	public double getBookPrice() {
		if (this.book_price == null)
			return -1;
			return this.book_price;
	}
	public Book(String book_name, String book_author, String book_genre, String book_isbn, double price){
		this.setBook_isbn(book_isbn);
		this.setBookPrice(price);
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_genre = book_genre;
		this.book_isbn = this.getBook_isbn();
		this.book_price = this.getBookPrice();
	}
}

