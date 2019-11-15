package br.com.tardeli.testeconsole;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class Principal {

    static int opcao = 0, opcao_2;
    static TelaPartido tp = new TelaPartido();
    static TelaProjeto tprojeto = new TelaProjeto();
    static TelaVereador tvereador = new TelaVereador();

    public static void main(String[] args) {

        do {
            menuPrincipal();
            switch (opcao) {
                case 1:
                    telaPartido();
                    break;
                case 2:
                    telaVereador();
                    break;
                case 3:
                    telaProjeto();
                    break;
                case 0:
                    System.out.println("Você saiu do sistema - Volte Logo!!!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

        } while (opcao != 0);

    }

    private static void menu(String tela) {
        System.out.println("\n");
        System.out.println(tela);
        System.out.println("|===========MENU===========|");
        System.out.println("| 1-CADASTRAR              |");
        System.out.println("| 2-ATUALIZAR              |");
        System.out.println("| 3-BUSCAR                 |");
        System.out.println("| 4-EXCLUIR                |");
        System.out.println("| 5-LISTAR                 |");
        System.out.println("| 0-VOLTAR MENU PRINCIPAL  |");
        System.out.println("|==========================|");
        System.out.println("Escolha uma opção: ");
        opcao_2 = tp.getTeclado().nextInt();
        tp.getTeclado().nextLine();
        System.out.println("\n");
    }

    private static void menuVereador() {
        System.out.println("\n");
        System.out.println("|===========MENU===========|");
        System.out.println("| 1-CADASTRAR              |");
        System.out.println("| 2-ATUALIZAR              |");
        System.out.println("| 3-BUSCAR POR CÓDIGO      |");
        System.out.println("| 4-BUSCAR POR NOME        |");
        System.out.println("| 5-BUSCAR POR DATAS       |");
        System.out.println("| 6-BUSCAR POR PARTIDO     |");
        System.out.println("| 7-LISTAR                 |");
        System.out.println("| 0-VOLTAR MENU PRINCIPAL  |");
        System.out.println("|==========================|");
        System.out.println("Escolha uma opção: ");
        opcao_2 = tp.getTeclado().nextInt();
        tp.getTeclado().nextLine();
        System.out.println("\n");
    }

    private static void menuPrincipal() {
        System.out.println("\n");
        System.out.println("|===========MENU===========|");
        System.out.println("| Menu principal           |");
        System.out.println("| 1-TELA DE PARTIDOS       |");
        System.out.println("| 2-TELA DE VEREADORES     |");
        System.out.println("| 3-TELA DE PROJETOS       |");
        System.out.println("| 0-SAIR                   |");
        System.out.println("|==========================|");
        System.out.println("Escolha uma opção: ");
        opcao = tp.getTeclado().nextInt();
        System.out.println("\n");
    }

    private static void telaPartido() {
        do {
            System.out.print("============================");
            menu("TELA PARTIDO");
            switch (opcao_2) {
                case 1:
                    tp.salvarConsole();
                    break;
                case 2:
                    tp.salvarConsole();
                    break;
                case 3:
                    tp.buscarPorIdConsole();
                    break;
                case 4:
                    System.out.println("Você não possui permissão para excluir.....!!!");
                    break;
                case 5:
                    tp.listarConsole();
                    break;
                case 0:
                    System.out.println("Você saiu.....!!!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

        } while (opcao_2 != 0);
    }

    private static void telaProjeto() {
        do {
            System.out.print("============================");
            menu("TELA PROJETOS");
            switch (opcao_2) {
                case 1:
                    tprojeto.salvarConsole();
                    break;
                case 2:
                    tprojeto.atualizarConsole();
                    break;
                case 3:
                    String op = "";
                    System.out.println("ESCOLHA UMA OPÇÃO PARA BUSCAR POR: \nCódigo ----------1\nNome Projeto ----2\nVereador --------3");
                    op = tp.getTeclado().nextLine();
                    switch (op) {
                        case "1":
                            tprojeto.buscarPorIdConsole();
                            break;
                        case "2":
                            tprojeto.buscarProjetoPorNome();
                            break;
                        case "3":
                            tprojeto.buscarProjetoPorVereador();
                            break;
                        default:
                            System.out.println("Opção Inválida!");
                            break;
                    }
                    break;
                case 4:
                     System.out.println("Não há permissão para exclusão!!!");
                    break;
                case 5:
                    tprojeto.listarConsole();
                    break;
                case 0:
                    System.out.println("Você saiu.....!!!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

        } while (opcao_2 != 0);
    }

    private static void telaVereador() {
        do {
            System.out.print("============================");
            menu("TELA VEREADORES");
            switch (opcao_2) {
                case 1:
                    tvereador.salvarConsole();
                    break;
                case 2:
                    tvereador.atualizarConsole();
                    break;
                case 3:
                    String op = "";
                    System.out.println("ESCOLHA UMA OPÇÃO PARA BUSCAR POR: \nCódigo ----------1\nNome Vereador ---2\nData associação -3\nPartido ---------4");
                    op = tp.getTeclado().nextLine();
                    switch (op) {
                        case "1":
                            tvereador.buscarPorIdConsole();
                            break;
                        case "2":
                            tvereador.buscarDadosVereadorPorNome();
                            break;
                        case "3":
                            tvereador.buscarVereadorPorEntreDatas();
                            break;
                        case "4":
                            tvereador.buscarVereadorPorPartido();
                            break;
                        default:
                            System.out.println("Opção Inválida!");
                            break;
                    }
                    break;
                case 4:
                     System.out.println("Não há permissão para exclusão!!!");
                    break;
                case 5:
                    tvereador.listarConsole();
                    break;
                case 0:
                    System.out.println("Você saiu.....!!!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

        } while (opcao_2 != 0);
    }

}
