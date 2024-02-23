package Day7Assignment1;

public class Books extends Item{
    String ISBN;
    public Books(String id,String title,String authors, String ISBN){
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.ISBN = ISBN;
    }

    public String getISBN(){
        return this.ISBN;
    }
}
