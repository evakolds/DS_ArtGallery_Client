package ds.galleryclient;

import ds.galleryclient.controllers.ExhibitionTest;
import ds.galleryclient.controllers.GalleryTest;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GalleryClientApplication {

    public static void main(String[] args) {
        try{
            EmployeeTest employeeTest = new EmployeeTest();
            ExhibitionTest exhibitionTest = new ExhibitionTest();
            GalleryTest galleryTest = new GalleryTest();

            employeeTest.testService();
            exhibitionTest.testService();
            galleryTest.test();



        } catch (Exception e){
            System.out.println(e.toString());
        }

    }

}
