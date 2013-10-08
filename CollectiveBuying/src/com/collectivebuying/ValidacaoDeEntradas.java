package com.collectivebuying;

public class ValidacaoDeEntradas {

	public boolean validaDataNascimento(String dataNascimento) {

		if ((dataNascimento.length() != 10)) {
			return false;
		} else if ((dataNascimento.charAt(2) != '/')
				|| (dataNascimento.charAt(5)) != '/') {
			return false;
		}

		if (Character.isDigit(dataNascimento.charAt(0)) != true
				|| Character.isDigit(dataNascimento.charAt(0)) != true) {
			return false;
		} else if (Character.isDigit(dataNascimento.charAt(3)) != true
				|| Character.isDigit(dataNascimento.charAt(4)) != true) {
			return false;
		} else if (Character.isDigit(dataNascimento.charAt(6)) != true
				|| Character.isDigit(dataNascimento.charAt(7)) != true) {
			return false;
		} else if (Character.isDigit(dataNascimento.charAt(8)) != true
				|| Character.isDigit(dataNascimento.charAt(9)) != true) {
			return false;
		}

		return true;
	}
	public boolean validaCPF(String cpf) {

		boolean temp = true;
		if (cpf.length() != 11) {
			temp = false;
		} else {
			for (int i = 0; i < cpf.length(); i++) {
				if (Character.isLetter(cpf.charAt(i)) == true) {
					temp = false;
				}
			}
		}

		if (validarNumeracaoCPF(cpf))
			temp = false;
		return temp;
	}

	private boolean validarNumeracaoCPF(String cpf) {
		return cpf.equals("00000000000") || cpf.equals("11111111111")
				|| cpf.equals("22222222222") || cpf.equals("33333333333")
				|| cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777")
				|| cpf.equals("88888888888") || cpf.equals("99999999999")
				|| (cpf.length() != 11);
	}
	public boolean validaCNPJ(String cnpj) {

		return cnpj.equals("00000000000000") || cnpj.equals("11111111111111")
				|| cnpj.equals("22222222222222")
				|| cnpj.equals("33333333333333")
				|| cnpj.equals("44444444444444")
				|| cnpj.equals("55555555555555")
				|| cnpj.equals("66666666666666")
				|| cnpj.equals("77777777777777")
				|| cnpj.equals("88888888888888")
				|| cnpj.equals("99999999999999") || (cnpj.length() != 14)
				|| isLetras(cnpj);

	}
	private boolean isLetras(String string) {
		boolean temp = false;
		for (int i = 0; i < string.length(); i++) {
			if (Character.isLetter(string.charAt(i)) == true) {
				temp = true;
			}
		}
		return temp;
	}
	public boolean validaEmail(String email) {

		if (email.contains("@") && email.contains(".")) {
			return true;
		}
		return false;

	}
	public boolean validaCEP(String string) {

		return string.equals("00000000") || string.equals("11111111")
				|| string.equals("22222222") || string.equals("33333333")
				|| string.equals("44444444") || string.equals("55555555")
				|| string.equals("66666666") || string.equals("77777777")
				|| string.equals("88888888") || string.equals("99999999")
				|| (string.length() != 8) || isLetras(string);
	}
	public boolean validaNome(String string) {

		boolean temp = true;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != ' '
					&& Character.isLetter(string.charAt(i)) != true) {
				temp = false;
			}
		}
		return temp;
	}

	public boolean validaSobreNome(String string) {
		boolean temp = true;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != ' '
					&& Character.isLetter(string.charAt(i)) != true) {
				temp = false;
			}
		}
		return temp;
	}

	public boolean validaCidade(String string) {
		boolean temp = true;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != ' '
					&& Character.isLetter(string.charAt(i)) != true) {
				temp = false;
			}
		}
		return temp;
	}

	public boolean validaEstado(String string) {
		boolean temp = true;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != ' '
					&& Character.isLetter(string.charAt(i)) != true) {
				temp = false;
			}
		}
		return temp;
	}

}