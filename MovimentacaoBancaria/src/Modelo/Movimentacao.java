package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Movimentacao {
	
	String tipoMovimentacao;
	double valor;
	LocalDate data;
	
	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	
	

}
