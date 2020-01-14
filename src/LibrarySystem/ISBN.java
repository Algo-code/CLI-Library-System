package LibrarySystem;


class ISBN{
	private String isbn;
	
	public void setisbn(String isbn) {
		this.isbn = isbn;
	}
	public String getisbn() {
		return isbn;
	}
	boolean check_isbn(String a) {
		int i,j, temp = 0, length2=0;
		int length = isbn.length();
		int[] digit_isbn = new int[length];
		for(i=0, j=0; i<length; i++) {
			if((isbn.charAt(i) <= '9'|| (isbn.charAt(i) >= '0') || (isbn.charAt(i) == '-') || (isbn.charAt(i) == 'x') || (isbn.charAt(i) == 'X'))) {
			   if(isbn.charAt(i) == '-')
				   i++;
			   else if(isbn.charAt(i) == 'x' || isbn.charAt(i) == 'X')
				   digit_isbn[j] = 10;
			  digit_isbn[j] = Character.digit(isbn.charAt(i), 10);
			  j++;
			  length2 = j;
		   }
			else
				this.isbn = "Invalid ISBN number";
		  }
		if(length2 == 10) {
		for (i=10, j=0; i>0; i--) {
			temp += digit_isbn[j]*i;
			j++;
			
		}
		temp %= 11;
		if(temp != 0)
		return false;
		return true;
		}
		else if (length2 == 13) {
			for(i=0, j=1; i<length2-1; i+=2) {
				temp += digit_isbn[i]+(digit_isbn[j]*3);
				j+=2;
			}
			temp += digit_isbn[length2-1];
			temp %= 10;
			if(temp != 0)
			return false;
			return true;
		}
		else
			return false;
	}
}