package com.nelioalves.cursomc.domain.enums;

import java.io.Serializable;

public enum EstadoPagamento implements Serializable {

	PENDENTE(1, "Pendente"), 
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");

	private Integer codigo;
	private String descricao;

	private EstadoPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EstadoPagamento toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		for (EstadoPagamento t : values()) {
			if (t.getCodigo().intValue() == codigo.intValue()) {
				return t;
			}
		}
		throw new IllegalArgumentException("Código de EstadoPagamento inválido: "  + codigo);
	}

}
