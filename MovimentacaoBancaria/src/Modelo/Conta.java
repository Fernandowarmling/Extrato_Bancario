package Modelo;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Conta {

	private double limiteSaldoNegativo = -1000;

	private String titularDaConta;
	private String tipoDeConta;
	private Double saldoConta;
	private DecimalFormat formatacaoMoeda = new DecimalFormat("R$ 0.00");
	private ArrayList<Movimentacao> listaMovimentacao = new ArrayList<Movimentacao>();

	public Double getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(Double saldoConta) {
		this.saldoConta = saldoConta;
	}

	public String getTitularDaConta() {
		return titularDaConta;
	}

	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}

	public String getTipoDeConta() {
		return tipoDeConta;
	}

	public ArrayList<Movimentacao> getListaMovimentacao() {
		return listaMovimentacao;
	}

	public void setListaMovimentacao(ArrayList<Movimentacao> listaMovimentacao) {
		this.listaMovimentacao = listaMovimentacao;
	}

	public void setTipoDeConta(String tipoDeConta) {
		this.tipoDeConta = tipoDeConta;
	}

	public Conta() {
		setTipoDeConta(tipoDeConta);
		setTitularDaConta(titularDaConta);
	}

	public void contaDepositar(Movimentacao movimentacao) {
		listaMovimentacao.add(movimentacao);
	}

	public void contaSacar(Movimentacao movimentacao) {
		listaMovimentacao.add(movimentacao);
	}

	public String geraExtratoCompleto() {
		String extratoCompleto;
		extratoCompleto = "Conta: " + (getTitularDaConta()) + "\n" + "Tipo Conta: " + (getTipoDeConta()) + "\n"
				+ "Saldo : " + formatacaoMoeda.format(getSaldoConta()) + "\n";
		for (Movimentacao movimentacao : listaMovimentacao) {
			extratoCompleto += movimentacao.getData() + " " + movimentacao.getTipoMovimentacao() + " "
					+ formatacaoMoeda.format(movimentacao.getValor()) + "\n";
		}

		return extratoCompleto;
	}

	public String geraExtratoSaque() {
		String extratoSaque;
		extratoSaque = "Conta: " + (getTitularDaConta()) + "\n" + "Tipo Conta: " + (getTipoDeConta()) + "\n"
				+ "Saldo : " + formatacaoMoeda.format(getSaldoConta()) + "\n";
		for (Movimentacao movimentacao : listaMovimentacao) {
			if (movimentacao.getTipoMovimentacao().equals("1.Saque")) {
				extratoSaque += movimentacao.getData() + " " + movimentacao.getTipoMovimentacao() + " "
						+ formatacaoMoeda.format(movimentacao.getValor()) + "\n";
			}

		}
		return extratoSaque;
	}

	public String geraExtratoDeposito() {
		String extratoDeposito;
		extratoDeposito = "Conta: " + (getTitularDaConta()) + "\n" + "Tipo Conta: " + (getTipoDeConta()) + "\n"
				+ "Saldo : " + formatacaoMoeda.format(getSaldoConta()) + "\n";
		for (Movimentacao movimentacao : listaMovimentacao) {
			if (movimentacao.getTipoMovimentacao().equals("2.Deposito")) {
				extratoDeposito += movimentacao.getData() + " " + movimentacao.getTipoMovimentacao() + " "
						+ formatacaoMoeda.format(movimentacao.getValor()) + "\n";
			}

		}
		return extratoDeposito;
	}

	public String geraDadosConta() {
		String dadosConta;
		dadosConta = "Conta: " + (getTitularDaConta()) + "\n" + "Tipo Conta: " + (getTipoDeConta()) + "\n" + "Saldo : "
				+ formatacaoMoeda.format(getSaldoConta()) + "\n";
		return dadosConta;
	}

	public String geraSaldo() {
		String saldo;
		saldo = formatacaoMoeda.format(getSaldoConta());
		return saldo;
	}

	public double getlimiteSaldoNegativo() {
		return limiteSaldoNegativo;
	}

	public void setlimiteSaldoNegativo(double limiteDeSaldoNegativo) {
		limiteSaldoNegativo = limiteDeSaldoNegativo;
	}

}
