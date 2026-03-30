import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        ArrayList<String> listaCompras = new ArrayList<>();

        System.out.println("Quer montar sua lista de compras?(S/N) ");
        String escolha = leitor.nextLine().toLowerCase();

        if (escolha.equals("n") || escolha.equals("nao")) {
            System.out.println("Okay, encerrando o programa, obrigado!");
            System.exit(0);
        }

        System.out.println("Sabe quantos itens vai querer adicionar");
        String item = leitor.nextLine().toLowerCase();

        if(item.equals("s") || item.equals("sim")){
            System.out.println("Quantos itens você vai querer adicionar? ");
            int itensQuant = leitor.nextInt();
            leitor.nextLine();
            
            for(int i = 1; i <= itensQuant; i++){
                System.out.print("informe o " + i + "° item: ");
                listaCompras.add(adicionandoItens(leitor, item));
            }
        } else {
            while (true) {
                listaCompras.add(adicionandoItens(leitor, item));

                System.out.print("Quer adicionar um novo item?(S/N) ");
                String resp = leitor.nextLine().toLowerCase();

                if(resp.equalsIgnoreCase("n")){
                    System.out.println("Lista de compras foi criada");
                    limpaTela();
                    break;
                }
                limpaTela();
            }
        }

        System.out.println("Você adicionou " + listaCompras.size() + " itens a sua lista de compra.");
        System.out.println("Gostaria de ver os itens que você adicionou?(S/N)");
        String resp2 = leitor.nextLine();
        if(resp2.equals("s")){
            verificandoItens(resp2, leitor, listaCompras);
        }

        System.out.println("Obrigado por usar a minha lista!");

        leitor.close();
    }

    public static void limpaTela() {
        try {
            // Detecta o sistema operacional
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Linux ou Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Se não funcionar (ex: rodando em IDE), imprime várias linhas em branco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    public static String adicionandoItens(Scanner leitor, String item){

        if(item.equals("s") || item.equals("sim")){
            return leitor.nextLine();
        }else{
            System.out.print("Qual item você vai adicionar a lista: ");
            return leitor.nextLine();
        }
    }

    public static void verificandoItens(String resp, Scanner leitor, ArrayList<String> listaCompras){
        if(resp.equals("s")){
            int id = 1;
            for (String listas : listaCompras) {
                System.out.println(id + "° item: " + listas);
                id += 1;
            }
        }
    }

}
