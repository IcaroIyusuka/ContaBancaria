package Test;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;

public class ContaBancariaSteps {
    private ContaBancaria conta;
    private boolean saqueEfetuado;
    private String mensagemErro;

    @Given("um cliente especial com saldo atual de {int} reais")
    public void um_cliente_especial_com_saldo_atual_de_reais(Integer saldo) {
        conta = new ContaBancaria("Cliente Especial", true);
        conta.setSaldo(saldo.doubleValue());
        System.out.println("Saldo cliente especial " + saldo );
    }

    @When("for solicitado um saque no valor de {int} reais")
    public void for_solicitado_um_saque_no_valor_de_reais(Integer valor) {
        saqueEfetuado = conta.sacar(valor.doubleValue());
        System.out.println("Valor a se sacar " + valor);
    }

    @Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer novoSaldo) {
        assertTrue(saqueEfetuado);
        assertEquals(novoSaldo.doubleValue(), conta.consultarSaldo(), 0.001);
        System.out.println("Atualização da conta " + novoSaldo);
    }

    @Given("um cliente comum com saldo atual de {int} reais")
    public void um_cliente_comum_com_saldo_atual_de_reais(Integer saldo) {
        conta = new ContaBancaria("Cliente Comum", false);
        conta.setSaldo(saldo.doubleValue());
        System.out.println("Saldo cliente comum " + saldo);
    }

    @When("solicitar um saque de {int} reais")
    public void solicitar_um_saque_de_reais(Integer valor) {
        saqueEfetuado = conta.sacar(valor.doubleValue());
        if (!saqueEfetuado) {
            mensagemErro = "Saldo Insuficiente";
            System.out.println("Saldo insulficiente " + valor);
        }
        System.out.println("Saque efetuado com sucesso");
    }

    @Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
    public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
        assertFalse(saqueEfetuado);
        assertEquals("Saldo Insuficiente", mensagemErro);
        System.out.println("Saldo insulficiente para essa operação ");
    }
}
