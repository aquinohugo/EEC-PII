package projeto_final;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Artifex
 */
public class Tipo_veiculo implements Serializable
{

    private int numero;
    private String designacao;
    private int num_veiculos;
    private double custo;
    private ArrayList<Veiculo>veiculos=new ArrayList<>();

    public Tipo_veiculo(String designacao) 
    {
        this.designacao=designacao;
    }
    public void adicionar_veiculo(Veiculo v)
    {
        getVeiculos().add(v);
    }   
    public int getNumero() 
    {
        return numero;
    }
    public void setNumero(int numero) 
    {
        this.numero=numero;
    }
    public String getDesignacao() 
    {
        return designacao;
    }
    public void setDesignacao(String designacao) 
    {
        this.designacao=designacao;
    }
    public int getNum_veiculos() 
    {
        return num_veiculos;
    }
    public void setNum_veiculos(int num_veiculos) 
    {
        this.num_veiculos=num_veiculos;
    }    
    public ArrayList<Veiculo> getVeiculos() 
    {
        return veiculos;
    }
    public void setVeiculos(ArrayList<Veiculo> veiculos) 
    {
        this.veiculos=veiculos;
    }
    public double getCusto() 
    {
        return custo;
    }
    public void setCusto(double custo) 
    {
        this.custo=custo;
    }     
    @Override
    public String toString() 
    {
        StringBuilder str=new StringBuilder();     
        str.append("\nNúmero: ").append(numero);
        str.append("\nDesignação: ").append(designacao);
        str.append("\nNúmero de Veículos: ").append(num_veiculos);
        return str.toString();
    }    
    public String mostrar_veiculos()
    {
        StringBuilder str=new StringBuilder();
        if(getVeiculos().isEmpty())
            str.append("Não há veiculos inseridos!");
        else
            for(int i=0;i<getVeiculos().size();i++) 
            {
                str.append("Veículo: ").append(getVeiculos().get(i)).append("\n\n");
            }
        return str.toString();
    }   
}
