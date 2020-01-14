package LibrarySystem;

import java.util.*;

//import java.lang.*;
public class Library extends BookOperation {

	static BookOperation novel_book = new BookOperation();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int option, option2;
		System.out.println("****************Welcome To library system Menu**********************");
		System.out.println("To perform an action enter the digit with the action to be performed");
		do {
			System.out.println("\n");
			System.out.println("[1] option 1: Add book");
			System.out.println("[2] option 2: Show all available books");
			System.out.println("[3] option 3: Search for a book");
			System.out.println("[4] option 4: Quit program \n");

			option = input.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter book info in the specified order.");
				String name, author, genre, isbn;
				double price;
				System.out.println("Enter book name then press enter");
				name = input.next();
				System.out.println("Enter book author then press enter");
				author = input.next();
				System.out.println("Enter book genre then press enter");
				genre = input.next();
				System.out.println("Enter book isbn then press enter, it may or may not contain '-' but not spaces");
				isbn = input.next();
				System.out.println("Enter book price then press enter");
				price = input.nextDouble();
				novel_book.Add_Book(name, author, genre, isbn, price);
				break;
			case 2:
				System.out.println("------Here is a list of all Available book------" + "\n");
				novel_book.print_list(novel_book.Shelf);
				break;
			case 3:
				do {
					System.out.println("\n");
					System.out.println("[1] option 1: Search book by book ISBN");
					System.out.println("[2] option 2: Search book by keyword");
					System.out.println("[3] option 3: Go to main menu \n");
					option2 = input.nextInt();
					switch (option2) {

					case 1:
						String str;
						System.out.println("Search book by Entering correct book ISBN");
						str = input.next();
						if (novel_book.getBookByISBN(str) == null) {
							System.out.println("** Sorry!! no book with isbn number " + str
									+ " exists, but here is a list of all available books!**" + "\n");
							novel_book.print_list(novel_book.Shelf);
						} else {
							System.out.println("********Here is a book with ISBN number " + str + "*********");
							novel_book.print_list(novel_book.getBookByISBN(str));
						}
						break;
					case 2:
						String str2;
						System.out.println("Search for book by Entering a keyword");
						str2 = input.next();
						novel_book.print_list(novel_book.getBookByKeyWord(str2));
						break;
					case 3:
						break;
					default:
						System.out.println("Option doesn't exist!!!!!!!!!");
						break;
					}
				} while (option2 != 3);
				break;
			case 4:
				System.out.println("Goodbye");
				break;

			default:
				System.out.println("Option Doesnt exist");
				break;
			}
		} while (option != 4);
		input.close();
	}
}