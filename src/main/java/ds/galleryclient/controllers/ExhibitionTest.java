package ds.galleryclient.controllers;

import ds.galleryclient.models.Visitor;
import ds.galleryclient.payloads.ExhibitionPayload;
import ds.galleryclient.requests.Request;
import ds.galleryclient.utils.FData;
import ds.galleryclient.utils.Logging;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Random;

public class ExhibitionTest {
    private final String endPoint = "http://locallhost:8080/api/exhibitions";

    private final Random rand = new Random();

    public void createExhibition(int exhibitionsNumber) throws IOException {
        for (int i=0; i<exhibitionsNumber; i++){
            Request post = Request.builder()
                    .type(new HttpPost(endPoint))
                    .body(new ExhibitionPayload(FData.getName()))
                    .response(Visitor.class).build();
            Logging.printObject(post.send(), "Creating Exhibition");
        }
    }

    public Visitor getRandomExhibition() throws IOException {
        Request get = Request.builder()
                .type(new HttpGet(endPoint))
                .body(null)
                .response(Visitor[].class).build();
        Visitor[] visitors = (Visitor[]) get.send();
        return visitors[rand.nextInt(visitors.length)];
    }


    public void testService() throws IOException{
        System.out.println("Exhibition service testing".toUpperCase());
        createExhibition(1);
    }
}
