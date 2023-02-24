package Controle;

import java.text.DecimalFormat;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import Modelo.Conta;
import Modelo.Movimentacao;
import Visualisacao.EntradaSaida;

public class Controladora {

	public void exibeMenu() {
		int opcao;
		// Solicitadas dados conta
		Conta conta = new Conta();
		String titularDaConta;
		double limiteSaldoNegativo = conta.getlimiteSaldoNegativo();
		double saldoConta = 0;
		conta.setSaldoConta(saldoConta);
		int opcaoTipoDeConta = EntradaSaida.solicitaTipoDaConta();
		do {
			titularDaConta = EntradaSaida.solicitaTitularDaConta();
			if (titularDaConta.isEmpty()) {
				EntradaSaida.geraAvisoUsuario();
			}
		} while (titularDaConta.isEmpty());

		String tipoDeConta = EntradaSaida.defineTipoDeConta(opcaoTipoDeConta);
		conta.setTitularDaConta(titularDaConta);
		conta.setTipoDeConta(tipoDeConta);

// Menu de escolha
		do {
			opcao = EntradaSaida.solicitaOpcao();
			switch (opcao) {
			// Exibe dados da conta
			case 0:
				String dadosConta = conta.geraDadosConta();
				EntradaSaida.ImprimeDadosConta(dadosConta);
				break;
			// Insere movimentação na conta
			case 1:
				// Solicita dados da movimentacao
				Movimentacao movimentacao = new Movimentacao();
				double valorDaMovimentacao = 0;
				int opcaoDeMovimentacao;
				do {
					opcaoDeMovimentacao = EntradaSaida.solicitaTipoMovimentacao();
					if (opcaoDeMovimentacao != 2) {
						valorDaMovimentacao = EntradaSaida.defineValorDeMovimentacao(opcaoDeMovimentacao);
					}
					if (saldoConta + valorDaMovimentacao < conta.getlimiteSaldoNegativo()) {
						EntradaSaida.geraAviso();
					}

				} while (saldoConta + valorDaMovimentacao < limiteSaldoNegativo);
				EntradaSaida.geraConfirmacao();
				LocalDate data = EntradaSaida.buscaData();
				if (opcaoDeMovimentacao == 1) {
					String tipoDeMovimentacao = "2.Deposito";
					saldoConta += valorDaMovimentacao;
					movimentacao.setData(data);
					movimentacao.setTipoMovimentacao(tipoDeMovimentacao);
					movimentacao.setValor(valorDaMovimentacao);
					conta.setSaldoConta(saldoConta);
					conta.contaDepositar(movimentacao);
				} else if (opcaoDeMovimentacao == 0) {
					String tipoDeMovimentacao = "1.Saque";
					saldoConta += valorDaMovimentacao;
					movimentacao.setData(data);
					movimentacao.setTipoMovimentacao(tipoDeMovimentacao);
					movimentacao.setValor(valorDaMovimentacao);
					conta.setSaldoConta(saldoConta);
					conta.contaSacar(movimentacao);
				} else {
					continue;
				}

				break;
			// Gera saldo
			case 2:
				String extrato = "";
				int tipoExtrato = EntradaSaida.solicitaTipoExtrato();
				if (tipoExtrato == 0) {
					extrato = conta.geraExtratoSaque();
				} else if (tipoExtrato == 1) {
					extrato = conta.geraExtratoDeposito();
				} else if (tipoExtrato == 2) {
					extrato = conta.geraExtratoCompleto();
				} else {
					continue;
				}

				EntradaSaida.ImprimeExtrato(extrato);
				break;

			case 3:
				String saldo = conta.geraSaldo();
				EntradaSaida.imprimeSaldo(saldo);
				break;

			}
		} while (opcao != 4);
		EntradaSaida.exibeMsgEncerraPrograma();
	}

}
