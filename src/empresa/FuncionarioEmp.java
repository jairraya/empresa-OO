package empresa;

/**
 *
 * @author JairRaya
 */
public class FuncionarioEmp {
    
    // atributos ou variáveis privadas da classe. Somente podem ser usadas na classe.
    private int matricula;
    private String nome;
    private int tipo;
    private String cargo;
    private double salario;
    
    //construtor com parâmetros
    public FuncionarioEmp (int matricula, String nome, int tipo, String cargo, double salario){
        
        this.matricula = matricula;
        this.nome = nome;
        this.tipo = tipo;
        this.cargo = cargo;
        this.salario = salario;
    }
    
    //construtor sem parâmetros
    public FuncionarioEmp (){
    }
    
    //métodos set inserem valores nos atributos (ou variáveis)
    //métodos get obtêm valores inseridos nos atributos (variáveis)
    public int getMatricula(){
        return matricula;
    }   
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getTipo(){
    return tipo;
    }
    public void setTipo(int tipo){
    this.tipo = tipo;
    }
    
    public String getCargo(){
    return cargo;
    }
    public void setCargo(String cargo){
    this.cargo = cargo;
    }
    
    public double getSalario(){
    return salario;
    }
    public void setSalario(double salario){
    this.salario=salario;
    }
    
    public void indicarCargo(int tipo){
        
        String cargofunc="";
        
        switch(tipo){
            
            case 1: cargofunc = "Programador 1";
            break;
            case 2: cargofunc = "Programador 2";
            break;
        }
        
        this.cargo=cargofunc;
    }
    
    //este método calcula um reajuste salarial
    public void ajustarSalario(double percentual){
        
        //this.salario= this.salario + this.salario * percentual/100;
        double reajuste = this.salario * (double) percentual/100;
        this.salario += reajuste;
        
    }
    
}