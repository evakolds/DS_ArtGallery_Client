package ds.galleryclient.controllers;

import ds.galleryclient.models.Visitor;
import ds.galleryclient.models.Ticket;
import ds.galleryclient.payloads.TicketPayload;
import ds.galleryclient.requests.Request;
import ds.galleryclient.utils.FData;
import ds.galleryclient.utils.Logging;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Random;

public class TicketTest {
    private final String endPoint = "http://locallhost:8080/api/tickets";

    private final Random rand = new Random();

    public void createPass(int passNumber) throws IOException {
        for (int i=0; i<passNumber; i++){
            Request post = Request.builder()
                    .type(new HttpPost(endPoint))
                    .body(new TicketPayload(FData.getPrice()))
                    .response(Visitor.class).build();
            Logging.printObject(post.send(), "Creating Ticket");
        }
    }


    public Ticket getRandomTicket() throws IOException {
        Request get = Request.builder()
                .type(new HttpGet(endPoint))
                .body(null)
                .response(Ticket[].class).build();
        Ticket[] tickets = (Ticket[]) get.send();
        return tickets[rand.nextInt(tickets.length)];
    }

    public void testService() throws IOException{
        System.out.println("Tickets service testing".toUpperCase());
        createPass(2);
    }
}

