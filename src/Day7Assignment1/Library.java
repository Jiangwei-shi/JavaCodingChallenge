package Day7Assignment1;

import java.util.Arrays;

public class Library {
    public static void main(String[] args) {
        //Create a Book object
        Books book = new Books("123","book1","Jiangwei","46264");
        System.out.println(book.getId());
        System.out.println(book.getTile());
        System.out.println(book.getAuthors());
        System.out.println(book.getISBN());

        String[] songs =  {"song1","song2","song3","song4","song5"};
        //Create a CD object
        CDs cd = new CDs("123","CD1","jiangwei",songs);
        System.out.println(cd.getId());
        System.out.println(cd.getTile());
        System.out.println(cd.getAuthors());
        System.out.println(Arrays.toString(cd.getSongs()));

        //Create a DVD
        DVDs dvd = new DVDs("123","DVD1","jiangwei","Shi");
        System.out.println(dvd.getId());
        System.out.println(dvd.getTile());
        System.out.println(dvd.getAuthors());
        System.out.println(dvd.getDirector());
    }
}
