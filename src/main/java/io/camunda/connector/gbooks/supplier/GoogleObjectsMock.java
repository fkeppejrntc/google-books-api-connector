package io.camunda.connector.gbooks.supplier;

import com.google.api.client.util.DateTime;
import io.camunda.connector.gbooks.model.google.Bookshelf;
import io.camunda.connector.gbooks.model.google.Bookshelves;
import io.camunda.connector.gbooks.model.google.Volume;
import io.camunda.connector.gbooks.model.google.Volumes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleObjectsMock {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleObjectsMock.class);

    public Bookshelf getBookshelf(Integer bookshelfId){
        LOGGER.info("inside getBookshelf");

        Bookshelf item = new Bookshelf();
        item.setKind("books#bookshelf");
        item.setAccess("PRIVATE");
        item.setId(bookshelfId);
        item.setDescription("My Bookshelf "+bookshelfId);
        item.setTitle("My Bookshelf "+bookshelfId);
        item.setCreated(new DateTime("2024-04-08T22:20:28.000Z"));
        item.setUpdated(new DateTime("2024-04-08T22:20:28.000Z"));
        return item;
    }

    public List<Bookshelf> getBookshelfList(){
        LOGGER.info("inside getBookshelfList");

        var items = new ArrayList<Bookshelf>();
        items.add(getBookshelf(1));
        items.add(getBookshelf(2));
        items.add(getBookshelf(3));
        return items;
    }

    public Bookshelves getBookshelves(){
        LOGGER.info("inside getBookshelves");

        Bookshelves result = new Bookshelves();
        result.setKind("books#bookshelves");
        result.setItems(getBookshelfList());
        return result;
    }

    public Volume getVolume(String volumeId, String genre){
        LOGGER.info("inside getVolume");

        ArrayList<String> authors = new ArrayList<>();
        authors.add("Some Author 1");
        authors.add("Some Author 2");

        ArrayList<String> categories = new ArrayList<>();
        categories.add(genre);

        Volume.VolumeInfo volumeInfo = new Volume.VolumeInfo();
        volumeInfo.setTitle("Some Book Name of "+genre);
        volumeInfo.setAuthors(authors);
        volumeInfo.setPublishedDate("1999");
        volumeInfo.setPageCount(150*Integer.parseInt(volumeId));
        volumeInfo.setCategories(categories);

        Volume.AccessInfo.Pdf pdf = new Volume.AccessInfo.Pdf();
        pdf.setDownloadLink("http://books.google.com.br/books/download/A_Dictionary_of_the_Pali_Language.pdf?id=dCdAAAAAYAAJ&hl=&output=pdf&sig=ACfU3U0wodBJtt_B56AGfgZrMZmfYAwvjQ&source=gbs_api");
        pdf.setIsAvailable(true);

        Volume.AccessInfo accessInfo = new Volume.AccessInfo();
        accessInfo.setCountry("BR");
        accessInfo.setViewability("ALL_PAGES");
        accessInfo.setPdf(pdf);
        accessInfo.setWebReaderLink("http://play.google.com/books/reader?id=dCdAAAAAYAAJ&hl=&source=gbs_api");
        accessInfo.setAccessViewStatus("FULL_PUBLIC_DOMAIN");

        Volume item = new Volume();
        item.setKind("books#volume");
        item.setId("abcde+ID"+volumeId);
        item.setEtag("123456+"+volumeId);
        item.setSelfLink("https://www.googleapis.com/books/v1/volumes/dCdAAAAAYAAJ");
        item.setVolumeInfo(volumeInfo);
        item.setAccessInfo(accessInfo);

        return item;
    }

    public ArrayList<Volume> getVolumeList(){
        LOGGER.info("inside getVolumeList");

        ArrayList<Volume> list = new ArrayList<>();
        list.add(getVolume("1", "Fiction"));
        list.add(getVolume("2", "History"));
        list.add(getVolume("3", "Language"));
        list.add(getVolume("4", "Fiction"));

        return list;
    }

    public Volumes getVolumes(){
        LOGGER.info("inside getVolumes");

        Volumes volumes = new Volumes();
        volumes.setKind("books#volumes");
        volumes.setItems(getVolumeList());
        volumes.setTotalItems(volumes.getItems().size());

        return volumes;
    }
}
