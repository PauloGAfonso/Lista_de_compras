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
                    if(resp2.equalsIgnoreCase("s") || resp2.equalsIgnoreCase("sim")){
                        verificandoItens(resp2, leitor, listaCompras);
                    }
                    break;
                case 2:
                    System.out.println("Aqui você vai visualizar/ler sua lista");
                    Thread.sleep(3000);
                    break;

                case 3:
                    System.out.println("Aqui você vai excluir a lista ou itens da lista");
                    Thread.sleep(3000);
                    String parandolooping = "s";
                    while(!parandolooping.equalsIgnoreCase("n") && !parandolooping.equalsIgnoreCase("nao")){
                        if(listaCompras.isEmpty()){
                            System.out.println("A lista está vazia... Não há item para ser removido");
                            Thread.sleep(3000);
                            limpaTela();
                            break;
                        } else{
                            listaCompras = removendoItem(listaCompras, leitor);
                        }
                        
                        System.out.println("Esses são os itens que estão presentes na sua lista atualmente: ");
                        for(String verificando : listaCompras){
                            System.out.println(verificando);
                        }

                        System.out.println("Gostaria de remover mais algum item da sua lista de compra? ");
                        parandolooping = leitor.nextLine();
                    }
                    System.out.println("Retornando ao menu...");
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


    public static ArrayList<String> removendoItem(ArrayList<String> listaCompra, Scanner leitor) throws Exception{
        for (int i = 0; i < listaCompra.size(); i++) {
            System.out.println((i+1) + " - " + listaCompra.get(i));
        }
                            
        System.out.println("Digite o número do item que deseja remover: ");
        System.out.print("R: ");
        int indice = leitor.nextInt();
        leitor.nextLine();
        if(indice > 0 && indice <= listaCompra.size()){
            listaCompra.remove(indice - 1);
            System.out.println("Item removido com sucesso!");
            Thread.sleep(3000);
        } else {
            System.out.println("Índice inválido!");
            Thread.sleep(3000);
        }

        System.out.println("Essa é sua lista de compra atual: ");
        for(String verificando : listaCompra){
            System.out.println(verificando);
        }
        Thread.sleep(3000);

        return listaCompra;
    }

}