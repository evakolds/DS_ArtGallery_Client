package ds.galleryclient.utils;

import ch.qos.logback.classic.util.LogbackMDCAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FData {
    private static final Random rand = new Random();
    private static final List<String> names = Arrays.asList("Ivan", "Petro", "Alex", "Sasha");
    private static final List<String> surnames = Arrays.asList("Ivanov", "Petrov", "Durov", "Titov");
    private static final List<String> exhibitions = Arrays.asList("Mone", "Klimt", "Dali");
    private static final List<String> employees = Arrays.asList("admin", "admin", "admin", "admin");


    public static String getName(){return names.get(rand.nextInt(names.size()));}

    public static String getSurname(){return surnames.get(rand.nextInt(surnames.size()));}

    public static String  getExhibition(){
        return exhibitions.get(rand.nextInt(exhibitions.size()));}

    public static String getEmployees(){return employees.get(rand.nextInt(employees.size()));}



    public static int getPassPrice(){return rand.nextInt() * 20;}

    public static double getSalary(){return rand.nextDouble() * 2000.0;}

    public static int getPrice(){return rand.nextInt() * 10;}
}
