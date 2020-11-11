package projeto_final;
import java.io.Serializable;
import java.util.Calendar;
/**
 *
 * @author Artifex
 */
public class Funcionario implements Serializable
{
    private int nif;
    private String nome;
    private String morada;
    private int telefone;
    private String funcao;
    private Calendar data_nasc;
    
    public Funcionario(int nif,String nome,String morada,int telefone,String funcao,Calendar data_nasc)
    {
        this.nif=nif;
        this.nome=nome;
        this.morada=morada;
        this.telefone=telefone;
        this.funcao=funcao;
        this.data_nasc=data_nasc;
    }
    public int getNif() 
    {
        return nif;
    }
    public void setNif(int nif) 
    {
        this.nif=nif;
    }
    public String getNome() 
    {
        return nome;
    }
    public void setNome(String nome) 
    {
        this.nome=nome;
    }
    public String getMorada() 
    {
        return morada;
    }
    public void setMorada(String morada) 
    {
        this.morada=morada;
    }
    public int getTelefone() 
    {
        return telefone;
    }
    public void setTelefone(int telefone) 
    {
        this.telefone=telefone;
    }
    public String getFuncao() 
    {
        return funcao;
    }
    public void setFuncao(String funcao) 
    {
        this.funcao=funcao;
    }
    public Calendar getData_nasc() 
    {
        return data_nasc;
    }
    public void setData_nasc(Calendar data_nasc) 
    {
        this.data_nasc=data_nasc;
    }
    public int calcularAnos() 
    {
        int anos;
        Calendar dataAtual=Calendar.getInstance();
        anos=dataAtual.get(Calendar.YEAR)-data_nasc.get(Calendar.YEAR);
        if (dataAtual.get(Calendar.DAY_OF_YEAR)<data_nasc.get(Calendar.DAY_OF_YEAR))
            anos--;
        return anos;
    } 
    @Override
    public String toString() 
    {
        StringBuilder str=new StringBuilder();
        str.append("Funcionário:\n");
        str.append("\nNome: ").append(nome);
        str.append("\nNIF: ").append(nif);
        str.append("\nMorada: ").append(morada);
        str.append("\nTelefone: ").append(telefone);
        str.append("\nFunção: ").append(funcao);
        str.append("\nData de nascimento: ");
        str.append(data_nasc.get(Calendar.DATE)).append("/");
        str.append((data_nasc.get(Calendar.MONTH) + 1)).append("/");
        str.append(data_nasc.get(Calendar.YEAR));       
        return str.toString(); 
    } 
}