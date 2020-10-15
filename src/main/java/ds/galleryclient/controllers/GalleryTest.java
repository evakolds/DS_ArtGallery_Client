package ds.galleryclient.controllers;

import ds.galleryclient.models.Organiser;
import ds.galleryclient.payloads.GalleryPayload;
import ds.galleryclient.requests.Request;
import ds.galleryclient.utils.FData;
import ds.galleryclient.utils.Logging;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Random;

public class GalleryTest {
    private final String endPoint = "http://locallhost:8080/api/gallery";

    private final Random rand = new Random();

    public void createGallery(int galleryNumber) throws IOException {
        for (int i=0; i<galleryNumber; i++){
            Request post = Request.builder()
                    .type(new HttpPost(endPoint))
                    .body(new GalleryPayload(FData.getName()))
                    .response(Organiser.class).build();
            Logging.printObject(post.send(), "Creating Gallery ");
        }
    }

    public Organiser getRandomSwimmingStuff() throws IOException {
        Request get = Request.builder()
                .type(new HttpGet(endPoint))
                .body(null)
                .response(Organiser[].class).build();
        Organiser[] organisers = (Organiser[]) get.send();
        return organisers[rand.nextInt(organisers.length)];
    }


    public void test() throws IOException{
        System.out.println("Gallery service testing".toUpperCase());
        createGallery(2);
    }
}

