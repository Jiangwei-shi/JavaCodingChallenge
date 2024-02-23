package Day7Assignment1;

public class CDs extends Item{
    String[] songs;
    public CDs(String id,String title,String authors, String[] songs){
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.songs = songs;
    }

    public String[] getSongs(){
        return this.songs;
    }
}
