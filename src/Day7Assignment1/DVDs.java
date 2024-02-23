package Day7Assignment1;

public class DVDs extends Item{
    String director;
    public DVDs(String id,String title,String authors, String director){
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.director = director;
    }

    public String getDirector(){
        return this.director;
    }
}
