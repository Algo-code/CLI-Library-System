package LibrarySystem;
import java.util.*;
import asg.cliche.Command;

public class BookOperation extends Book{
	int length =0;
	// create list of type arraylist named Shelf which will store the Objects
	 List<Book> Shelf = new ArrayList<Book>();
	 // create a temp list to hold the searched books.
	 List<Book> temp = new ArrayList<Book>();
	 
	//Function to adds Book objects to the Shelf list and returns a list with the objects
	// the varargs type of parameter(data type... variable) is used so as to accommodate any number of variables 
	 public List<Book> Add_Book(String name, String author, String genre, String isbn, double price){
		 Book book_sample = new Book();
			book_sample.book_name = name;
			book_sample.book_author = author;
			book_sample.book_genre = genre;
			book_sample.setBook_isbn(isbn);
			book_sample.setBookPrice(price);
		Shelf.add(book_sample);
		return (Shelf);
	 }
	/* @Command
	 public List<Book> register_Book(Book... book1) { 
		length = book1.length; //get the number of variables passed
		for(int i=0; i<length; i++) 
			Shelf.add(book1[i]); // adds each object passed in the parameter to the arraylist Shelf
		
		return (Shelf); // arraylist with objects returned
		} */

	public void print_list(List<Book> list) {
		int list_length = list.size();
		if(list_length == 0)
			System.out.println("No Book Available!!");
		else {
		for(int i=0; i<list_length; i++){
		//the object fields in the arraylist are accessed by the arryname.get(object index).object field syntax
		// and since all these fields return a string they are concatinated and assigned to output to be printed
		String output = "Book name: " + list.get(i).book_name + "\n" + "Author: " + list.get(i).book_author + "\n" + 
				"Book genre: " + list.get(i).book_genre + "\n" + "Book isbn: " + list.get(i).getBook_isbn();
		double price = list.get(i).getBookPrice();
		System.out.println(output );
		System.out.println("Book Price: "+'$'+price);
		 System.out.println("--------------------------------------------------------------------------------------------------");
	}
		}
			}

	public List<Book> getBookByKeyWord(String str) {
		int list_length = Shelf.size();
		for(int i=0; i<list_length; i++) {
			if(Shelf.get(i).book_name.toLowerCase().contains(str.toLowerCase()) && !(str.contains(" "))) {
				temp.add(Shelf.get(i));
			}
			else
				;
		}
		return (temp);
	}
	@Command
	public List<Book> getBookByISBN(String str) {
		int list_length = Shelf.size();
	//	if (super.check_isbn(str) == true)
		for(int i=0; i<list_length; i++) {
			if(Shelf.get(i).getBook_isbn().equals(str)) {
				temp.add(Shelf.get(i));
			}
			else
				;
		}
	 if(temp.isEmpty() == true)
			return null;
	 else
		return (temp);
	}
}
