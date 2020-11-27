package projeto_final;
import java.io.Serializable;
import java.util.Calendar;

public class Ocorrencia extends Situacao implements Serializable
{
    private int numero;
    protected String estado;
    
    public Ocorrencia(String descricao,Calendar data_registo,Funcionario f,Veiculo v,String estado)
    {
        super(descricao,data_registo,f,v);
        numero++;
        this.estado=estado;
    }
    public String getEstado() 
    {
        return estado;
    }
    public void setEstado(String estado) 
    {
        this.estado=estado;
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
        str.append("Ocorrência:\n");
        str.append("\nNúmero: ").append(getNumero());
        str.append("\nDescrição: ").append(descricao);
        str.append("\nEstado: ").append(estado);
        str.append("\nFuncionário: ");
        str.append("\nNome: ").append(f.getNome());
        str.append("\nNIF: ").append(f.getNif());
        str.append("\nVeículo: ");
        str.append("\nNúmero de chassi: ").append(v.getNumero_chassis());
        str.append("\nDesignação: ").append(v.getDesignacao());
        str.append("\nData de Ocorrencia: ");
        str.append(data_registo.get(Calendar.DATE)).append("/");
        str.append((data_registo.get(Calendar.MONTH)+1)).append("/");
        str.append(data_registo.get(Calendar.YEAR));         
        return str.toString(); 
    }    
}
