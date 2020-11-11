package projeto_final;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author Artifex
 */
public class Veiculo implements Serializable
{
    private int numero_chassis,numero_candidaturas;
    private String designacao;
    private Tipo_veiculo tipo;
    private Calendar data_ultima_manutencao=new GregorianCalendar();
    private String estado;
    private ArrayList<Ocorrencia>ocorrencias=new ArrayList<>();
    private ArrayList<Manutencao>manutencoes=new ArrayList<>();
    
    public Veiculo(int numero_chassis,String designacao,Tipo_veiculo tipo,Calendar data_ultima_manutencao,String estado)
    {
        this.numero_chassis=numero_chassis;
        this.designacao=designacao;
        this.tipo=tipo;
        this.data_ultima_manutencao=data_ultima_manutencao;
        this.estado=estado;
    }
    
    public void adicionar_ocorrencia(Ocorrencia oc)
    {
        getOcorrencias().add(oc);
    }  
    public void adicionar_manutencao(Manutencao m)
    {
        getManutencoes().add(m);
    }
    public Calendar getData_ultima_manutencao() 
    {
        return data_ultima_manutencao;
    }
    public int getNumero_chassis() 
    {
        return numero_chassis;
    }
    public void setNumero_chassis(int numero_chassis) 
    {
        this.numero_chassis=numero_chassis;
    }
    public int getNumero_candidaturas() 
    {
        return numero_candidaturas;
    }
    public void setNumero_candidaturas(int numero_candidaturas) 
    {
        this.numero_candidaturas=numero_candidaturas;
    }
    public String getDesignacao() 
    {
        return designacao;
    }
    public void setDesignacao(String designacao) 
    {
        this.designacao=designacao;
    }
    public Tipo_veiculo getTipo() 
    {
        return tipo;
    }
    public void setTipo(Tipo_veiculo tipo) 
    {
        this.tipo=tipo;
    }
    public void setData_ultima_manutencao(Calendar data_ultima_manutencao) 
    {
        this.data_ultima_manutencao=data_ultima_manutencao;
    }
    
    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }
    public ArrayList<Ocorrencia> getOcorrencias() 
    {
        return ocorrencias;
    }
    public void setOcorrencias(ArrayList<Ocorrencia> ocorrencias) 
    {
        this.ocorrencias=ocorrencias;
    }
    public ArrayList<Manutencao> getManutencoes() 
    {
        return manutencoes;
    }
    public void setManutencoes(ArrayList<Manutencao> manutencoes) 
    {
        this.manutencoes=manutencoes;
    }     
    @Override
    public String toString() 
    {
        StringBuilder str=new StringBuilder();     
        str.append("\nNúmero Chassis: ").append(numero_chassis);
        str.append("\nDesignação: ").append(designacao);
        str.append("\nTipo de Veiculo: ").append(tipo.getDesignacao());
        str.append("\nEstado do Veiculo: ").append(estado);
        str.append("\nData da ultima manutenção: ");
        str.append(data_ultima_manutencao.get(Calendar.DATE)).append("/");
        str.append((data_ultima_manutencao.get(Calendar.MONTH) + 1)).append("/");
        str.append(data_ultima_manutencao.get(Calendar.YEAR)); 
        return str.toString();
    }
    public String mostrar_ocorrencias()
    {
        StringBuilder str=new StringBuilder();
        if(getOcorrencias().isEmpty())
            str.append("\nNão há ocorrências inseridas!");
        else
            for(int i=0;i<getOcorrencias().size();i++) 
            {
                str.append(getOcorrencias().get(i)).append("\n\n");
            }
        return str.toString();
    } 
    public String mostrar_manutencoes()
    {
        StringBuilder str=new StringBuilder();
        if(getManutencoes().isEmpty())
            str.append("\nNão há manutenções inseridas!");
        else
            for(int i=0;i<getManutencoes().size();i++) 
            {
                str.append(getManutencoes().get(i)).append("\n\n");
            }
        return str.toString();            
    }
}       
      


