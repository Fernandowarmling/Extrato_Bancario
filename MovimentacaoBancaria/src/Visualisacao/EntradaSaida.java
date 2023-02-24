package Visualisacao;

import javax.swing.JOptionPane;

import Modelo.Conta;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JComboBox;

public class EntradaSaida {
	DecimalFormat formatacaoMoeda = new DecimalFormat("R$ 0.00");

	public static int solicitaOpcao() {
		String[] opcoes = { "Exibe Dados da Conta", "Movimentar Conta", "Extrato", "Consulta Saldo",
				"Sair do programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opc��o desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O Programa sera encerrado");
	}

	public static String solicitaTitularDaConta() {
		String titular = JOptionPane.showInputDialog("Informe o nome do titular da conta");
		return titular;
	}

	public static int solicitaTipoDaConta() {
		String[] opcoes = { "1.Conta Poupan�a", "2.Conta Corrente" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a op��o desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();

	}

	public static String defineTipoDeConta(int opcaoTipoDeConta) {
		String opcaoDeConta;
		if (opcaoTipoDeConta == 0) {
			opcaoDeConta = "1.Conta Poupan�a";
		} else {
			opcaoDeConta = "2.Conta Corrente";
		}

		return opcaoDeConta;
	}

	public static int solicitaTipoMovimentacao() {
		String[] opcoes = { "1.Saque", "2.Deposito", "3.Voltar ao menu principal" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a op��o desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();

	}

	public static Double defineValorDeMovimentacao(int opcaoDeMovimentacao) {
		Double valorDaOperacao=0.00;
		String stringDaOperacao;
		do {
			stringDaOperacao=JOptionPane.showInputDialog("Qual o valor da opera��o: ");
			if(stringDaOperacao.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Sistema n�o aceita campos vazios", "Aten��o",
						JOptionPane.INFORMATION_MESSAGE);
				continue;
			}			
			valorDaOperacao = Double.parseDouble(stringDaOperacao);
			if (valorDaOperacao <= 0) {
				JOptionPane.showMessageDialog(null, "Valor informado fora dos parametos", "Aten��o",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} while (valorDaOperacao <= 0);

		if (opcaoDeMovimentacao == 0) {
			valorDaOperacao = valorDaOperacao * -1;
			return valorDaOperacao;
		} else {
			return valorDaOperacao;
		}

	}

	public static LocalDate buscaData() {
		LocalDate data = LocalDate.now();
		return data;
	}

	public static void ImprimeExtrato(String extrato) {
		JOptionPane.showMessageDialog(null, extrato, "Extrato de Movimenta��o:", JOptionPane.INFORMATION_MESSAGE);

	}

	public static int solicitaTipoExtrato() {
		String[] opcoes = { "1.Saques", "2.Depositos", "3.Completo", "4.Voltar ao menu principal" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a op��o desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static void ImprimeDadosConta(String dadosConta) {
		JOptionPane.showMessageDialog(null, dadosConta, "Dados Conta:", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void imprimeSaldo(String saldo) {
		JOptionPane.showMessageDialog(null, saldo, "Saldo:", JOptionPane.INFORMATION_MESSAGE);

	}

	public static void geraAviso() {
		JOptionPane.showMessageDialog(null, "N�o ha limite da saldo para a opera��o", "Aten��o",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public static void geraConfirmacao() {
		JOptionPane.showMessageDialog(null, "Opera��o realizada com sucesso", "Aten��o",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public static void geraAvisoUsuario() {
		JOptionPane.showMessageDialog(null, "Nome do usuario obrigatorio", "Aten��o", JOptionPane.INFORMATION_MESSAGE);
	}

}
