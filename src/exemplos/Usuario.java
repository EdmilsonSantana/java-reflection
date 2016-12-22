
package exemplos;

public class Usuario {

	private String login;

	private String senha;

	private String email;

	private String papel;

	private Boolean ativo;

	public Boolean getAtivo() {

		return ativo;
	}

	public void setAtivo(Boolean ativo) {

		this.ativo = ativo;
	}

	public String getPapel() {

		return papel;
	}

	public void setPapel(String papel) {

		this.papel = papel;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getSenha() {

		return senha;
	}

	public void setSenha(String senha) {

		this.senha = senha;
	}

	public String getLogin() {

		return login;
	}

	public void setLogin(String login) {

		this.login = login;
	}
	
	public void test() {
		throw new RuntimeException("Exceção");
	}

	public boolean validarEmail() {

		return email.contains("@");
	}

	public boolean validarSenha() {

		return senha.length() > 8;
	}

	public boolean validarLogin() {

		return login.length() > 5 && login.length() < 10;
	}
	
	private void metodo(String s) {
		
	}

}
