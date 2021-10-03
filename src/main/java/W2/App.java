package W2;
import java.util.Scanner;


public class App {
    public static void main(String[] args){
        final Scanner scanner = new Scanner(System.in);
        Race carRace=new Race();
        carRace.setRace(scanner);
        carRace.doRace();
        carRace.award();
    }
}