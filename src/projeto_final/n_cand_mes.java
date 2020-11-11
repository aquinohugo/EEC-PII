package projeto_final;

import java.io.Serializable;

/**
 *
 * @author Artifex
 */
public class n_cand_mes implements Serializable
{
    private int ano,mes;
    private int[] n_candidaturas = new int[12];
    
    public n_cand_mes(int ano,int mes)
    {
        this.ano=ano;
        this.mes=mes;
        n_candidaturas[mes]=n_candidaturas[mes]+1;
    }
    public int getAno() 
    {
        return ano;
    }
    public void setMes(int mes) 
    {
        this.mes=mes;
    }
    @Override
    public String toString() 
    {
        StringBuilder str=new StringBuilder();     
        str.append("\nTotal de Candidaturas Registadas no Ano ").append(ano);
        str.append("\nJaneiro: ").append(n_candidaturas[0]);
        str.append("\nFevereiro: ").append(n_candidaturas[1]);
        str.append("\nMarço: ").append(n_candidaturas[2]);
        str.append("\nAbril: ").append(n_candidaturas[3]);
        str.append("\nMaio: ").append(n_candidaturas[4]);
        str.append("\nJunho: ").append(n_candidaturas[5]);
        str.append("\nJulho: ").append(n_candidaturas[6]);
        str.append("\nAgosto: ").append(n_candidaturas[7]);
        str.append("\nSetembro: ").append(n_candidaturas[8]);
        str.append("\nOutubro: ").append(n_candidaturas[9]);
        str.append("\nNovembro: ").append(n_candidaturas[10]); 
        str.append("\nDezembro: ").append(n_candidaturas[11]);
        return str.toString();
    }    
}
