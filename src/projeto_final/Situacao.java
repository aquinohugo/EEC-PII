package projeto_final;
import java.io.Serializable;
import java.util.Calendar;

public abstract class Situacao implements Serializable
{
    protected String descricao;
    protected Calendar data_registo;
    protected Funcionario f;
    protected Veiculo v;
    
    public Situacao(String descricao,Calendar data_registo,Funcionario f,Veiculo v)
    {
        this.descricao=descricao;
        this.data_registo=data_registo;
        this.f=f;
        this.v=v;
    }
}
