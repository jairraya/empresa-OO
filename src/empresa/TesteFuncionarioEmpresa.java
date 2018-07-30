package empresa;

/**
 *
 * @author JairRaya
 */
import javax.swing.JOptionPane;

public class TesteFuncionarioEmpresa {
    
    public static FuncionarioEmp arrayfunc[] = new FuncionarioEmp[10];
    
    public static void ordenaSelectionSort(int nrofunc) {
        
        int posmenor, i, j;

        String nome, nomeposmenor;

        FuncionarioEmp funcposmenor = new FuncionarioEmp();
        FuncionarioEmp func = new FuncionarioEmp();
        FuncionarioEmp aux = new FuncionarioEmp();

        for (i = 0; i < nrofunc - 1; i++) {
            posmenor = i;
            funcposmenor = arrayfunc[i];
            nomeposmenor = funcposmenor.getNome();
            for (j = i + 1; j < nrofunc; j++) {
                func = arrayfunc[j];
                nome = func.getNome();
                
                if (nome.compareTo(nomeposmenor) <0) {
                posmenor = j;
                }
                
            }
            
            aux = arrayfunc[posmenor];
            arrayfunc[posmenor] = arrayfunc[i];
            arrayfunc[i] = aux;
        }
    }
    
    public static void main (String[] args){
        
        FuncionarioEmp func;
        int k, nrofunc;
        String s, saida;
        StringBuilder mensagem;
        
        for (;;){
            s=JOptionPane.showInputDialog("Quantos funcionários serão cadastrados (1 a "+arrayfunc.length+")? ");
            try {
                nrofunc = Integer.parseInt(s);

                if (nrofunc < 1 || nrofunc > arrayfunc.length){
                    JOptionPane.showMessageDialog(null,"Valor inválido. Digite um número entre 1 e " +
                    arrayfunc.length + ". ", "Erro",
                    JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                
            else
                break;
                
            } catch (NumberFormatException e) {
                saida = "Não é possível converter a string "+s+ " para o tipo int.\n";
                JOptionPane.showMessageDialog(null,saida,"Exceção",JOptionPane.ERROR_MESSAGE);
                continue;
            }
            
        } // for ;;
        
        for (k=0; k < nrofunc; k++){
            func = new FuncionarioEmp();
            
            //pede e lê os dados de um funcionario
            func.setMatricula(Integer.parseInt(JOptionPane.showInputDialog("Qual é a matricula do funcionário(a) "+(k+1)+"? ")));
            func.setNome(JOptionPane.showInputDialog("Qual é o nome do funcionário(a) "+(k+1)+"? "));
            
            //exemplo de solicitação de um atributo com validação persistente e bloco try catch
            for(;;){
                s= JOptionPane.showInputDialog("Qual é o tipo do cargo do funcionário(a) "+(k+1)+"? (digite 1 ou 2)");
                try {
                    int tipo = Integer.parseInt(s);
                    
                    if (tipo == 1 || tipo == 2){
                        func.setTipo(tipo);
                        func.indicarCargo (func.getTipo());
                        break;
                    }
                    
                    else { JOptionPane.showMessageDialog(null,"Tipo de cargo inválido. Digite apenas 1 ou 2", "Erro",
                                                                JOptionPane.ERROR_MESSAGE);
                        continue;
                    }
                    
                }
                
                catch (NumberFormatException erro) {
                    saida = "Não é possível converter a string " + s + " à variável int tipo\n";
                    JOptionPane.showMessageDialog(null, saida, "Exceção", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                
            } //for ;;
            
        func.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Qual é o salário do funcionário(a) " + (k+1) + "? ")));
        
        //armazena os dados lidos no vetor de objetos arrayfunc
        arrayfunc[k]=func;
        
        }
        
        mensagem = new StringBuilder();
        
        for (k=0; k < nrofunc; k++){
            func=arrayfunc[k];
            
            // mostra os dados usando uma mensagem da classe StringBuilder
            mensagem.append ("Nome do(a) Funcionário(a): " +func.getNome()+"\n");
            mensagem.append ("Matricula: " +func.getMatricula()+"\n");
            mensagem.append ("Tipo Cargo: " +func.getTipo()+"\n");
            mensagem.append ("Cargo: " +func.getCargo()+"\n");
            mensagem.append ("Salário: R$" +func.getSalario()+"\n");
        }
        
        JOptionPane.showMessageDialog(null,mensagem, "Funcionários sem ordenação", JOptionPane.INFORMATION_MESSAGE);
        
        ordenaSelectionSort(nrofunc);

        mensagem = new StringBuilder();
        
        for (k=0; k < nrofunc; k++){
            func=arrayfunc[k];
            
            // mostra os dados usando uma mensagem da classe StringBuilder
            mensagem.append ("Nome do(a) Funcionário(a): " +func.getNome()+"\n");
            mensagem.append ("Matricula: " +func.getMatricula()+"\n");
            mensagem.append ("Tipo Cargo: " +func.getTipo()+"\n");
            mensagem.append ("Cargo: " +func.getCargo()+"\n");
            mensagem.append ("Salário: R$" +func.getSalario()+"\n");
        }
        
    JOptionPane.showMessageDialog(null,mensagem, "Funcionários ORDENADOS por nome",
    JOptionPane.INFORMATION_MESSAGE);
        
    }//main
    
} //classe