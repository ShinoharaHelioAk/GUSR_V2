package br.com.helio.enums;

public enum PerfilUsuarioEnum {
	USUARIO("usuario"),
	ADMINISTRADOR("administrador");

	private final String perfilUsuario;
	PerfilUsuarioEnum(String i) {
		perfilUsuario = i;
	}
	public String getPerfilUsuario() {
		return perfilUsuario;
	}
}
