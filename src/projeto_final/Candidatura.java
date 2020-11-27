package projeto_final;
import java.io.Serializable;
import java.util.Calendar;

public class Candidatura implements Serializable
{
    private  int numero; 
    private Calendar data_candidatura;
    private String descricao,estado;
    private Funcionario func;
    private Calendar data_inicio_aluguer;
    private Calendar data_fim_aluguer;
    private Veiculo veiculo; //variavel do tipo veiculo que guarda qual é que é o veiculo alugado, na candidatura.
    
    public Candidatura(Calendar data_candidatura,String descricao,Funcionario func,String estado)
    {
        numero++;
        this.data_candidatura=data_candidatura;
        this.descricao=descricao;
        this.func=func;
        this.estado=estado;
    }
    public Calendar getData_candidatura() 
    {
        return data_candidatura;
    }
    public void setData_candidatura(Calendar data_candidatura) 
    {
        this.data_candidatura=data_candidatura;
    }
    public String getDescricao() 
    {
        return descricao;
    }
    public void setDescricao(String descricao) 
    {
        this.descricao=descricao;
    }
    public Funcionario getFunc() 
    {
        return func;
    }
    public void setFunc(Funcionario func) 
    {
        this.func=func;
    }
    public String getEstado() 
    {
        return estado;
    }
    public void setEstado(String estado) 
    {
        this.estado=estado;
    }     
    public Calendar getData_inicio_aluguer() 
    {
        return data_inicio_aluguer;
    }
    public void setData_inicio_aluguer(Calendar data_inicio_aluguer) 
    {
        this.data_inicio_aluguer=data_inicio_aluguer;
    }
    public Calendar getData_fim_aluguer() 
    {
        return data_fim_aluguer;
    }
    public void setData_fim_aluguer(Calendar data_fim_aluguer) 
    {
        this.data_fim_aluguer=data_fim_aluguer;
    }
    public Veiculo getVeiculo() 
    {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo)
    {
        this.veiculo = veiculo;
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
        str.append("Candidatura:\n");
        str.append("\nNúmero: ").append(numero);
        str.append("\nDescrição: ").append(descricao);
        str.append("\nEstado: ").append(estado);
        str.append("\nFuncionário: ");
        str.append("\nNome: ").append(func.getNome());
        str.append("\nNIF: ").append(func.getNif());
        str.append("\nVeiculo alugado: ").append(veiculo);
        str.append("\nData de candidatura: ");
        str.append(data_candidatura.get(Calendar.DATE)).append("/");
        str.append((data_candidatura.get(Calendar.MONTH)+1)).append("/");
        str.append(data_candidatura.get(Calendar.YEAR)); 
        if(getEstado().equalsIgnoreCase("Aprovada"))
        {
            str.append("\nData de inicio do aluguer: ");
            str.append(data_inicio_aluguer.get(Calendar.DATE)).append("/");
            str.append((data_inicio_aluguer.get(Calendar.MONTH)+1)).append("/");
            str.append(data_inicio_aluguer.get(Calendar.YEAR));
            str.append("\nData de fim do aluguer: ");
            str.append(data_fim_aluguer.get(Calendar.DATE)).append("/");
            str.append((data_fim_aluguer.get(Calendar.MONTH)+1)).append("/");
            str.append(data_fim_aluguer.get(Calendar.YEAR)); 
        }
        return str.toString(); 
    }
}
