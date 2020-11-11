package projeto_final;
import java.io.Serializable;
import java.util.Calendar;
/**
 *
 * @author Artifex
 */
public class Manutencao extends Situacao implements Serializable
{
    private  int numero;
    private double custo;
    
    public Manutencao(String descricao,Calendar data_registo,Funcionario f,Veiculo v,double custo)
    {
        super(descricao,data_registo,f,v);
        numero++;
        this.custo=custo;
    }
    
    public double getCusto() 
    {
        return custo;
    }
    public void setCusto(double custo) 
    {
        this.custo=custo;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString() 
    {
        StringBuilder str=new StringBuilder();
        str.append("Manutenção:\n");
        str.append("\nNúmero: ").append(numero);
        str.append("\nDescrição: ").append(descricao);
        str.append("\nCusto: ").append(getCusto()).append(" €");
        str.append("\nFuncionário: ");
        str.append("\nNome: ").append(f.getNome());
        str.append("\nNIF: ").append(f.getNif());
        str.append("\nVeículo: ");
        str.append("\nNúmero de chassi: ").append(v.getNumero_chassis());
        str.append("\nDesignação: ").append(v.getDesignacao());
        str.append("\nData de candidatura: ");
        str.append(data_registo.get(Calendar.DATE)).append("/");
        str.append((data_registo.get(Calendar.MONTH)+1)).append("/");
        str.append(data_registo.get(Calendar.YEAR));         
        return str.toString(); 
    }    

}
