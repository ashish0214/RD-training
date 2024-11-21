package CalssesAndObject.Task1;

   public class Book {
       private int bookId;
       private String bookName, authorName;

       public Book(String authorName, int bookId, String bookName) {
           this.authorName = authorName;
           this.bookId = bookId;
           this.bookName = bookName;
       }

       public Book() {
       }

       public String getAuthorName() {
           return authorName;
       }

       public void setAuthorName(String authorName) {
           this.authorName = authorName;
       }

       public int getBookId() {
           return bookId;
       }

       public void setBookId(int bookId) {
           this.bookId = bookId;
       }

       public String getBookName() {
           return bookName;
       }

       public void setBookName(String bookName) {
           this.bookName = bookName;
       }

       public String toString(){

           return "Id: "+bookId +"  " +"Book Name: "+bookName+"  "+"AuthorName: "+authorName;

    }


}
