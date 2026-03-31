import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        ArrayList<String> listaCompras = new ArrayList<>();
        int escolhacaso = Integer.MIN_VALUE;

        limpaTela();
        while (escolhacaso != 4) {    
            
            escolhacaso = menuinicial(leitor);
            switch (escolhacaso) {
                case 1:
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
                        limpaTela();
                        
                        for(int i = 1; i <= itensQuant; i++){
                            listaCompras.add(adicionandoItens(i, leitor));
                            limpaTela();
                            
                        }
                    } else {
                        int count = 1;
                        String resp = escolha;
                        while (!resp.equals("n")) {
                            listaCompras.add(adicionandoItens(count, leitor));

                            System.out.print("Quer adicionar um novo item?(S/N) ");
                            resp = leitor.nextLine().toLowerCase();
                            count++;

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
                    String resp2 = leitor.nextLine().toLowerCase();
                    if(resp2.equals("s") || resp2.equals("sim")){
                        verificandoItens(resp2, leitor, listaCompras);
                    }
                    break;
                case 2:
                    System.out.println("Aqui você vai editar sua lista");
                    Thread.sleep(3000);
                    break;

                case 3:
                    System.out.println("Aqui você vai excluir a lista ou itens da lista");
                    Thread.sleep(3000);
                    break;
                case 4:
                    System.out.println("Encerrando o programa");
                    Thread.sleep(3000);
                    break;
                default:
                    System.out.println("Opção inexistente!");
                    Thread.sleep(3000);
                    break;
            }

        }
        

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

    public static String adicionandoItens(int loop, Scanner leitor){

        System.out.print("informe o " + loop + "° item: ");
        return leitor.nextLine();
    }

    public static void verificandoItens(String resp, Scanner leitor, ArrayList<String> listaCompras) throws Exception {
        if(resp.equals("s")){
            int id = 1;
            for (String listas : listaCompras) {
                System.out.println(id + "° item: " + listas);
                id += 1;
            }
            Thread.sleep(10000);
        }
    }


    public static int menuinicial(Scanner leitor){
        limpaTela();
        System.out.println("O que deseja fazer?");
        System.out.println("Digite 1 para criar a lista");
        System.out.println("Digite 2 para editar uma lista existente");
        System.out.println("Digite 3 para deletar item de lista ou uma lista");
        System.out.println("Digite 4 para sair");
        System.out.print("R: ");
        int opcao = leitor.nextInt();
        leitor.nextLine(); // limpa o enter
        return opcao;
    }

}