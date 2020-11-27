package projeto_final;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import util.Consola;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Projeto_final 
{
    public static SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy");
    public static Gestao g=new Gestao(); // Variável do tipo gestão, traz dados da classe Gestao

    public static void main(String[] args) 
    {
        int opcao, opcao2;
        g.ler_ficheiro();
        g.veiculos_man_atraso(); // Verifica no inicio do programa o numero de veiculos com manutenção em atraso
        g.verificar_estado_cand();
        do 
        {
            opcao=menu();
            switch(opcao) 
            {
                case 1:
                    do 
                    {
                        opcao2=gestao_tipos_veiculos();
                        switch(opcao2) 
                        {
                            case 1:
                                adicionar_tipo_veiculo();
                                break;
                            case 2:
                                System.out.println(g.mostrar_tipos_veiculos());
                                break;
                        }
                        if (opcao2!=0)
                            Consola.sc.nextLine(); // Espera que seja pressionada uma tecla para avançar 
                    }while(opcao2!=0);
                    break;
                case 2:
                    do 
                    {
                        opcao2=gestao_veiculos();
                        switch(opcao2) 
                        {
                            case 1:
                                adicionar_veiculo();
                                break;
                            case 2:
                                consultar_veiculo();
                                break;
                        }
                        if (opcao2!=0) 
                            Consola.sc.nextLine(); // Espera que seja pressionada uma tecla para avançar 
                    }while(opcao2!=0);
                    break;
                case 3:
                    do 
                    {
                        opcao2=gestao_funcionarios();
                        switch(opcao2) 
                        {
                            case 1:
                                registar_funcionario();
                                break;
                            case 2:
                                consultar_funcionario();
                                break;
                        }
                        if(opcao2!=0)
                            Consola.sc.nextLine(); // Espera que seja pressionada uma tecla para avançar 
                    }while(opcao2!=0);
                    break;
                case 4:
                    do 
                    {
                        g.verificar_estado_cand();
                        opcao2=gestao_candidaturas();
                        switch(opcao2) 
                        {                            
                            case 1:
                                registar_candidatura();
                                break;
                            case 2:
                                consultar_candidatura();
                                break;
                            case 3:
                                aprovar_candidatura();
                                break;
                            case 4:
                                remover_candidatura();
                                break;
                        }
                        if(opcao2!=0)
                            Consola.sc.nextLine(); // Espera que seja pressionada uma tecla para avançar 
                    }while(opcao2!=0);
                    break;
                case 5:
                    do 
                    {
                        opcao2=gestao_ocorrencias();
                        switch(opcao2) 
                        {
                            case 1:
                                registar_ocorrencia();
                                break;
                            case 2:
                                alterar_estado();
                                break;
                            case 3:
                                consultar_ocorrencia();
                                break;
                        }
                        if (opcao2!=0) 
                            Consola.sc.nextLine(); // Espera que seja pressionada uma tecla para avançar 
                    }while(opcao2!=0);
                    break;
                case 6:
                    do 
                    {
                        opcao2=gestao_manutencoes();
                        switch(opcao2) 
                        {
                            case 1:
                                registar_manutencao();
                                break;
                            case 2:
                                consultar_manutencao();
                                break;
                        }
                        if(opcao2!=0)
                            Consola.sc.nextLine(); // Espera que seja pressionada uma tecla para avançar 
                    }while(opcao2!=0);
                    break;
                case 7:
                    do 
                    {
                        opcao2=estatisticas();
                        switch(opcao2) 
                        {
                            case 1:
                                System.out.println(g.percentagem_veiculos());
                                break;
                            case 2:
                                System.out.println("Número total de veículos com manutenção em atraso: "+g.veiculos_man_atraso());
                                break;
                            case 3:
                                System.out.println(g.custo_total_tipo());
                                break;
                            case 4:
                                int ano=Consola.lerInt("Introduza o ano: ",0,999999);
                                System.out.println(g.can_ano_mes(ano));
                                break;
                        }
                    }while(opcao2!=0);
                    break;
                case 0:
                    System.out.println("Programa terminou...");
                    break;
                default:
                    System.out.println("Opção desconhecida! ");
            }
            if(opcao!=0)
                Consola.sc.nextLine(); // Espera que seja pressionada uma tecla para avançar          
        }while(opcao!=0);
        g.gravar_ficheiro();
    }

    private static int menu() 
    {
        int opcao;
        System.out.println();
        System.out.println("1 - Gestão de tipos de veículos:");
        System.out.println("2 - Gestão de veículos:");
        System.out.println("3 - Gestão de funcionários:");
        System.out.println("4 - Gestão de candidaturas:");
        System.out.println("5 - Gestão de ocorrências:");
        System.out.println("6 - Gestão de manutenções:");
        System.out.println("7 - Estatisticas:");
        System.out.println("0 - Sair\n");
        opcao=Consola.lerInt("Opcao: ",0,7);
        return opcao;
    }
    private static int gestao_tipos_veiculos() 
    {
        int opcao;
        System.out.println();
        System.out.println("1 - Registar tipo de veículo");
        System.out.println("2 - Consultar todos os tipos de veículos");
        System.out.println("0 - Voltar ao menu principal\n");
        opcao=Consola.lerInt("Opcao: ",0,2);
        return opcao;
    }
    private static int gestao_veiculos() 
    {
        int opcao;
        System.out.println();
        System.out.println("1 - Registar veículo");
        System.out.println("2 - Consultar veículos por tipo de veículo");
        System.out.println("0 - Voltar ao menu principal\n");
        opcao=Consola.lerInt("Opcao: ",0,2);
        return opcao;
    }
    private static int gestao_funcionarios() 
    {
        int opcao;
        System.out.println();
        System.out.println("1 - Registar funcionário");
        System.out.println("2 - Consultar funcionário por nif");
        System.out.println("0 - Voltar ao menu principal\n");
        opcao=Consola.lerInt("Opcao: ",0,2);
        return opcao;
    }
    private static int gestao_candidaturas() 
    {
        int opcao;
        System.out.println();
        System.out.println("1 - Registar candidatura");
        System.out.println("2 - Consultar candidaturas por data");
        System.out.println("3 - Aprovar candidatura");
        System.out.println("4 - Eliminar candidatura");
        System.out.println("0 - Voltar ao menu principal\n");
        opcao=Consola.lerInt("Opcao: ",0,4);
        return opcao;
    }
    private static int gestao_ocorrencias() 
    {
        int opcao;
        System.out.println();
        System.out.println("1 - Registar ocorrência");
        System.out.println("2 - Alterar estado de uma ocorrência");
        System.out.println("3 - Consultar ocorrências por veículo");
        System.out.println("0 - Voltar ao menu principal\n");
        opcao=Consola.lerInt("Opcao: ",0,3);
        return opcao;
    }
    private static int gestao_manutencoes() 
    {
        int opcao;
        System.out.println();
        System.out.println("1 - Registar manutenção");
        System.out.println("2 - Consultar manutenções por veículo");
        System.out.println("0 - Voltar ao menu principal\n");
        opcao=Consola.lerInt("Opcao: ",0,2);
        return opcao;
    }
    private static int estatisticas() 
    {
        int opcao;
        System.out.println();
        System.out.println("1 - Percentagem de veículos que já tiveram pelo menos uma avaria");
        System.out.println("2 - Total de veículos com manutenção em atraso");
        System.out.println("3 - Custo total em manutenções por cada tipo de veículo");
        System.out.println("4 - Total de candidaturas rejeitadas por mês num determinado ano");
        System.out.println("0 - Menu anterior\n");
        opcao=Consola.lerInt("Opcao: ",0,4);
        return opcao;
    }
    public static void adicionar_tipo_veiculo() 
    {
        String designacao=Consola.lerString("Indique a designação do tipo de veículo: ");
        Tipo_veiculo tipo_v=new Tipo_veiculo(designacao);
        g.adicionar_tipo(tipo_v);
        System.out.println("\nTipo de veículo registado com sucesso!\n");
    }
    public static void adicionar_veiculo() 
    {
        int pos,numero_chassis,nif,errodi;
        String data,estado="Disponivel"; //ao adicionar um novo veiculo, automaticamente, fica Disponível.
        Calendar data_ultima_manutencao=new GregorianCalendar();
        if(g.numero_funcionarios()!=0) //so pede dados caso existam funcionários inseridos no sistema
        {
            do 
            {
                do 
                {
                    nif=Consola.lerInt("Indique o NIF do funcionário que está a registar este veiculo: ",1,999999999); //pede o nif do funcionario que esta a registar o veiculo.
                    pos=g.pesquisar_funcionario(nif);
                    if(pos==-1) //caso o nif nao exista, imprime mensagem de erro e volta a pedir o nif.
                        System.err.println("O NIF introduzido não está associado a nenhum funcionário! Introduza novamente!\n");
                }while(pos==-1);
                if(g.obter_funcionario(pos).getFuncao().equalsIgnoreCase("tecnico")==false) 
                     //imprime mensagem de erro caso a funçao do funcionario a registar o veiculo nao seja "tecnico".
                    System.err.println("Este funcionário não é técnico, logo não pode introduzir veiculos!\nIntroduza novo funcionário\n");
            }while(g.obter_funcionario(pos).getFuncao().equalsIgnoreCase("tecnico")==false); //o programa fica preso neste loop ate ser introduzido um nif de um funcionario com a função de "tecnico".                  
            do 
            {
                numero_chassis=Consola.lerInt("Indique o número do chassi do veículo: ",1,9999999);
                pos=g.pesquisar_veiculo(numero_chassis);
                if(pos!=-1) 
                    System.err.println("O número de chassi introduzido já está associado a um veículo! Introduza novamente!\n");
            }while(pos!=-1);
            String designacao=Consola.lerString("Indique a designação do veículo: ");
            do 
            {
                System.out.println(g.mostrar_tipos_veiculos()); //mostra os tipos de veiculos existentes.
                int numero_tipo=Consola.lerInt("Indique o número do tipo de veículo: ",1,9999999);
                pos=g.pesquisar_tipo_veiculo_numero(numero_tipo);
                if(pos==-1)
                    System.err.println("O tipo de veículo introduzido não existe! Introduza novamente!\n");
            }while(pos==-1);
            do // pede a data de inicio do aluguer 
            {
                errodi=0;
                try 
                {
                    data=Consola.lerString("Indique a data da última manutenção (dd-mm-yyyy): ");
                    data_ultima_manutencao.setTime(formato.parse(data));
                } 
                catch(ParseException e) 
                {
                    errodi=1;
                    System.err.println("Data com formato inválido!Introduza novamente\n");
                }
            }while(errodi==1);
            Tipo_veiculo tipo=g.obter_tipo_veiculo(pos);
            Veiculo v=new Veiculo(numero_chassis,designacao,tipo,data_ultima_manutencao,estado);
            g.adicionar_veiculo(v);
            tipo.adicionar_veiculo(v);
            tipo.setNum_veiculos(tipo.getNum_veiculos()+1);
            System.out.println("\nVeículo registado com sucesso!\n");
            }
        else
            System.err.println("Não existem funcionários inseridos no sistema!\n");
    }
    public static void consultar_veiculo() 
    {
        int pos;
        System.out.println(g.mostrar_tipos_veiculos());
        if(g.total_elementos_tipos_veiculos()!=0) //apenas vai pedir para introduzir o numero do tipo de veiculo, caso o array de tipo veiculos contanha informação.
        {          
            do 
            {
                int numero_tipo=Consola.lerInt("Indique o número do tipo de veículo: ",1,9999999);
                pos=g.pesquisar_tipo_veiculo_numero(numero_tipo);
                if(pos==-1)
                    System.err.println("Tipo de veículo não existe!\n");
            }while(pos==-1);
            Tipo_veiculo tipo=g.obter_tipo_veiculo(pos);
            System.out.println(tipo.mostrar_veiculos());
        }    
    }
    public static void registar_funcionario() 
    {
        int nif,pos,telefone,errodi;
        String nome,morada,funcao,data;
        Calendar data_nasc=new GregorianCalendar();
        nome=Consola.lerString("Indique o nome do funcionário: ");
        do 
        {
            nif=Consola.lerInt("Indique o NIF do funcionário: ",1,999999999);
            pos=g.pesquisar_funcionario(nif);
            if(pos!=-1)
                System.err.println("O NIF introduzido já está associado a um funcionário! Introduza novamente!\n");
        }while(pos!=-1);
        telefone=Consola.lerInt("Indique o nº de telefone do funcionário: ",1,999999999);
        morada=Consola.lerString("Indique a morada do funcionário: ");
        funcao=Consola.lerString("Indique a função do funcionário: ");
        do //pede a idade do funcionário enquanto for introduzida num formato inválido.
        {    
            errodi = 0;
            try 
            {
                data=Consola.lerString("Indique a data de nascimento do funcionário (dd-mm-yyyy): ");
                data_nasc.setTime(formato.parse(data));
            } 
            catch (ParseException e) 
            {
                errodi=1;
                System.err.println("Data de nascimento com formato inválido!Introduza novamente\n");
            }
        } while (errodi==1);
        Funcionario f=new Funcionario(nif,nome,morada,telefone,funcao,data_nasc); //cria variável f do tipo funcionário, para poder ir ao metodo registar_funcionário, da classe gestao adicionar o funcionario à lista
        if(f.calcularAnos()>=18) 
        { // caso o funcionário seja maior de idade, é registado.
            g.registar_funcionario(f);
            System.out.println("\nFuncionário registado com sucesso!\n");
        } 
        else//caso contrário o registo do funcionário é rejeitado.
            System.err.println("Funcionário tem de ser maior de idade! Registo de funcionário rejeitado!\n");
    }
    public static void consultar_funcionario() 
    {
        int nif,pos,pos_func;
        if(g.numero_funcionarios()!=0) //apenas pede dados caso existam funcionarios inseridos no sistema.
        {
            do 
            {
                nif=Consola.lerInt("Indique o NIF do funcionário: ",1,999999999);
                pos_func=g.pesquisar_funcionario(nif);
                if(pos_func==-1)
                    System.err.println("O NIF introduzido não está associado a nenhum funcionário! Introduza novamente!\n");
            }while(pos_func==-1);
            Funcionario f=g.obter_funcionario(pos_func);
            System.out.println(f.toString());
            pos=g.consultar_candidaturas_por_nif_funcionario(nif); //vai buscar a posição da candidatura do funcionario que está a ser consultado
            if(pos==-1) //se o metodo consultar_candidaturas_por_nif_funcionario(pos) devolver -1, signfica que o funcionario nao tem candidaturas registadas
                System.out.println("Este funcionário não tem candidaturas!\n");
            else //caso tenha candidaturas realizadas, imprime-as
            {    
                System.out.println(g.obter_candidaturas_por_nif_funcionario(nif));
            }
        }
        else
            System.err.println("Não existem funcionários registados!\n");
    }
    public static void registar_candidatura() 
    {
        if(g.numero_veiculos()!=0) //apenas pede dados caso existam veiculos inseridas no sistema.
        {
            Calendar data_ca = GregorianCalendar.getInstance(); //a data da candidatura fica com a data que foi efetuada
            Calendar data_inicio = new GregorianCalendar(); //variavel que guarda data de inicio do aluguer
            Calendar data_fim = new GregorianCalendar(); //variavel que guarda data de fim do aluguer        
            String descricao, estado = null, data;
            Funcionario f;
            Veiculo v = null;
            int nif, pos, pos_tipo_veiculo, validade, validacao_estado, errodi, erro_atual, data_max, numero_chassis,validacao=0;
            n_cand_mes cand_mes = null;
            do {
                nif = Consola.lerInt("Indique o NIF do funcionário responsável pela candidatura: ", 1, 999999999);
                pos = g.pesquisar_funcionario(nif);
                if (pos == -1) {
                    System.err.println("O NIF introduzido não está associado a nenhum funcionário! Introduza novamente!\n");
                }
            } while (pos == -1);
            f = g.obter_funcionario(pos);
            descricao = Consola.lerString("Indique a descrição da candidatura:  ");
            validade = Consola.lerInt("A carta de condução do funcionário é válida?\nOpção 1 - Sim\nOpção 2 - Não\nOpção: ", 1, 2);
            if (validade == 2) {

                estado = "Reprovada";
            } else {
                validade = Consola.lerInt("Indique qual o estado da candidatura:\nOpção 0 - Reprovada\nOpção 1 - Aprovada\nOpção 2 - Pendente\nOpção: ", 0, 2);
                switch (validade) {
                    case 0:                   
                        estado = "Reprovada";
                        validacao=0;
                        break;
                    case 1:                     
                        estado = "Aprovada";
                        do {
                            do{
                                do // pede a data de inicio do aluguer 
                                {
                                    errodi = 0;
                                    try {
                                        data = Consola.lerString("Indique a data de inicio do aluguer (dd-mm-yyyy): ");
                                        data_inicio.setTime(formato.parse(data));
                                    } catch (ParseException e) {
                                        errodi = 1;
                                        System.err.println("Data com formato inválido!Introduza novamente\n");
                                        }
                                } while (errodi == 1);
                                erro_atual=g.compara_data_atual(data_inicio);
                                if(erro_atual==1)
                                    System.err.println("A data de inicio de aluguer não pode ser inferior à data atual\n");
                            } while(erro_atual == 1);
                            do //pede a data de fim do aluguer
                            {
                                errodi = 0;
                                try {
                                    data = Consola.lerString("Indique a data de fim do aluguer (dd-mm-yyyy): ");
                                    data_fim.setTime(formato.parse(data));
                                } catch (ParseException e) {
                                    errodi = 1;
                                    System.err.println("Data com formato inválido!Introduza novamente\n");
                                }
                            } while (errodi == 1);
                            data_max = g.calculo_protecao_candidatura(data_inicio, data_fim); //verifica se o aluguer não exede os 6 meses maximos e se a data de 
                            //fim de aluguer nao é inferior a de inicio.
                            if (data_max > 6) {
                                System.err.println("O periodo máximo de aluguer nao deve exceder os 6 meses!\n");
                            }
                            if (data_max == -1) {
                                System.err.println("A data de fim de aluguer tem de ser superior a de inicio de aluguer!\n");
                            }
                        } while (data_max > 6 || data_max == -1);
                        do { //Pede o tipo de veiculo que quer alugar
                            System.out.println(g.mostrar_tipos_veiculos()); //mostra os tipos de veiculos existentes.
                            int numero_tipo = Consola.lerInt("Indique o tipo de veiculo que quer alugar\nOpção: ", 1, 9999999);
                            pos_tipo_veiculo = g.pesquisar_tipo_veiculo_numero(numero_tipo);
                            if (pos_tipo_veiculo == -1) {
                                System.err.println("Tipo de veículo não existe!\n");
                            }
                        } while (pos_tipo_veiculo == -1);
                        do{
                            do { //Pede o numero do chassis do veiculo que quer alugar
                                System.out.println(g.mostrar_veiculos_candidatura(data_inicio, data_fim, pos_tipo_veiculo));
                                numero_chassis = Consola.lerInt("Indique o numero do chassis do veiculo a alugar\nNumero chassis: ", 1, 9999999);
                                pos = g.pesquisar_veiculo(numero_chassis);

                                if (pos == -1) {
                                    System.err.println("Veículo não existe!\n");
                                }
                            } while (pos == -1);
                            validacao_estado = g.validacao_estado_candidatura(numero_chassis);
                            if(validacao_estado!=1)
                                System.err.println("Este veículo não se encontra disponível! Introduza outro veiculo.\n");
                        }while(validacao_estado!=1);
                        validacao = g.protecao_candidatura(pos_tipo_veiculo, numero_chassis, data_inicio, data_fim); //esta funcao vai ver                 
                        int pos_veic = g.pesquisar_veiculo(numero_chassis);
                        v=g.obter_veiculo(pos_veic);                        
                        break;
                    case 2:
                        // estado 2: candidatura pendente
                        estado = "Pendente";
                        validacao=0;
                        break;
                    default:
                        break;
                }
            }
            if(validacao==1 || validacao==0) 
            {
                Candidatura c = new Candidatura(data_ca, descricao, f, estado);
                g.registar_candidatura(c,v,data_inicio,data_fim,validacao);
                pos = g.consultar_cand_ano(data_ca.get(Calendar.YEAR));
                if (pos != -1) {
                    cand_mes = g.obter_cand_mes(pos);
                    cand_mes.setMes(data_ca.get(Calendar.MONTH));
                } else {
                    cand_mes = new n_cand_mes(data_ca.get(Calendar.YEAR), data_ca.get(Calendar.MONTH));
                }
                g.registar_candidatura_mes(cand_mes);
                System.out.println("\nCandidatura registada com sucesso em: " + data_ca.get(Calendar.DATE) + "/" + (data_ca.get(Calendar.MONTH) + 1) + "/" + data_ca.get(Calendar.YEAR) + "\n");
            }
            else
                System.err.println("\nA candidatura nao foi registada, pois o veiculo introduzido nao está disponível");
        }
        else
            System.err.println("Não existem veiculos inseridos!\n");  
    }
    public static void consultar_candidatura() 
    {
        int errodi,pos;
        String data;
        Calendar data_c=new GregorianCalendar();
        if(g.numero_candidaturas()!=0) //apenas pede dados caso existam candidaturas inseridas no sistema.
        {
            do 
            {
                do 
                {
                    errodi=0;
                    try 
                    {
                        data=Consola.lerString("Indique a data de candidatura (dd-mm-yyyy): ");
                        data_c.setTime(formato.parse(data));
                    } 
                    catch(ParseException e) 
                    {
                        errodi=1;
                        System.err.println("Data de candidatura com formato inválido! Introduza novamente!\n");
                    }
                }while(errodi==1);
                pos=g.consultar_candidaturas(data_c);
                if(pos==-1) 
                    System.err.println("A data de candidatura introduzida não está associada a nenhuma candidatura! Introduza novamente!\n");
            }while(pos==-1);
            System.out.println(g.mostrar_candidaturas_data(data_c));
        }
        else
           System.err.println("Não existem candidaturas inseridas!\n");
    }
    public static void aprovar_candidatura()
    {
        Calendar data_inicio=new GregorianCalendar(); //variavel que guarda data de inicio do aluguer
        Calendar data_fim=new GregorianCalendar(); //variavel que guarda data de fim do aluguer   
        Veiculo v=null;
        String data;
        int numero,opcao,pos, pos_tipo_veiculo, pos_candidatura, errodi,erro_atual, data_max,numero_chassis,validacao_estado, validacao=0;        
        if(g.numero_candidaturas()!=0) //apenas pede dados caso existam candidaturas inseridas no sistema.
        {
            do 
            {
                numero=Consola.lerInt("Indique o número da candidatura: ",1,999999);
                pos_candidatura=g.pesquisar_candidatura(numero);
                if(pos_candidatura==-1)
                    System.err.println("O número introduzido não está associado a nenhuma candidatura! Introduza novamente!\n");
            }while(pos_candidatura==-1);
            if(g.obter_candidatura(pos_candidatura).getEstado().equalsIgnoreCase("Aprovada"))
                System.out.println("Esta candidatura já está aprovada! "); // estado 1: candidatura aprovada
            else 
            {
                opcao=Consola.lerInt("Pretende aprovar a candidatura?\nOpção 1 - Aprovar\nOpção 2 - Manter estado\n\nOpção: ",1,2);
                if(opcao==1) 
                {
                        do {
                            do
                            {
                                do // pede a data de inicio do aluguer 
                                {
                                    errodi = 0;
                                    try {
                                        data = Consola.lerString("Indique a data de inicio do aluguer (dd-mm-yyyy): ");
                                        data_inicio.setTime(formato.parse(data));
                                    } catch (ParseException e) {
                                        errodi = 1;
                                        System.err.println("Data com formato inválido!Introduza novamente\n");
                                    }
                                } while (errodi == 1);
                                erro_atual=g.compara_data_atual(data_inicio);
                                if(erro_atual==1)
                                    System.err.println("A data de inicio de aluguer não pode ser inferior à data atual\n");
                            } while(erro_atual == 1);
                            do //pede a data de fim do aluguer
                            {
                                errodi = 0;
                                try {
                                    data = Consola.lerString("Indique a data de fim do aluguer (dd-mm-yyyy): ");
                                    data_fim.setTime(formato.parse(data));
                                } catch (ParseException e) {
                                    errodi = 1;
                                    System.err.println("Data com formato inválido!Introduza novamente\n");
                                }
                            } while (errodi == 1);
                            data_max = g.calculo_protecao_candidatura(data_inicio, data_fim); //verifica se o aluguer não exede os 6 meses maximos e se a data de 
                            //fim de aluguer nao é inferior a de inicio.
                            if (data_max > 6) {
                                System.err.println("O periodo máximo de aluguer nao deve exceder os 6 meses!\n");
                            }
                            if (data_max == -1) {
                                System.err.println("A data de fim de aluguer tem de ser superior a de inicio de aluguer!\n");
                            }
                        } while (data_max > 6 || data_max == -1);
                        do { //Pede o tipo de veiculo que quer alugar
                            System.out.println(g.mostrar_tipos_veiculos()); //mostra os tipos de veiculos existentes.
                            int numero_tipo = Consola.lerInt("Indique o tipo de veiculo que quer alugar\nOpção: ", 1, 9999999);
                            pos_tipo_veiculo = g.pesquisar_tipo_veiculo_numero(numero_tipo);
                            if (pos_tipo_veiculo == -1) {
                                System.err.println("Tipo de veículo não existe!\n");
                            }
                        } while (pos_tipo_veiculo == -1);
                        do {
                            do { //Pede o numero do chassis do veiculo que quer alugar
                                System.out.println(g.mostrar_veiculos_candidatura(data_inicio, data_fim, pos_tipo_veiculo));
                                numero_chassis = Consola.lerInt("Indique o numero do chassis do veiculo a alugar\nNumero chassis: ", 1, 9999999);
                                pos = g.pesquisar_veiculo(numero_chassis);
                                 if (pos == -1) {
                                    System.err.println("Veículo não existe!\n");
                                }
                            } while (pos == -1);
                            validacao_estado = g.validacao_estado_candidatura(numero_chassis);
                            if (validacao_estado != 1) {
                                System.err.println("Este veículo não se encontra disponível! Introduza outro veiculo.\n");
                            }
                        } while (validacao_estado != 1);
                        validacao = g.protecao_candidatura(pos_tipo_veiculo, numero_chassis, data_inicio, data_fim); //esta funcao vai ver  
                        int pos_veic = g.pesquisar_veiculo(numero_chassis);
                        v=g.obter_veiculo(pos_veic);  
                    if(validacao==1)
                    {
                        g.aprovar_candidatura(pos_candidatura,data_inicio,data_fim,v);
                        System.out.println("\nCandidatura aprovada com sucesso!\n");
                    }
                    else
                        System.err.println("\nCandidatura não aprovada com sucesso!\n");
                }
            }
        }else
            System.err.println("Não existem candidaturas inseridas!\n");    
    }
    public static void remover_candidatura() 
    {
        int pos,numero,opcao;
        if(g.numero_candidaturas()!=0) //apenas pede dados caso existam candidaturas inseridas no sistema.
        {
            do 
            {
                numero=Consola.lerInt("Indique o número da candidatura: ",1,999999);
                pos=g.pesquisar_candidatura(numero);
                if(pos==-1)
                    System.err.println("O número introduzido não está associado a nenhuma candidatura! Introduza novamente!\n");
            }while(pos==-1);
            if(g.obter_candidatura(pos).getEstado().equalsIgnoreCase("Aprovada")) // estado 1: candidatura aprovada
                System.err.println("Esta candidatura está aprovada, logo não pode ser eliminada! ");
            else 
            {
                opcao=Consola.lerInt("Pretende eliminar a candidatura?\nOpção 1 - Eliminar\nOpção 2 - Manter\n\nOpção: ",1,2);
                if(opcao==1) 
                {
                    g.remover_candidatura(pos);
                    System.out.println("\nCandidatura eliminada com sucesso!\n");
                }
            }
        }else
            System.err.println("Não existem candidaturas inseridas!\n");  
    }
    public static void registar_ocorrencia() 
    {
        if(g.numero_veiculos()!=0) //apenas pede dados caso existam veiculos inseridos no sistema.
        {

            Calendar data_reg = GregorianCalendar.getInstance(); //a data da ocorrência fica com a data que foi efetuada        
            String descricao, estado = null;
            Funcionario f;
            Veiculo v;
            int nif, num_chassi, pos, validade = 0;
            descricao = Consola.lerString("Indique a descrição da ocorrência:  ");
            do {
                nif = Consola.lerInt("Indique o NIF do funcionário responsável pela ocorrência: ", 1, 999999999);
                pos = g.pesquisar_funcionario(nif);
                if (pos == -1) {
                    System.err.println("O NIF introduzido não está associado a nenhum funcionário! Introduza novamente!\n");
                }
            } while (pos == -1);
            f = g.obter_funcionario(pos);
            do {
                num_chassi = Consola.lerInt("Indique o número de chassi do veículo associado à ocorrência: ", 1, 999999999);
                pos = g.pesquisar_veiculo(num_chassi);
                if (pos == -1) {
                    System.err.println("O número de chassi introduzido não está associado a nenhum veículo! Introduza novamente!\n");
                }
            } while (pos == -1);
            v = g.obter_veiculo(pos);
            validade = Consola.lerInt("Indique qual o estado do veículo:\nOpção 0 - Por reparar\nOpção 1 - Reparado\nOpção 2 - Irreparável\nOpção: ", 0, 2);
            switch (validade) {
                case 0:
                    estado = "Por reparar";

                    break;
                case 1:
                    estado = "Reparado";
                    descricao = Consola.lerString("\nIndique a descrição da manutenção:  ");
                    double custo = Consola.lerDouble("\nIndique o custo da manutenção: ",0.0,9999999.9);
                    Manutencao m = new Manutencao(descricao, data_reg, f, v, custo);
                    g.registar_manutencao(m);
                    v.adicionar_manutencao(m);
                    v.setData_ultima_manutencao(data_reg);                    
                    double custo_atual=v.getTipo().getCusto(); // Vai buscar o custo existente no tipo de veiculo onde este veiculo pertence
                    v.getTipo().setCusto(custo_atual+custo); // Adiciona o custo desta manutenção ao custo existente no tipo de veiculo  
                    g.veiculos_man_atraso(); // Verifica o numero de veiculos com manutenção em atraso
                    g.alterar_estado_veiculo_ocorrencia(v);
                    break;
                case 2:
                    estado = "Irreparável";
                    break;
                default:
                    break;
            }
            Ocorrencia oc = new Ocorrencia(descricao, data_reg, f, v, estado);
            g.registar_ocorrencia(oc, num_chassi);
            v.adicionar_ocorrencia(oc);
            System.out.println("\nOcorrência registada com sucesso em: " + data_reg.get(Calendar.DATE) + "/" + (data_reg.get(Calendar.MONTH) + 1) + "/" + data_reg.get(Calendar.YEAR) + "\n");

        }
        else
            System.err.println("Não existem veiculos inseridos no sistema!\n");
    }
    public static void alterar_estado() 
    {
        int pos,numero,validade,pos_ocorrencia;
        String descricao,estado=null;
        if(g.numero_ocorrencias()!=0) //apenas pede dados caso existam ocorrencias inseridas no sistema.
        {
            do 
            {
                numero=Consola.lerInt("Indique o número da ocorrência: ",1,999999);
                pos_ocorrencia=g.pesquisar_ocorrencia(numero);
                if(pos_ocorrencia==-1) 
                    System.err.println("O número introduzido não está associado a nenhuma ocorrência! Introduza novamente!\n");
            }while(pos_ocorrencia==-1);
            if(g.obter_ocorrencia(pos_ocorrencia).getEstado().equalsIgnoreCase("Reparado")){
                System.out.println("Esta ocorrencia já está reparada! ");
            }
            else
            {    
                if(g.obter_ocorrencia(pos_ocorrencia).getEstado().equalsIgnoreCase("Irreparável"))
                    System.err.println("Esta veiculo nao tem reparação. Está irreparável! ");
                else
                {
                    Veiculo v=g.obter_ocorrencia(pos_ocorrencia).v;
                    validade=Consola.lerInt("Indique qual o estado do veículo:\nOpção 0 - Por reparar\nOpção 1 - Reparado\nOpção 2 - Irreparável\nOpção: ",0,2);
                    switch(validade) 
                    {
                        case 0:
                            estado="Por reparar";
                            v.setEstado("Por reparar");
                            break;
                        case 1:
                            estado="Reparado";
                            descricao=Consola.lerString("\nIndique a descrição da manutenção:  ");
                            double custo=Consola.lerDouble("\nIndique o custo da manutenção: ",0.0,9999999.9);
                            Calendar data_reg=GregorianCalendar.getInstance();
                            do 
                            {
                                do 
                                {
                                    int nif=Consola.lerInt("Indique o NIF do funcionário responsável pela manutenção: ",1,999999999); //pede o nif do funcionario que esta a registar a manutenção.
                                    pos=g.pesquisar_funcionario(nif);
                                    if(pos==-1) //caso o nif nao exista, imprime mensagem de erro e volta a pedir o nif.
                                        System.err.println("O NIF introduzido não está associado a nenhum funcionário! Introduza novamente!\n");
                                }while(pos==-1);
                                if(g.obter_funcionario(pos).getFuncao().equalsIgnoreCase("tecnico")==false) 
                                    //imprime mensagem de erro caso o funcionario nao seja "tecnico".
                                    System.err.println("Este funcionário não é técnico, logo não pode registar reparações!\nIntroduza novo funcionário\n");
                            }while(g.obter_funcionario(pos).getFuncao().equalsIgnoreCase("tecnico")==false); //o programa fica preso neste loop ate ser introduzido um nif de um funcionario com a função de "tecnico".                  
                            Funcionario f=g.obter_funcionario(pos);  
                            Manutencao m=new Manutencao(descricao,data_reg,f,v,custo);
                            g.registar_manutencao(m); 
                            v.adicionar_manutencao(m);
                            v.setData_ultima_manutencao(data_reg);
                            double custo_atual=v.getTipo().getCusto(); // Vai buscar o custo existente no tipo de veiculo onde este veiculo pertence 
                            v.getTipo().setCusto(custo_atual+custo); // Adiciona o custo desta manutenção ao custo existente no tipo de veiculo
                            g.alterar_estado_veiculo_ocorrencia(v);
                            g.veiculos_man_atraso(); // Verifica o numero de veiculos com manutenção em atraso
                            break;
                        case 2:
                            estado="Irreparável";
                            v.setEstado("Irreparável");
                            break;
                        default:
                            break;
                    }
                    g.alterar_estado_ocorrencia(pos_ocorrencia,estado);
                }
            }
        }
        else
            System.err.println("Não existem ocorrencias registadas!\n");           
    }
    public static void consultar_ocorrencia() 
    {
        int pos,numero_chassi;
        if(g.numero_ocorrencias()!=0) //apenas pede dados caso existam ocorrencias inseridas no sistema.
        {
            do 
            {
                numero_chassi=Consola.lerInt("Indique o número de chassi do veículo: ",1,9999999);
                pos=g.pesquisar_veiculo(numero_chassi);
                if(pos==-1)
                    System.err.println("O número de chassi introduzido não está associado a nenhum veículo! Introduza novamente!\n");
            }while(pos==-1);
            Veiculo v=g.obter_veiculo(pos);
            System.out.println(v.mostrar_ocorrencias()); // imprime todas as ocorrências do veiculo indicado
        }
        else
            System.err.println("Não existem ocorrencias registadas!\n");
    }
    public static void registar_manutencao()
    {
        if(g.numero_veiculos()!=0) //apenas pede dados caso existam veiculos inseridos no sistema
        {
            Calendar data_reg=GregorianCalendar.getInstance(); //a data da manutenção fica com a data que foi efetuada        
            String descricao;
            Funcionario f;
            Veiculo v;
            int nif,num_chassi,pos;
            double custo=0.0;
            descricao=Consola.lerString("Indique a descrição da manutenção:  ");
            do 
            {
                do 
                {
                    nif=Consola.lerInt("Indique o NIF do funcionário responsável pela manutenção: ",1,999999999); //pede o nif do funcionario que esta a registar a manutenção.
                    pos=g.pesquisar_funcionario(nif);
                    if(pos==-1) //caso o nif nao exista, imprime mensagem de erro e volta a pedir o nif.
                        System.err.println("O NIF introduzido não está associado a nenhum funcionário! Introduza novamente!\n");
                }while(pos==-1);
                if(g.obter_funcionario(pos).getFuncao().equalsIgnoreCase("tecnico")==false) 
                     //imprime mensagem de erro caso a funçao do funcionario a registar o veiculo nao seja "tecnico".
                    System.err.println("Este funcionário não é técnico, logo não pode introduzir veiculos!\nIntroduza novo funcionário\n");
            }while(g.obter_funcionario(pos).getFuncao().equalsIgnoreCase("tecnico")==false); //o programa fica preso neste loop ate ser introduzido um nif de um funcionario com a função de "tecnico".                  
            f=g.obter_funcionario(pos);
            do 
            {
                num_chassi=Consola.lerInt("Indique o número de chassi do veículo associado à manutenção: ",1,999999999);
                pos=g.pesquisar_veiculo(num_chassi);
                if(pos==-1) 
                    System.err.println("O número de chassi introduzido não está associado a nenhum veículo! Introduza novamente!\n");
            }while(pos==-1);
            v=g.obter_veiculo(pos);
            custo=Consola.lerDouble("Indique o custo da manutenção: ",0.0,9999999.9);
            Manutencao m=new Manutencao(descricao,data_reg,f,v,custo);
            g.registar_manutencao(m);
            v.adicionar_manutencao(m);
            v.setData_ultima_manutencao(data_reg);
            double custo_atual=v.getTipo().getCusto(); // Vai buscar o custo existente no tipo de veiculo onde este veiculo pertence
            v.getTipo().setCusto(custo_atual+custo);  // Adiciona o custo desta manutenção ao custo existente no tipo de veiculo   
            g.veiculos_man_atraso(); // Verifica o numero de veiculos com manutenção em atraso
            System.out.println("\nManutenção registada com sucesso em: "+data_reg.get(Calendar.DATE)+"/"+(data_reg.get(Calendar.MONTH)+1)+"/"+data_reg.get(Calendar.YEAR)+"\n");        
        }
        else
            System.err.println("Não existem veiculos inseridos no sistema!\n");
    }
    public static void consultar_manutencao() 
    {
        int pos,numero_chassi;
        if(g.numero_manutencoes()!=0)
        {
            do 
            {
                numero_chassi=Consola.lerInt("Indique o número de chassi do veículo: ",1,9999999);
                pos=g.pesquisar_veiculo(numero_chassi);
                if(pos==-1)
                    System.err.println("O número de chassi introduzido não está associado a nenhuma manutenção! Introduza novamente!\n");
            }while(pos==-1);
            Veiculo v=g.obter_veiculo(pos);
            System.out.println(v.mostrar_manutencoes()); //imprime todas as ocorrencias do veiculo indicado
            if(g.verificar_datas(v)==1)
                System.err.println("Este veículo não realiza manutenções há mais de um ano!");
        }
        else
            System.err.println("Não existem manutenções inseridos no sistema!\n");
    }
}
