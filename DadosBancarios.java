package br.com.programaDadosBancarios;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class DadosBancarios {
    public static void main(String[] args) {

        try {
            String name = JOptionPane.showInputDialog(null, "Digite seu nome:");
            String tipoDeConta = JOptionPane.showInputDialog(null, "Digite seu tipo de conta bancária", "Corrente");
            double saldoInicial = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o seu saldo em conta"));
            JOptionPane.showMessageDialog(null, """
                    ******************************
                    Nome: %s
                    Tipo de conta: %s
                    Saldo inicial: R$%.2f
                    ******************************
                    """.formatted(name, tipoDeConta, saldoInicial), "Dados iniciais do cliente:", JOptionPane.QUESTION_MESSAGE, null);

            boolean executando = true;
            // Variavel de acumular total
            double total = saldoInicial;

            while (executando) {
                int menu = Integer.parseInt(JOptionPane.showInputDialog("""
                    Escolha qual operação gostaria de realizar:
                    [ 1, 2, 3, 4]
                    1 - Consultar saldos
                    2 - Receber valor
                    3 - Transferir valor
                    4 - Sair
                    """));

                switch (menu) {

                    // Mostrar o saldo inicial
                    case 1:
                        JOptionPane.showMessageDialog(null, "Seu saldo inicial R$" + saldoInicial);
                    break;

                    // Mostrar o saldo com um valor recebido
                    case 2:
                        double receberValor = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor que quer receber"));
                    try {
                        if (receberValor <= 0) {
                            JOptionPane.showMessageDialog(null, "Opção Inválida! Digite um número maior que 0.");
                        }else {
                            total += receberValor;
                            JOptionPane.showMessageDialog(null, "Valor recebido com sucesso! \nSeu saldo agora é R$%.2f".formatted(total) );
                        }
                    } catch (HeadlessException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número.");
                    }
                    break;

                    // Mostrar um saldo com um valor transferido
                    case 3:
                        double tranferirValor = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor que quer transferir"));
                    try {
                        if (tranferirValor > total) {
                            JOptionPane.showMessageDialog(null, "Opção Inválida! Digite um valor disponivel em saldo.");
                        }else {
                            total -= tranferirValor;
                            JOptionPane.showMessageDialog(null, "Valor transferido com sucesso! \nSeu saldo agora é R$%.2f".formatted(total));
                        }
                    } catch (HeadlessException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número.");
                    }
                    break;

                    // Sair
                    case 4:
                        executando = false;
                        JOptionPane.showMessageDialog(null, "Programada encerrado!");
                    break;

                    // Se não digitar nenhuma das 4 opções ele cai aqui
                    default: JOptionPane.showMessageDialog(null, "Opção Inválida! \nDigite um número de 1 a 4.");
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERRO");
        }

    }
}
