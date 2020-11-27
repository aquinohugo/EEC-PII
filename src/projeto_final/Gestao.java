package projeto_final;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Gestao 
{
    private ArrayList<Tipo_veiculo> tipos_veiculos = new ArrayList<>();
    private ArrayList<Veiculo> veiculos = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Candidatura> candidaturas = new ArrayList<>();
    private ArrayList<Ocorrencia> ocorrencias = new ArrayList<>();
    private ArrayList<Manutencao> manutencoes = new ArrayList<>();
    private ArrayList<n_cand_mes> cand_mes = new ArrayList<>();
    private int num_atraso;
    private static int num_avarias;
    private static int numero_sequencial_candidaturas; //variavel que guarda o numero único da candidatura
    
    /**
     * Método que permite adicionar um tipo de veiculo na lista de tipo de veiculos
     *
     * @param tv recebe o tipo de veiculo a inserir na lista
     */
    public void adicionar_tipo(Tipo_veiculo tv) {
        if (tipos_veiculos.isEmpty()) {
            tv.setNumero(1);
        } else {
            tv.setNumero(tipos_veiculos.size() + 1);
        }
        tipos_veiculos.add(tv);
    }
   
    /**
     * Método que permite pesquisar o tipo de veiculo
     *
     * @param numero recebe um numero do tipo de veiculo
     * 
     * @return devolve o numero da posição desse tipo de veiculo, na lista do tipo de veiculos
     */
    public int pesquisar_tipo_veiculo_numero(int numero) {
        for (int i = 0; i < tipos_veiculos.size(); i++) {
            if (tipos_veiculos.get(i).getNumero() == numero) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Método que permite adicionar um veiculo na lista de veiculos
     *
     * @param v2 recebe o veiculo a inserir na lista
     */
    public void adicionar_veiculo(Veiculo v2) {
        veiculos.add(v2);
    }
    
    /**
     * Método que permite pesquisar veiculos pelo numero de chassi
     *
     * @param numero_chassis recebe um numero de chassi
     * 
     * @return devolve o numero da posição desse veiculo, na lista de veiculos
     */
    public int pesquisar_veiculo(int numero_chassis) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getNumero_chassis() == numero_chassis) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Método que obtém o número total de veiculos
     *
     * @return devolve o número total de veiculos
     */
    public int numero_veiculos() {
        return veiculos.size();
    }
    
    /**
     * Método que obtém o número total de funcionários
     *
     * @return devolve o número total de funcionários
     */ 
    public int numero_funcionarios() {
        return funcionarios.size();

    }
    
    /**
     * Método que permite adicionar um funcionário na lista de funcionários
     *
     * @param f recebe um funcionário a inserir na lista
     */
    public void registar_funcionario(Funcionario f) {
        funcionarios.add(f);
    }

    /**
     * Método que permite pesquisar funcionários pelo nif
     *
     * @param nif recebe um nif
     * 
     * @return devolve o numero da posição desse funcionário, na lista de funcionário
     */    
    public int pesquisar_funcionario(int nif) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNif() == nif) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Método que obtém o número total de candidaturas
     *
     * @return devolve o número total de candidaturas
     */ 
    public int numero_candidaturas() {
        return candidaturas.size();
    }

    /**
     * Método que permite verificar se um determinado funcionário tem candidaturas registadas, pelo nif do funcionário
     *
     * @param nif recebe um nif
     * 
     * @return devolve o numero da posição da lista de candidaturas
     */     
    public int consultar_candidaturas_por_nif_funcionario(int nif) {
        for (int i = 0; i < candidaturas.size(); i++) {
            if (candidaturas.get(i).getFunc().getNif() == nif) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Método que permite obter todas as candidaturas realizadas por um determinado funcionário
     *
     * @param nif recebe um nif
     * 
     * @return devolve o toString da candidatura
     */     
    public String obter_candidaturas_por_nif_funcionario(int nif) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < candidaturas.size(); i++) {
            if (candidaturas.get(i).getFunc().getNif() == nif) {
                str.append(candidaturas.get(i)).append("\n\n");
            }
        }
        return str.toString();
    }
    
    /**
     * Método que permite registar uma candidatura.
     * Caso a variável validacao seja =1, registamos a candidatura completa. Isto é: com veiculo, data inicio e fim.
     * Caso a variável validacao seja =0, registamos a candidatura incompleta. Isto é: sem veiculo, data inicio e fim.
     *
     * @param c, recebe uma candidatura;
     * @param v, recebe um veiculo;
     * @param data_inicio, recebe uma data inicio da candidatura;
     * @param data_fim, recebe uma data fim da candidatura;
     * @param validacao, recebe uma validação.
     * 
     */
    public void registar_candidatura(Candidatura c, Veiculo v, Calendar data_inicio, Calendar data_fim, int validacao) {
     //   int posicao_ultima_cand;
        if (candidaturas.isEmpty()) {
            numero_sequencial_candidaturas=1;
            c.setNumero(1);
        } else {
            numero_sequencial_candidaturas++;
             c.setNumero(numero_sequencial_candidaturas);
      //   posicao_ultima_cand = candidaturas.size()-1;
       //  c.setNumero(candidaturas.get(posicao_ultima_cand).getNumero()+1);
            //c.setNumero(candidaturas.size() + 1);
        }
        
        if (validacao == 1) {            
            candidaturas.add(c);
            c.setData_inicio_aluguer(data_inicio);
            c.setData_fim_aluguer(data_fim);
            int pos = pesquisar_veiculo(v.getNumero_chassis());
            //veiculos.get(pos).setEstado("Alugado");
            c.setVeiculo(v);
        } else // validacao=0
        {
            candidaturas.add(c);
            
        }
    }
  
    /**
     * Método que permite obter o numero da primeira posição que for encontrada de uma candidatura realizadas numa determinada data
     * Caso encontre, significa que existe pelo menos uma candidatura realizada nessa determinada data;
     * Caso nao encontre, significa que nao existe nenhuma candidatura realizada nessa determinada data, imprimindo assim uma mensagem de erro.
     *
     * @param data_candidatura recebe uma data de candidatura
     * 
     * @return devolve a primeira posição que for encontrada de uma candidatura realizadas numa determinada data
     */    
    public int consultar_candidaturas(Calendar data_candidatura) {
        for (int i = 0; i < candidaturas.size(); i++) {
            if (candidaturas.get(i).getData_candidatura().get(Calendar.YEAR) == data_candidatura.get(Calendar.YEAR)
                    && candidaturas.get(i).getData_candidatura().get(Calendar.MONTH) == data_candidatura.get(Calendar.MONTH)
                    && candidaturas.get(i).getData_candidatura().get(Calendar.DATE) == data_candidatura.get(Calendar.DATE)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Método que permite verificar se a data de inicio de aluguer nao é inferior a data atual.
     * Caso seja inferior, devolve 1
     * Caso nao seja inferior devolve -1
     *
     * @param data_inicio recebe uma data de inicio de aluguer
     * 
     * @return devolve 1 para inferior ou -1 quando não é inferior
     */    
    public int compara_data_atual(Calendar data_inicio) {
        int var_erro;

        if(data_inicio.get(Calendar.YEAR) > GregorianCalendar.getInstance().get(Calendar.YEAR))
            var_erro = -1; //sinfiica que a data de inicio de aluguer é superior a data atual, logo devolve -1 (SEM erro)
        else{
            if(data_inicio.get(Calendar.YEAR) < GregorianCalendar.getInstance().get(Calendar.YEAR))
                var_erro = 1; //sinfiica que a data de inicio de aluguer é inferior a data atual, logo devolve 1 (COM erro)
            else//sinifica que as datas tem o ano igual. Logo vamos comparar a diferença de dias para ver qual é a maior.
            {
                if(data_inicio.get(Calendar.DAY_OF_YEAR) > GregorianCalendar.getInstance().get(Calendar.DAY_OF_YEAR)
                ||data_inicio.get(Calendar.DAY_OF_YEAR) == GregorianCalendar.getInstance().get(Calendar.DAY_OF_YEAR) )
                    var_erro = -1; //significa que a data de inicio de aluguer é superior a data de fim de aluguer ou é o próprio dia.
                else
                    var_erro = 1;
            }      
        }              
       return var_erro; 
    }

    /**
     * Método que permite obter todas as candidaturas realizadas numa determinada data
     *
     * @param data_candidatura recebe uma data de candidatura
     * 
     * @return devolve o toString da candidatura
     */
    public String mostrar_candidaturas_data(Calendar data_candidatura) {
        StringBuilder str = new StringBuilder();
        if (candidaturas.isEmpty()) {
            str.append("Não há candidaturas inseridas!");
        } else {
            for (int i = 0; i < candidaturas.size(); i++) {
                if (candidaturas.get(i).getData_candidatura().get(Calendar.YEAR) == data_candidatura.get(Calendar.YEAR)
                && candidaturas.get(i).getData_candidatura().get(Calendar.MONTH) == data_candidatura.get(Calendar.MONTH)
                && candidaturas.get(i).getData_candidatura().get(Calendar.DATE) == data_candidatura.get(Calendar.DATE)) {
                    str.append(candidaturas.get(i)).append("\n\n");
                }
            }
        }
    return str.toString ();
    }   
    
    /**
     * Método que permite obter a posição da candidatura pelo numero sequencial da candidatura
     *
     * @param numero recebe um numero de uma candidatura
     * 
     * @return devolve a posição dessa candidatura, na lista de candidaturas.
     */    
    public int pesquisar_candidatura(int numero) {
        for (int i = 0; i < candidaturas.size(); i++) {
            if (candidaturas.get(i).getNumero() == numero) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     *Método que permite validar o estado da candidatura
     * @param numero_chassi
     * @return
     */
    public int validacao_estado_candidatura(int numero_chassi){
        int pos,validacao;
        
       pos = pesquisar_veiculo(numero_chassi);
       if((veiculos.get(pos).getEstado().equalsIgnoreCase("Disponivel"))
       ||(veiculos.get(pos).getEstado().equalsIgnoreCase("Alugado")))
       {
           validacao = 1;
       }
       else
           validacao = -1;
        
        
        return validacao;
    }
    
    /**
     * Método que permite verificar se a data de inicio de aluguer nao é superior a data de fim de aluguer.
     * Este método, devolve ainda a diferença de meses entre a data de inicio e fim de aluguer, para depois verificar se o tempo
     * de aluguer nao exede os 6 meses máximos.
     *
     * @param data_inicio recebe uma data inicio de alguer;
     * @param data_fim recebe uma data fim de alguer.
     * 
     * @return devolve a diferença de dias entre as duas datas, ou "-1" caso a data de inicio
     * seja superior a data de fim de aluguer.
     */  
    public int calculo_protecao_candidatura(Calendar data_inicio, Calendar data_fim) {
        if (data_fim.compareTo(data_inicio) == -1)//primeiro verifica se a data de fim é superior a data de inicio.
        {
            return -1; //caso nao seja, devolve o valor -1
        } else //se se verificar que a data de fim é superior a de inicio, vamos verificar se nao exede os 6 meses.
        {
            int difMes = data_fim.get(Calendar.MONTH) - data_inicio.get(Calendar.MONTH);
            int difMesAno = ((data_fim.get(Calendar.YEAR) - data_inicio.get(Calendar.YEAR)) * 12);
            int total = difMesAno + difMes;
            if (data_fim.get(Calendar.DATE) < data_inicio.get(Calendar.DATE)) {
                total--;
            }
            return total;
        }
    }

    /**
     * Método que permite mostrar APENAS os veiculos disponíveis num intervalo de datas (entre data inicio e data fim de aluguer)
     * 
     * @param data_inicio recebe uma data inicio de alguer;
     * @param data_fim recebe uma data fim de alguer.
     * @param pos recebe a posição da lista de tipo de veiculos, conrespondente ao tipo de veiculo inserido pelo utilizador
     * para facilitar a pesquisa.
     * 
     * @return devolve o toString de veiculos
     */      
    public String mostrar_veiculos_candidatura(Calendar data_inicio, Calendar data_fim, int pos) {
        StringBuilder str = new StringBuilder();
        int var = 0;
        if (veiculos.isEmpty() == true) {
            str.append("Não há veiculos inseridos!");
        } else {
            for (int i = 0; i < tipos_veiculos.get(pos).getVeiculos().size(); i++) //percorre o array de veiculos
            {
                if (candidaturas.isEmpty() == true) { //caso o array de candidaturas esteja vazio, imprime todos os veiculos do tipo inserido.
                    //precisa de estar aqui, caso contrário se formos fazer o ciclo for com o candidaturas.size() quando é nulo, dá bronca.
                    str.append("Veículo: ").append(tipos_veiculos.get(pos).getVeiculos().get(i)).append("\n\n");
                } else {
                    var = 0;
                    int n_chassis = tipos_veiculos.get(pos).getVeiculos().get(i).getNumero_chassis(); //vai buscar o numero de chassis do veiculo

                    for (int aux = 0; aux < candidaturas.size(); aux++)//percorre o array de candidaturas
                    {
                        if(candidaturas.get(aux).getEstado().equalsIgnoreCase("Aprovada")) //caso a candidatura nao seja aprovada, nao vai comparar os numeros de chassis, pois iria dar erro
                        {                                                                  //porque nos casos Pendente e Reprovado o numero de chassi é nulo
                            if (candidaturas.get(aux).getVeiculo().getNumero_chassis() == n_chassis) //compara o numero de chassis do veiculo do array veiculo com o numero do chassis do array candidaturas do veiculo
                            {
                                //caso seja encontrado o numero do chassis do veiculo escolhido para fazer o aluguer, vamos dentro deste if
                                //verificar se as datas de aluguer sobrepoem-se uma à outra
                                if (candidaturas.get(aux).getData_inicio_aluguer().compareTo(data_fim) == -1 && (candidaturas.get(aux).getData_fim_aluguer().compareTo(data_inicio)) == 1) {
                                    var = 1;
                                }
                            }
                        }
                    }
                    if (var == 0) {
                        str.append("Veículo: ").append(tipos_veiculos.get(pos).getVeiculos().get(i)).append("\n\n");
                    }
                }
            }
        }
        return str.toString();
    }

    /**
     * Método que permite validar se realmente o veiculo introduzido está disponível num determinado intervalo
     * de datas introduzido pelo utilizador (data inicio e data de fim de aluguer)
     * 
     * @param pos recebe a posição da lista de tipo de veiculos, conrespondente ao tipo de veiculo inserido pelo utilizador
     * para facilitar a pesquisa;
     * @param num_chassis recebe o numero de chassi;
     * @param data_inicio recebe uma data inicio de alguer;
     * @param data_fim recebe uma data fim de alguer.
     * 
     * @return validacao
     */     
    public int protecao_candidatura(int pos, int num_chassis, Calendar data_inicio, Calendar data_fim) {
        int validacao = 0; //caso validacao==1 significa que o carro está disponivel para alugar nesta data
        //caso validacao ==-1 significa que o carro NAO está disponivel para alugar nesta data

        if (veiculos.isEmpty() == true) {

        } else {

            if (candidaturas.isEmpty() == true) { //caso o array de candidaturas esteja vazio, imprime todos os veiculos do tipo inserido.
                //precisa de estar aqui, caso contrário se formos fazer o ciclo for com o candidaturas.size() quando é nulo, dá bronca.
                validacao = 1;
            } else {
                validacao = 1;

                for (int aux = 0; aux < candidaturas.size(); aux++)//percorre o array de candidaturas
                {
                    if(candidaturas.get(aux).getEstado().equalsIgnoreCase("Aprovada")) //caso a candidatura nao seja aprovada, nao vai comparar os numeros de chassis, pois iria dar erro
                    {                                                                  //porque nos casos Pendente e Reprovado o numero de chassi é nulo
                        if (candidaturas.get(aux).getVeiculo().getNumero_chassis() == num_chassis) //compara o numero de chassis do veiculo do array veiculo com o numero do chassis do array candidaturas do veiculo
                        {
                            //caso seja encontrado o numero do chassis do veiculo escolhido para fazer o aluguer, vamos dentro deste if
                            //verificar se as datas de aluguer sobrepoem-se uma à outra
                            if (candidaturas.get(aux).getData_inicio_aluguer().compareTo(data_fim) == -1 && (candidaturas.get(aux).getData_fim_aluguer().compareTo(data_inicio)) == 1) {
                                validacao = -1;
                            }
                        }
                    }
                }

            }
        }
        return validacao;
    }
   /**
     * Método que permite verificar se o veiculo reparado, estava a ser alugado ou se estava disponível
     * Se estava alugado, vamos meter o estado para alugado
     * Se não estava alugado, vai ficar disponível
     * @param v
     */
    public void alterar_estado_veiculo_ocorrencia(Veiculo v) {
        int n_chassi = v.getNumero_chassis();
        int i,incremento=0;
        if (candidaturas.isEmpty() == false) { //caso a lista de candidaturas nao esteja vazia, faz as seguntes verificações
            for (i = 0; i < candidaturas.size(); i++) { //percorre o array de candidaturas
                //procura pelo veiculo no array das candidaturas
                if(candidaturas.get(i).getEstado().equalsIgnoreCase("Aprovada")) { //so verifica chassi== caso a candidatura seja aprovada
                                                                                   //porque caso nao esteja aprovada, o n_chassi está a nulo.
                    if (candidaturas.get(i).getVeiculo().getNumero_chassis() == n_chassi) {
                        incremento=0;//caso o numero de chassi seja encontrado na lista de candidaturas, a variavel incremento é reiniciada.
                        //caso econtre, vai verificar se está a ser atualmente alugado
                        Calendar data_atual = new GregorianCalendar(GregorianCalendar.getInstance().get(Calendar.YEAR),
                                GregorianCalendar.getInstance().get(Calendar.MONTH),
                                GregorianCalendar.getInstance().get(Calendar.DATE));
                        if (candidaturas.get(i).getData_inicio_aluguer().compareTo(data_atual) == -1 && (candidaturas.get(i).getData_fim_aluguer().compareTo(data_atual)) == 1) {
                            //caso econtre, vai meter o estado como alugado pois o aluguer esta a decorrer
                            v.setEstado("Alugado");                          
                        } else {//caso econtre, vai meter o estado como disponivel pois nao esta a decorrer aluguer esta a decorrer
                            v.setEstado("Disponivel");
                        }
                    }
                    else //caso o numero de chassi nao seja encontrado na lista de candidaturas, vamos incrementar a variavel.
                        incremento++;      
                }
                else //caso o numero de chassi nao seja encontrado na lista de candidaturas, vamos incrementar a variavel.
                    incremento++;

            }
            if(incremento==i) //no final de percorrer a lista de candidaturas, caso o numero de chassi nunca tenha sido
            {                                  //encontrado na lista, significa que o veiculo nao estava a ser alugado, portanto o estado dele 
                                               //tem de passar a alugado. Isso é verificado caso a variavel incremento esteja com o mesmo valor
                                               //do numero de candidaturas.
                v.setEstado("Disponivel");
            }
        } else //caso nao existam candidaturas, o veiculo passa logo a disponivel
        {
            v.setEstado("Disponivel");
        }
    }

    /**
     * Método que permite verificar o estado da candidatura. Esta função é chamada no menu principal do programa e no menu de candidaturas
     * Tem a função de alterar o estado do veiculo de alugado para disponivel, quando o aluguer chega ao fim,
     * alterar o estado do veiculo de disponivel para alugado quando chegar a data de inicio de candidatura,
     * remover a candidatura, caso o veiculo nao se encontre disponivel no dia de inicio do aluguer.
     * 
     */     
    public void verificar_estado_cand() {
        if (candidaturas.isEmpty() == false) {
            for (int i = 0; i < candidaturas.size(); i++) { //percorre o array de candidaturas.
                //verifica se a data do inicio do aluguer é a data de hoje. Ou seja, se o aluguer começa hoje.
                if (candidaturas.get(i).getEstado().equalsIgnoreCase("Aprovada")) {
                    if (candidaturas.get(i).getData_inicio_aluguer().get(Calendar.YEAR) == GregorianCalendar.getInstance().get(Calendar.YEAR)
                            && candidaturas.get(i).getData_inicio_aluguer().get(Calendar.MONTH) == GregorianCalendar.getInstance().get(Calendar.MONTH)
                            && candidaturas.get(i).getData_inicio_aluguer().get(Calendar.DATE) == GregorianCalendar.getInstance().get(Calendar.DATE)) {
                        //Caso o aluguer comece hoje, vamos verificar se o veiculo que vai ser alugado se econtre disponivel.
                        if ((candidaturas.get(i).getVeiculo().getEstado().equalsIgnoreCase("Disponivel") == false)
                                && (candidaturas.get(i).getVeiculo().getEstado().equalsIgnoreCase("Alugado") == false)) {
                            //caso nao se econtre disponivel e nao esteja alugada, remove a candidatura!
                            //porque singifica que o veiculo esta por reparar ou irreparavel.
                            candidaturas.remove(i);
                        } else {//caso esteja disponível, mete a alugado
                            candidaturas.get(i).getVeiculo().setEstado("Alugado");
                        }                       

                    }
                    Calendar data_atual = new GregorianCalendar(GregorianCalendar.getInstance().get(Calendar.YEAR),
                        GregorianCalendar.getInstance().get(Calendar.MONTH),
                        GregorianCalendar.getInstance().get(Calendar.DATE));
                    if(candidaturas.get(i).getData_inicio_aluguer().compareTo(data_atual) == -1 && (candidaturas.get(i).getData_fim_aluguer().compareTo(data_atual)) == 1
                            && candidaturas.get(i).getEstado().equalsIgnoreCase("Disponivel"))
                        //caso a data de hoje esteja dentro do intervalo de aluguer, e o veiculo esteja disponível mete o estado do veiculo para alugado
                    {
                        candidaturas.get(i).getVeiculo().setEstado("Alugado");
                        
                    }
                    //verifica se a data do fim do aluguer é a data de hoje. Ou seja, se o aluguer acaba hoje.
                    if (candidaturas.get(i).getData_fim_aluguer().get(Calendar.YEAR) == GregorianCalendar.getInstance().get(Calendar.YEAR)
                            && candidaturas.get(i).getData_fim_aluguer().get(Calendar.MONTH) == GregorianCalendar.getInstance().get(Calendar.MONTH)
                            && candidaturas.get(i).getData_fim_aluguer().get(Calendar.DATE) == GregorianCalendar.getInstance().get(Calendar.DATE)) {
                        //Caso o aluguer acabe hoje, vamos verificar se o veiculo está Alugado.
                        if (candidaturas.get(i).getVeiculo().getEstado().equalsIgnoreCase("Alugado")) {//Caso esteja significa que nao tem ocorrencia nenhuma por isso vai ficar disponivel.
                            candidaturas.get(i).getVeiculo().setEstado("Disponivel");

                        }
                    }
                }
            }
        }
    }
    
    /**
     * Método que permite aprovar uma candidatura, depois de esta ter sido registada como pendente
     * 
     * @param pos recebe a posição da lista de candidaturas;
     * @param data_inicio_aluguer recebe uma data inicio de alguer;
     * @param data_fim_aluguer recebe uma data fim de alguer;
     * @param v recebe o veiculo a alugar.
     * 
     */         
    public void aprovar_candidatura(int pos, Calendar data_inicio_aluguer, Calendar data_fim_aluguer, Veiculo v) {
        candidaturas.get(pos).setEstado("Aprovada");
        candidaturas.get(pos).setData_inicio_aluguer(data_inicio_aluguer);
        candidaturas.get(pos).setData_fim_aluguer(data_fim_aluguer);
        int x = pesquisar_veiculo(v.getNumero_chassis());
       // veiculos.get(x).setEstado("Alugado");
        candidaturas.get(pos).setVeiculo(v);
    }
    /**
     * Método que permite remover uma candidatura
     * 
     * @param pos recebe a posição da candidatura.
     */  
    public void remover_candidatura(int pos) {
        candidaturas.remove(pos);
    }
    
    /**
     * Método que obtém o número total de ocorrencias
     *
     * @return devolve o número total de ocorrencias
     */
    public int numero_ocorrencias() {
        return ocorrencias.size();
    }

    /**
     * Método que permite registar uma ocorrencia
     *
     * @param oc recebe a ocorrencia
     * @param num_chassi recebe o numero de chassi do veiculo sujeito à ocorrencia
     */    
    public void registar_ocorrencia(Ocorrencia oc, int num_chassi) {
        int pos = 0;
        if (ocorrencias.isEmpty()) {
            oc.setNumero(1);
        } else {
            oc.setNumero(ocorrencias.size() + 1);
        }
        if (oc.estado.equalsIgnoreCase("Por Reparar")) { //caso o estado da ocorrencia que se esta a registar seja "Por Reparar"
            pos = pesquisar_veiculo(num_chassi); //vamos buscar a posicao do veiculo a registar ao array de veiculos
            veiculos.get(pos).setEstado("Por Reparar"); //e colocar o estado dele a "Por reparar"
        }
        if (oc.estado.equalsIgnoreCase("Irreparável")) { //caso o estado da ocorrencia que se esta a registar seja "Irreparável"
            pos = pesquisar_veiculo(num_chassi); //vamos buscar a posicao do veiculo a registar ao array de veiculos
            veiculos.get(pos).setEstado("Irreparável"); //e colocar o estado dele a "Irreparável"
        }
        if (veiculos.get(pos).getOcorrencias().isEmpty()) {
            num_avarias++; // Incrementa a variavel num_avarias caso o arraylist de ocorrencias do veiculo esteja vazio
        }
        ocorrencias.add(oc); //adiciona occorrencia 
    }

    /**
     * Método que permite obter a posição da ocorrencia na lista de ocorrencias pelo o número da ocorrencia
     *
     * @param numero recebe o numero da ocorrencia
     * 
     * @return devolve o número da posição da ocorrencia na lista de ocorrencias
     */    
    public int pesquisar_ocorrencia(int numero) {
        for (int i = 0; i < ocorrencias.size(); i++) {
            if (ocorrencias.get(i).getNumero() == numero) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Método que permite alterar o estado da ocorrencia
     *
     * @param pos recebe a posição da ocorrencia na lista de ocorrencias
     * @param estado recebe o estado da ocorrencia
     */    
    public void alterar_estado_ocorrencia(int pos, String estado) {
        ocorrencias.get(pos).setEstado(estado);
    }
    
    /**
     * Método que permite registar uma manutenção
     *
     * @param m recebe uma manutenção
     */
    public void registar_manutencao(Manutencao m) {
        if (manutencoes.isEmpty()) {
            m.setNumero(1);
        } else {
            m.setNumero(manutencoes.size() + 1);
        }
        manutencoes.add(m);
    }
  
    /**
     * Método que obtém o número total de manutencoes
     *
     * @return devolve o número total de manutencoes
     */    
    public int numero_manutencoes() {
        return manutencoes.size();
    }

    /**
     * Método que obtém o número de dias entre 2 datas, data atual e a data de ultima manutenção de um veículo
     *
     * @param v recebe a variável v, variável do tipo Veículo 
     * @return devolve 1 caso a diferença de dias seja superior a 365 dias (1 ano), devolve -1 caso seja inferior a 365 
     */      
    public int verificar_datas(Veiculo v) {
        // getTimeInMillis() Dá a diferença entre datas em milisegundos
        // Converte a diferença de dias de milisegundos para dias: 1000 milisegundos por segundo, 60 segundos por minuto, 60 minutos por hora, 24 horas por dia
        Calendar data=GregorianCalendar.getInstance();
        long diferenca_dias = ((data.getTimeInMillis() - v.getData_ultima_manutencao().getTimeInMillis()) / (1000 * 60 * 60 * 24));
        if (diferenca_dias >= 365) {
            return 1;
        } else {
            return -1;
        }
    }
    
    /**
     * Método que permite mostrar os tipos de veiculos existentes
     *
     * @return devolve o toString do tipo de veiculos
     */     
    public String mostrar_tipos_veiculos() {
        StringBuilder str = new StringBuilder();
        if (tipos_veiculos.isEmpty()) {
            str.append("Não há veículos inseridos!");
        } else {
            for (int i = 0; i < tipos_veiculos.size(); i++) {
                str.append("Tipo Veículo: ").append(tipos_veiculos.get(i)).append("\n\n");
            }
        }
        return str.toString();
    }

    /**
     * Método que permite obter o tipo de veiculo pelo numero de tipo de veiculo introduzido pelo utilizador
     *
     * @param pos
     * @return devolve o tipo de veiculo
     */     
    public Tipo_veiculo obter_tipo_veiculo(int pos) {
        return tipos_veiculos.get(pos);
    }

    /**
     * Método que obtém o número total de tipo de veiculos
     *
     * @return devolve o número total de tipo de veiculos
     */      
    public int total_elementos_tipos_veiculos() {
        return tipos_veiculos.size();
    }
    
    /**
     * Método que retorna o veiculo, pela posição do veiculo na lista de veiculos
     *
     * @param pos recebe a posição do veiculo na lista de veiculos
     * 
     * @return devolve o veiculo conrespondente a posição recebida
     */
    public Veiculo obter_veiculo(int pos) {
        return veiculos.get(pos);
    }
    
    /**
     * Método que retorna o funcionário, pela posição do funcionario na lista de funcionários
     *
     * @param pos recebe a posição do funcionário na lista de funcionários
     * 
     * @return devolve o funcionário conrespondente a posição recebida
     */
    public Funcionario obter_funcionario(int pos) {
        return funcionarios.get(pos);
    }

    /**
     * Método que retorna a candidatura, pela posição da candidatura na lista de candidatura
     *
     * @param pos recebe a posição da candidatura na lista de candidaturas
     * 
     * @return devolve a candidatura conrespondente a posição recebida
     */    
    public Candidatura obter_candidatura(int pos) {
        return candidaturas.get(pos);
    }
    
    /**
     * Método que retorna a ocorrencia, pela posição da ocorrencia na lista de ocorrencias
     *
     * @param pos recebe a posição da ocorrencia na lista de ocorrencias
     * 
     * @return devolve a ocorrencia conrespondente a posição recebida
     */ 
    public Ocorrencia obter_ocorrencia(int pos) {
        return ocorrencias.get(pos);
    }

    /**
     * Método que retorna a manutencão, pela posição da ocorrencia na lista de manutencões
     *
     * @param pos recebe a posição da ocorrencia na lista de manutencões
     * 
     * @return devolve a manutencão conrespondente a posição recebida
     */     
    public Manutencao obter_manutencao(int pos) {
        return manutencoes.get(pos);
    }
    
        public void registar_candidatura_mes(n_cand_mes n_cand_mes)
    {
        cand_mes.add(n_cand_mes);
    }
    
    /**
     *Método que devolve a posição da lista cand_mes, caso encontre o ano que esta a verificar
     * Se devolver -1 significa que nao encontrou o ano.
     * 
     * @param ano
     * 
     * @return
     */
    public int consultar_cand_ano(int ano)
    {
        for (int i = 0; i < cand_mes.size(); i++) {
            if(cand_mes.get(i).getAno()==ano)
                return i;
        }
        return -1;
    }
    
    /**
     *Método que devolve uma variavel do tipo n_cand_mes
     * @param pos
     * 
     * @return cand_mes
     */
    public n_cand_mes obter_cand_mes(int pos)
    {
        return cand_mes.get(pos);
    }

    // FUNÇOES ESTATISTICAS //
    
    // 1ª Função : Percentagem de veículos que já tiveram pelo menos uma avaria

    /**
     *Método que permite a percentagem de veículos que já tiveram pelo menos uma avaria
     * 
     * @return devolve percentagem de veículos que já tiveram pelo menos uma avaria
     */
    public String percentagem_veiculos() {
        double percentagem = ((double) num_avarias / veiculos.size()) * 100.0;
        StringBuilder str = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");  // Formato usado para arredondar a variável do tipo double com 2 casas decimais   
        str.append("Percentagem de veiculos que já tiveram pelo menos uma avaria: ").append(df.format(percentagem)).append(" %").append("\n\n");
        return str.toString();
    }
    
    // 2ª Função : Total de veículos com manutenção em atraso 

    /**
     *Método que permite devolver os veiculos que tem a manuteção em atraso
     * 
     * @return os veiculos que tem a manuteção em atraso
     */
    public int veiculos_man_atraso()
    {
        num_atraso=0;
        Calendar data_atual=GregorianCalendar.getInstance();
        for (int i = 0; i < veiculos.size(); i++) 
        {
            // getTimeInMillis() Dá a diferença entre datas em milisegundos
            // Converte a diferença de dias de milisegundos para dias: 1000 milisegundos por segundo, 60 segundos por minuto, 60 minutos por hora, 24 horas por dia            
            long diferenca_dias = ((data_atual.getTimeInMillis() - veiculos.get(i).getData_ultima_manutencao().getTimeInMillis()) / (1000 * 60 * 60 * 24));
            if (diferenca_dias >= 365)
                num_atraso++; // Incrementa variável sempre que a data da ultima manutenção seja superior a um ano            
        }
        return num_atraso;
    }  
    
    // 3ª Função : Custo total em manutenções por cada tipo de veículo

    /**
     *Método que permite devolver os custos totais por tipo de veiculo.
     * 
     * @return custos totais por tipo de veiculo.
     */
    public String custo_total_tipo()
    {
        StringBuilder str = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");  // Formato usado para arredondar a variável do tipo double com 2 casas decimais 
        for (int i = 0; i <tipos_veiculos.size(); i++) // Percorre o array de tipos de veiculos para imprimir todos os tipos de veiculos + custo total de cada tipo 
            str.append("Tipo Veículo: ").append(tipos_veiculos.get(i)).append("\n").append("Custo total em manutenções: ").append(df.format(tipos_veiculos.get(i).getCusto())).append(" €").append("\n\n");
        return str.toString();
    }

    // 4ª Função : Número total de candidaturas por mês num determinado ano

    /**
     *Método que permite devolver as candidaturas realizadas num determiado ano, por mes.
     * @param ano
     * @return candidaturas realizadas num determiado ano, por mes.
     */
    public String can_ano_mes(int ano) {
        StringBuilder str = new StringBuilder();
        if (cand_mes.isEmpty())
            str.append("Não há candidaturas inseridas!");
        else 
            cand_mes.get(consultar_cand_ano(ano)).toString();
        return str.toString();
    }  
    
    //*******************************************//

    /**
     *Método que grava os ficheiros quando o programa é encerrado.
     */
    public void gravar_ficheiro() {
        try // Apanha o erro que possa ocorrer durante a leitura e gravação do ficheiro 
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Projeto.dat"));
            out.writeObject(tipos_veiculos);
            out.writeObject(veiculos);
            out.writeObject(funcionarios);
            out.writeObject(candidaturas);
            out.writeObject(ocorrencias);
            out.writeObject(manutencoes);
            out.writeObject(num_avarias);
            out.writeObject(numero_sequencial_candidaturas);
            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *Método que le os ficheiros quando o programa é iniciado.
     */
    public void ler_ficheiro() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Projeto.dat"));
            tipos_veiculos = (ArrayList<Tipo_veiculo>) in.readObject();
            veiculos = (ArrayList<Veiculo>) in.readObject();
            funcionarios = (ArrayList<Funcionario>) in.readObject();
            candidaturas = (ArrayList<Candidatura>) in.readObject();
            ocorrencias = (ArrayList<Ocorrencia>) in.readObject();
            manutencoes = (ArrayList<Manutencao>) in.readObject();
            num_avarias = (Integer) in.readObject();
            numero_sequencial_candidaturas = (Integer) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
