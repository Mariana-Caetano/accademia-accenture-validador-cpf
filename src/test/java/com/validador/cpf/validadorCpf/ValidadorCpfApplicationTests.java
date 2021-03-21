package com.validador.cpf.validadorCpf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.validador.cpf.validadorCpf.models.Cliente;

@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setCpf("92052107061");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setCpf("92052107062");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setCpf("920.521.070-61");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setCpf("920.521.070-62");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComPontosNumeroDiferente() {
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setCpf("920.521,070-61");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspaco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setCpf("920.521.070 61");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspacoNoFinal() {
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setCpf("920521070 61");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspacoNoMeio() {
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setCpf("920.521. 070-61");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComCaracter() {
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setCpf("920521070*61");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComLetra() {
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setCpf("9205A107061");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComMaisNumeros() {
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setCpf("9205A1070613");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComNumeroLouco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Mariana");
		cliente.setCpf("69b.969.790-88");
		assertEquals(false, cliente.validarCPF());
	}

}
