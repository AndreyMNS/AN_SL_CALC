
package cliente;

import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

public class IniciarCliente {
    public static void main(String[] args) {
        try{
            InterfaceOperacoes c = (InterfaceOperacoes) Naming.lookup( "rmi://127.0.0.1:1099/CalculadoraRMI");
            String numero1 = JOptionPane.showInputDialog(null, "Entre com o primeiro nÃºmero", "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);   
            String numero2 = JOptionPane.showInputDialog(null, "Entre com o segundo nÃºmero", "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);   

            double n1 = Double.parseDouble(numero1);
            double n2 = Double.parseDouble(numero2);

            Object[] operacoes = {"somar", "subtrair", "multiplicar", "dividir"};
            Object selecionado = JOptionPane.showInputDialog(null, "Escolha a operaÃ§Ã£o", "OperaÃ§Ã£o", JOptionPane.INFORMATION_MESSAGE, null, operacoes, operacoes[0]);

            if(selecionado == "somar"){

                JOptionPane.showMessageDialog(null, "O resultado Ã© " + c.somar(n1, n2), "Resultado", JOptionPane.INFORMATION_MESSAGE);

            }
            if(selecionado == "subtrair"){

                JOptionPane.showMessageDialog(null, "O resultado Ã© " + c.subtrair(n1, n2), "Resultado", JOptionPane.INFORMATION_MESSAGE);

            }
            if(selecionado == "multiplicar"){

                JOptionPane.showMessageDialog(null, "O resultado Ã© " + c.multiplicar(n1, n2), "Resultado", JOptionPane.INFORMATION_MESSAGE);

            }
            if(selecionado == "dividir"){

                JOptionPane.showMessageDialog(null, "O resultado Ã© " + c.dividir(n1, n2), "Resultado", JOptionPane.INFORMATION_MESSAGE);

            }

        }
        catch(RemoteException re){
            JOptionPane.showMessageDialog(null, "Erro remoto: " + re.toString(), "Erro remoto", JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro local: " + e.toString(), "Erro local", JOptionPane.WARNING_MESSAGE);
        }
    }
}
