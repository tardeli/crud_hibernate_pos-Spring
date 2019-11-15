package br.com.tardeli.testeconsole;

import br.com.tardeli.config.AppConfig;
import br.com.tardeli.service.PartidoService;
import br.com.tardeli.service.VereadorService;
import br.com.tardeli.modelo.Partido;
import br.com.tardeli.modelo.Projeto;
import br.com.tardeli.modelo.Vereador;
import static br.com.tardeli.teste.VereadorTeste.converterStringParaDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class TelaVereador {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    private Scanner teclado = new Scanner(System.in);

    private Vereador v = new Vereador();
    private VereadorService vereadorService = context.getBean(VereadorService.class);

    private Partido partido = new Partido();
    private PartidoService partidoService = context.getBean(PartidoService.class);

    public Scanner getTeclado() {
        return teclado;
    }

    public void salvarConsole() {

        String codigo = "", opcao = "";

        System.out.println("Digite o nome do vereador: ");
        v.setNome(teclado.nextLine());

        System.out.println("Escolha um Partido digitando seu número: ");
        codigo = teclado.nextLine();
        partido = partidoService.buscarPartidoPorCodigo(Long.parseLong(codigo));
        v.setPartido(partido);

        System.out.println("Digite a data de associação: dd/mm/aaaa ");
        v.setDataAssociacao(converterStringParaDate(teclado.nextLine()));

        if (vereadorService.salvarOuAtualizar(v)) {
            System.out.println("Salvo projeto: " + v.getNome() + ", com sucesso!!!");
        } else {
            System.out.println("*****Erro ao salvar*****");
        }

    }

    public void atualizarConsole() {
        String codigo = "", opcao = "";
        Vereador obj = new Vereador();
        Projeto projeto = new Projeto();

        try {
            System.out.println("Digite o código do vereador para atualizar: ");
            codigo = teclado.nextLine();

            obj = vereadorService.buscarVereadorPorCodigo(Long.parseLong(codigo));

            System.out.println("Confirme o nome do vereador: ");
            obj.setNome(teclado.nextLine());

            System.out.println(" Confirme o Partido digitando seu número: ");
            codigo = teclado.nextLine();
            partido = partidoService.buscarPartidoPorCodigo(Long.parseLong(codigo));
            obj.setPartido(partido);

            System.out.println("Confirme a data de associação: dd/mm/aaaa ");
            obj.setDataAssociacao(converterStringParaDate(teclado.nextLine()));

            System.out.println("Digite o nome do projeto: ");
            projeto.setNome(teclado.nextLine());

            projeto.setVereador(obj);

            System.out.println("Projeto Apresentado\nSim---Digite 1\nNão---Digite 0\n ");
            opcao = teclado.nextLine();
            if (opcao == "1") {
                projeto.setApresentado(true);
            } else {
                projeto.setApresentado(false);
            }

            System.out.println("Projeto Aprovado\nSim---Digite 1\nNão---Digite 0\n ");
            opcao = teclado.nextLine();
            if (opcao == "1") {
                projeto.setAprovado(true);
            } else {
                projeto.setAprovado(false);
            }

            obj.getProjetos().add(projeto);

            if (vereadorService.salvarOuAtualizar(obj)) {
                System.out.println("Salvo projeto: " + obj.getNome() + ", com sucesso!!!");
            } else {
                System.out.println("*****Erro ao salvar*****");
            }

        } catch (Exception e) {
            e.getMessage();
            System.out.println("Erro ......");
        }

    }

    public void buscarPorIdConsole() {
        String codigo = "";
        Vereador obj = new Vereador();

        System.out.println("Digite um código para buscar: ");

        codigo = teclado.nextLine();

        try {
            obj = vereadorService.buscarVereadorPorCodigo(Long.parseLong(codigo));

            if (obj.getCodigo() > 0) {
                System.out.println(obj.toString());
            } else {
                System.out.println("*****Vereador não localizado*****");
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("*****Erro ao buscar*****");
        }

    }

    public void listarConsole() {
        for (Vereador obj : vereadorService.listarTodos()) {
            System.out.println(obj.toString());
        }
    }

    public void buscarVereadorPorPartido() {
        String cod = "";

        System.out.println("Digite um código de partido para buscar: ");

        cod = teclado.nextLine();

        try {
            List<Vereador> listaObjs = new ArrayList<>();
            partido = partidoService.buscarPartidoPorCodigo(Long.parseLong(cod));
            listaObjs = vereadorService.buscarVereadoresPorPartido(partido);
            if (!listaObjs.isEmpty()) {
                for (Vereador v : listaObjs) {
                    System.out.println(v.toString());
                }
            } else {
                System.out.println("Nenhum resultado foi encontrado para sua busca!!!");
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Erro ao buscar");
        }
    }

    public void buscarVereadorPorEntreDatas() {
        String data_1 = "", data_2 = "";

        System.out.println("Digite a data inicial para buscar: : dd/mm/aaaa");
        data_1 = teclado.nextLine();

        System.out.println("Digite a data final para buscar: : dd/mm/aaaa");
        data_2 = teclado.nextLine();

        try {
            List<Vereador> listaObjs = new ArrayList<>();
            listaObjs = vereadorService.buscarVereadoresAssociadosPorDatas(
                    converterStringParaDate(data_1), converterStringParaDate(data_2));
            if (!listaObjs.isEmpty()) {
                for (Vereador v : listaObjs) {
                    System.out.println(v.toString());
                }
            } else {
                System.out.println("Nenhum resultado foi encontrado para sua busca!!!");
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Erro ao buscar");
        }
    }

    public void buscarDadosVereadorPorNome() {
        String nome = "";
        System.out.println("Digite o nome do vereador para buscar: ");
        nome = teclado.nextLine();
        try {
            List<Vereador> vereadores = vereadorService.buscarDadosVereadorPorNome(nome);
            for (Vereador vereador : vereadores) {
                System.out.println(vereador.toString());
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Erro ao buscar");
        }
    }

    public static Date converterStringParaDate(String data) {
        Date d = new Date();
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            d = formato.parse(data);
            return d;
        } catch (Exception e) {
            e.getMessage();
        }
        return d;
    }

}
