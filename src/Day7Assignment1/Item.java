package Day7Assignment1;

public abstract class Item {
    String id;
    String title;
    String authors;

    public String getId() {
        return this.id;
    }

    public String getTile(){
        return  this.title;
    }
    public String getAuthors(){
        return this.authors;
    }
}
