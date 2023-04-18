import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            List<String> strängar = hämtaSträngarFrånFil();
            System.out.println(strängar.size());
        } catch (FileNotFoundException e) {
            System.out.println("Du har något fel på din fil");
        }
    }



    public static List<String> hämtaSträngarFrånFil() throws FileNotFoundException {
        ArrayList<String> lista = new ArrayList<>();
        Scanner skanner = new Scanner(new File("src/ideaold.log"));
        while (skanner.hasNextLine()){
            String rad = skanner.nextLine();
            lista.add(rad);
        }
        return lista;
    }
}

