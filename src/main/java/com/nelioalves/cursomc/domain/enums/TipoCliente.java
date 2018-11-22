package com.nelioalves.cursomc.domain.enums;

import java.io.Serializable;

public enum TipoCliente implements Serializable {

	PESSOAFISICA(1, "Pessoa Física"), 
	PESSOAJURIDICA(2, "Pessoa Jurídica");

	private Integer codigo;
	private String descricao;

	private TipoCliente(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		for (TipoCliente t : values()) {
			if (t.getCodigo().intValue() == codigo.intValue()) {
				return t;
			}
		}
		throw new IllegalArgumentException("Código de TipoCliente inválido: "  + codigo);
	}

}
