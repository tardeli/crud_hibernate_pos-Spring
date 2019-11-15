package br.com.tardeli.teste;

import br.com.tardeli.service.PartidoService;
import br.com.tardeli.service.VereadorService;
import br.com.tardeli.modelo.Partido;
import br.com.tardeli.modelo.Vereador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class VereadorTeste {

    public static void main(String[] args) throws ParseException {
        VereadorService vereadorControle = new VereadorService();
        PartidoService partidoControle = new PartidoService();
        List<Vereador> listaObjs = new ArrayList<>();
               
        //BUSCAR OS DADOS DE UM VEREADOR PELO NOME
        System.out.println("BUSCAR OS DADOS DE UM VEREADOR PELO NOME");
        Vereador v = (Vereador) vereadorControle.buscarDadosVereadorPorNome("Tardeli da Rocha");
        System.out.println(v.toString());
        
        //BUSCAR OS VEREADORES ASSOCIADOS ENTRE UM PERÍODO DE DATAS
        System.out.println("BUSCAR OS VEREADORES ASSOCIADOS ENTRE UM PERÍODO DE DATAS");
        String data_1 ="06/09/2019", data_2 ="06/12/2019";
        listaObjs = vereadorControle.buscarVereadoresAssociadosPorDatas(
                converterStringParaDate(data_1), converterStringParaDate(data_2));
        
        System.out.println("BUSCAR OS VEREADORES ASSOCIADOS ENTRE:  "+data_1+ " e "+ data_2);
        for (Vereador vereador : listaObjs) {
            System.out.println(vereador.toString());
        }
        
        //BUSCAR VEREADORES DE UM PARTIDO
        System.out.println("BUSCAR VEREADORES DE UM PARTIDO");
        Long codigo = 13L;
        Partido p = partidoControle.buscarPartidoPorCodigo(codigo);
        listaObjs = vereadorControle.buscarVereadoresPorPartido(p);
        
        System.out.println("BUSCAR VEREADORES DO PARTIDO: "+ codigo);
        for (Vereador listaObj : listaObjs) {
            System.out.println(listaObj.toString());
        }
        
    }

    public static Date converterStringParaDate(String data) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date d = formato.parse(data);
        return d;
    }
}
