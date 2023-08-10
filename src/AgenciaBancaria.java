import java.util.ArrayList;
import java.util.List;

class AgenciaBancaria {
    private int numeroAgencia;
    private List<ContaBancaria> contas;

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public AgenciaBancaria(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
        this.contas = new ArrayList<>();
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public void listarContas() {
        System.out.println("Contas da Agência " + numeroAgencia + ":");
        for (ContaBancaria conta : contas) {
            System.out.println(conta);
        }
    }
}