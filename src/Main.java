import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<AgenciaBancaria> agencias = new ArrayList<>();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Criar Agência");
            System.out.println("2 - Criar Conta Bancária");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Listar Contas de Agência");
            System.out.println("0 - Sair");
            int escolha = scanner.nextInt();

            if (escolha == 0) {
                System.out.println("Saindo...");
                break;
            }

            switch (escolha) {
                case 1:
                    System.out.print("Digite o número da nova agência: ");
                    int numeroAgencia = scanner.nextInt();
                    AgenciaBancaria novaAgencia = new AgenciaBancaria(numeroAgencia);
                    agencias.add(novaAgencia);
                    System.out.println("Agência criada com sucesso.");
                    break;

                case 2:
                    System.out.print("Digite o número da agência onde deseja criar a conta: ");
                    int numeroAgenciaConta = scanner.nextInt();
                    AgenciaBancaria agenciaAlvo = null;
                    for (AgenciaBancaria agencia : agencias) {
                        if (agencia.getNumeroAgencia() == numeroAgenciaConta) {
                            agenciaAlvo = agencia;
                            break;
                        }
                    }
                    if (agenciaAlvo != null) {
                        System.out.print("Digite o número da nova conta: ");
                        int numeroConta = scanner.nextInt();
                        System.out.print("Digite o nome do titular: ");
                        scanner.nextLine(); // Consumir a quebra de linha
                        String nomeTitular = scanner.nextLine();
                        System.out.print("Digite o saldo inicial: ");
                        double saldoInicial = scanner.nextDouble();
                        ContaBancaria novaConta = new ContaBancaria(numeroConta, nomeTitular, saldoInicial);
                        agenciaAlvo.adicionarConta(novaConta);
                        System.out.println("Conta criada com sucesso na agência " + numeroAgenciaConta + ".");
                    } else {
                        System.out.println("Agência não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o número da agência: ");
                    int numeroAgenciaDeposito = scanner.nextInt();
                    AgenciaBancaria agenciaDeposito = null;
                    for (AgenciaBancaria agencia : agencias) {
                        if (agencia.getNumeroAgencia() == numeroAgenciaDeposito) {
                            agenciaDeposito = agencia;
                            break;
                        }
                    }
                    if (agenciaDeposito != null) {
                        System.out.print("Digite o número da conta: ");
                        int numeroContaDeposito = scanner.nextInt();
                        ContaBancaria contaDeposito = null;
                        for (ContaBancaria conta : agenciaDeposito.getContas()) {
                            if (conta.getNumeroConta() == numeroContaDeposito) {
                                contaDeposito = conta;
                                break;
                            }
                        }
                        if (contaDeposito != null) {
                            System.out.print("Digite o valor a depositar: ");
                            double valorDeposito = scanner.nextDouble();
                            contaDeposito.depositar(valorDeposito);
                            System.out.println("Depósito realizado com sucesso.");
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                    } else {
                        System.out.println("Agência não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o número da agência: ");
                    int numeroAgenciaSaque = scanner.nextInt();
                    AgenciaBancaria agenciaSaque = null;
                    for (AgenciaBancaria agencia : agencias) {
                        if (agencia.getNumeroAgencia() == numeroAgenciaSaque) {
                            agenciaSaque = agencia;
                            break;
                        }
                    }
                    if (agenciaSaque != null) {
                        System.out.print("Digite o número da conta: ");
                        int numeroContaSaque = scanner.nextInt();
                        ContaBancaria contaSaque = null;
                        for (ContaBancaria conta : agenciaSaque.getContas()) {
                            if (conta.getNumeroConta() == numeroContaSaque) {
                                contaSaque = conta;
                                break;
                            }
                        }
                        if (contaSaque != null) {
                            System.out.print("Digite o valor a sacar: ");
                            double valorSaque = scanner.nextDouble();
                            if (contaSaque.sacar(valorSaque)) {
                                System.out.println("Saque realizado com sucesso.");
                            } else {
                                System.out.println("Saldo insuficiente para o saque.");
                            }
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                    } else {
                        System.out.println("Agência não encontrada.");
                    }
                    break;


                case 5:
                    System.out.print("Digite o número da agência para listar as contas: ");
                    int numeroAgenciaListar = scanner.nextInt();
                    AgenciaBancaria agenciaListar = null;
                    for (AgenciaBancaria agencia : agencias) {
                        if (agencia.getNumeroAgencia() == numeroAgenciaListar) {
                            agenciaListar = agencia;
                            break;
                        }
                    }
                    if (agenciaListar != null) {
                        agenciaListar.listarContas();
                    } else {
                        System.out.println("Agência não encontrada.");
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
