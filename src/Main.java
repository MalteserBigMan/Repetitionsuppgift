import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            ArrayList<String> strängar = hämtaSträngarFrånFil();
            System.out.println(strängar.size());
            int MängdErrors = errorletare(strängar);
            System.out.println("Du har " + MängdErrors + " Errors i din kod");
            ArrayList<String> github = githubletare(strängar);
            System.out.println(github);
        } catch (FileNotFoundException e) {
            System.out.println("Du har något fel på din fil");
        }
    }



    public static ArrayList<String> hämtaSträngarFrånFil() throws FileNotFoundException {
        int MängdErrors = 0;
        ArrayList<String> lista = new ArrayList<>();
        Scanner skanner = new Scanner(new File("src/ideaold.log"));
        while (skanner.hasNextLine()){
            String rad = skanner.nextLine();
            lista.add(rad);
        }
        return lista;
    }
    public static int errorletare (ArrayList<String> malte){
        int MängdErrors = 0;
        for (String element: malte) {
            if (element.contains("ERROR -")){
                MängdErrors++;}
            }
        return MängdErrors;
    }

    public static ArrayList<String> githubletare (ArrayList<String> malte){
        ArrayList<String> githublista = new ArrayList<>();
        for (String element: malte){
            if (element.contains("github")){
                githublista.add(element + "\n");
            }
        }
        return githublista;
    }

}

