import javax.sound.midi.Soundbank;
import java.net.SocketOption;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Fornecedor> fornecedores = new ArrayList<>();
    private static ArrayList<ContaReceber> contasReceber = new ArrayList<>();
    private static ArrayList<ContaPagar> contasPagar = new ArrayList<>();
    private static ArrayList<FluxoCaixa> fluxoCaixa = new ArrayList<>();

    public static void main(String[] args) {
        criarObjetos();
        realizarOperacoes();
        exibirMenuPrincipal();
        System.out.println("Programa encerrado.");
        scanner.close();
    }

    public static void criarObjetos() {
        Funcionario funcionario = new Funcionario("João", "rua aipim", "40028922", "jp@mail.com",0);
        Cliente cliente = new Cliente("Maria", 500, "rua jabuticaba", "2011402","mari@gmail.com",0);
        Fornecedor fornecedor = new Fornecedor("Fornecedor A", 2000, "pope.com", 0);
        ContaReceber contaReceber = new ContaReceber("Recebimento 1", 0, 50, 1500,0,0,0,"11022024");
        ContaPagar contaPagar = new ContaPagar("Pagamento 1", 20, 0, 800,0,"03032024");

        funcionarios.add(funcionario);
        clientes.add(cliente);
        fornecedores.add(fornecedor);
        contasReceber.add(contaReceber);
        contasPagar.add(contaPagar);
    }
    public static void exibirFluxoCaixa() {
        System.out.println("Vencimento\tCrédito\tDébito");
    }
    public static void realizarOperacoes() {
        for (Funcionario funcionario : funcionarios) {
            funcionario.entrar();
            funcionario.imprimir();
            System.out.println("Valor Total: " + funcionario.calcularTotal());
        }

        for (Cliente cliente : clientes) {
            cliente.entrar();
            cliente.imprimir();
            System.out.println("Valor Total: " + cliente.calcularTotal());
        }

        for (Fornecedor fornecedor : fornecedores) {
            fornecedor.entrar();
            fornecedor.imprimir();
            System.out.println("Valor Total: " + fornecedor.calcularTotal());
        }

        for (ContaReceber conta : contasReceber) {
            conta.entrar();
            conta.imprimir();
            System.out.println("Valor Total: " + conta.calcularTotal());
        }

        for (ContaPagar conta : contasPagar) {
            conta.entrar();
            conta.imprimir();
            System.out.println("Valor Total: " + conta.calcularTotal());
        }
    }

    public static void exibirMenuConsulta() {
        int opcao;
        do {
            System.out.println("\n\n");
            System.out.println("\n--- MENU DE CONSULTA ---");
            System.out.println("1. Consultar funcionario");
            System.out.println("2. Consultar clientes");
            System.out.println("3. Consultar Fornecedores");
            System.out.println("4. Consultar Contas a Receber :");
            System.out.println("5. Consultar Contas a Pagar : ");
            System.out.println("6. Voltar ao Menu Principal : ");

            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1: // Consultar funcionario
                    exibirFuncionarios();
                    break;
                case 2: // Consultar clientes
                    exibirClientes();
                    break;
                case 3: // Consultar Fornecedores
                    exibirFornecedores();
                    break;
                case 4: // Exibir Contas a Receber
                    exibirContasReceber();
                    break;
                case 5: // Exibir Contas a Pagar
                    exibirContasPagar();
                    break;
                case 6: // Voltar para menu
                    System.out.println("\nVoltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

    public static void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n");
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Incluir");
            System.out.println("2. Alterar");
            System.out.println("3. Consultar");
            System.out.println("4. Excluir");
            System.out.println("5. Exebir Fluxo Caixa");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1: // Incluir
                    exibirMenuCadastro();
                    break;
                case 2: // Alterar
                    exibirMenuAlterar();
                    break;
                case 3: // Consultar
                    exibirMenuConsulta();
                    break;
                case 4: // Excluir
                    exibirMenuExclusao();
                    break;
                case 5: // fluxo
                    exibirFluxoCaixa();
                    break;
                case 6: //sair
                    System.out.println("Sair Da Aplicação");
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }
    public static void exibirMenuAlterar() {
        int opcao;
        do {
            System.out.println("\n--- MENU DE ALTERAÇÃO ---");
            System.out.println("1. Alterar Funcionários");
            System.out.println("2. Alterar Clientes");
            System.out.println("3. Alterar Fornecedores");
            System.out.println("4. Alterar Contas a Receber");
            System.out.println("5. Alterar Contas a Pagar");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            switch (opcao) {
                case 1:
                    menuAlterarFuncionarios();
                    break;
                case 2:
                    menuAlterarClientes();
                    break;
                case 3:
                    menuAlterarFornecedores();
                    break;
                case 4:
                    menuAlterarContasReceber();
                    break;
                case 5:
                    menuAlterarContasPagar();
                    break;
                case 6:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

    public static void menuAlterarFuncionarios() {
        exibirFuncionarios();
        System.out.println("Digite o ID do funcionário que deseja alterar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (id >= 0 && id < funcionarios.size()) {
            Funcionario funcionario = funcionarios.get(id);
            System.out.println("Digite o novo nome do funcionário:");
            String nome = scanner.nextLine();
            System.out.println("Digite o novo Endereço:");
            String endereco = scanner.nextLine();
            System.out.println("Digite o novo Telefone:");
            String telefone = scanner.nextLine();
            System.out.println("Digite o novo Email:");
            String email = scanner.nextLine();
            System.out.println("Digite o novo ID:");


            funcionario.nome = nome;
            funcionario.endereco = endereco;
            funcionario.telefone = telefone;
            funcionario.email = email;


            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public static void menuAlterarClientes() {
        exibirClientes();
        System.out.println("Digite o ID do cliente que deseja alterar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        if (id >= 0 && id < clientes.size()) {
            Cliente cliente = clientes.get(id);
            System.out.println("Digite o novo nome do cliente:");
            String nome = scanner.nextLine();
            System.out.println("Digite o novo valor de credito:");
            double limcred = scanner.nextDouble();
            System.out.println("Digite o novo endereço:");
            String endereco = scanner.nextLine();
            System.out.println("Digite o novo telefone:");
            String telefone = scanner.nextLine();
            cliente.nome = nome;
            cliente.limcred = limcred;
            cliente.endereco = endereco;
            cliente.telefone = telefone;
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public static void menuAlterarFornecedores() {
        exibirFornecedores();
        System.out.println("Digite o ID do fornecedor que deseja alterar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        if (id >= 0 && id < fornecedores.size()) {
            Fornecedor fornecedor = fornecedores.get(id);
            System.out.println("Digite o novo nome do fornecedor:");
            String nome = scanner.nextLine();
            System.out.println("Digite o novo valor de limite de compras:");
            double limcred = scanner.nextDouble();
            System.out.println("Digite o novo site:");
            String endereco = scanner.nextLine();
            fornecedor.nome = nome;
            fornecedor.limcred = limcred;
            fornecedor.endereco = endereco;

            System.out.println("Fornecedor atualizado com sucesso!");
        } else {
            System.out.println("Fornecedor não encontrado.");
        }
    }

    public static void menuAlterarContasReceber() {
        exibirContasReceber();
        System.out.println("Digite o ID da conta a receber que deseja alterar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        if (id >= 0 && id < contasReceber.size()) {
            ContaReceber contaReceber = contasReceber.get(id);
            System.out.println("Digite o novo nome da conta a receber:");
            String nome = scanner.nextLine();
            System.out.println("Digite a nova data de vencimento:");
            String vencimento = scanner.nextLine();
            System.out.println("Digite o novo valor:");
            double valor = scanner.nextDouble();
            System.out.println("Digite o novo juros:");
            double juros = scanner.nextDouble();
            System.out.println("Digite o novo desconto:");
            double desconto = scanner.nextDouble();
            contaReceber.nome = nome;
            contaReceber.valor = valor;
            contaReceber.juros = juros;
            contaReceber.desconto = desconto;
            contaReceber.vencimento = vencimento;
            contaReceber.id = id;
            System.out.println("Conta a receber atualizada com sucesso!");
        } else {
            System.out.println("Conta a receber não encontrada.");
        }
    }

    public static void menuAlterarContasPagar() {
        exibirContasPagar();
        System.out.println("Digite o ID da conta a pagar que deseja alterar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        if (id >= 0 && id < contasPagar.size()) {
            ContaPagar contaPagar = contasPagar.get(id);
            System.out.println("Digite o novo nome da conta a pagar:");
            String nome = scanner.nextLine();
            System.out.println("Digite o data de vencimento:");
            String vencimento = scanner.nextLine();
            System.out.println("Digite o novo valor:");
            double valor = scanner.nextDouble();
            System.out.println("Digite o novo juros:");
            double juros = scanner.nextDouble();
            System.out.println("Digite o novo desconto:");
            double desconto = scanner.nextDouble();
            contaPagar.nome = nome;
            contaPagar.valor = valor;
            contaPagar.juros = juros;
            contaPagar.desconto = desconto;
            contaPagar.vencimento = vencimento;
            System.out.println("Conta a pagar atualizada com sucesso!");
        } else {
            System.out.println("Conta a pagar não encontrada.");
        }
    }



    public static void exibirFuncionarios() {
        System.out.println("\n--- Funcionários Cadastrados ---");
        for (Funcionario funcionario : funcionarios) {
            funcionario.imprimir();
        }
    }

    public static void exibirClientes() {
        System.out.println("\n--- Clientes Cadastrados ---");
        for (Cliente cliente : clientes) {
            cliente.imprimir();
        }
    }

    public static void exibirFornecedores() {
        System.out.println("\n--- Fornecedores Cadastrados ---");
        for (Fornecedor fornecedor : fornecedores) {
            fornecedor.imprimir();
        }
    }

    public static void exibirContasReceber() {
        System.out.println("\n--- Contas a Receber Cadastradas ---");
        for (ContaReceber conta : contasReceber) {
            conta.imprimir();
        }
    }

    public static void exibirContasPagar() {
        System.out.println("\n--- Contas a Pagar Cadastradas ---");
        for (ContaPagar conta : contasPagar) {
            conta.imprimir();
        }
    }
    public static void exibirMenuCadastro() {
        int opcao;
        do {
            System.out.println("\n");
            System.out.println("\n--- MENU DE CADASTRO ---");
            System.out.println("1. Cadastro de Funcionários");
            System.out.println("2. Cadastro de Clientes");
            System.out.println("3. Cadastro de Fornecedores");
            System.out.println("4. Cadastro de Contas a Receber");
            System.out.println("5. Cadastro de Contas a Pagar");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    menuCadastroFuncionarios();
                    break;
                case 2:
                    menuCadastroClientes();
                    break;
                case 3:
                    menuCadastroFornecedores();
                    break;
                case 4:
                    menuCadastroContasReceber();
                    break;
                case 5:
                    menuCadastroContasPagar();
                    break;
                case 6:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }


    public static void menuCadastroFuncionarios() {
        System.out.println("Digite o nome do funcionário:");
        String nome = scanner.nextLine();
        System.out.println("Digite o endereço:");
        String endereco = scanner.nextLine();
        System.out.println("Digite o telefone:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o email:");
        String email = scanner.nextLine();
        System.out.println("Digite o id:");
        int id = scanner.nextInt();
        Funcionario funcionario = new Funcionario(nome, endereco, telefone, email, id);
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public static void menuCadastroClientes() {
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o endereço:");
        String endereco = scanner.nextLine();
        System.out.println("Digite o valor de credito:");
        double limcred = scanner.nextDouble();
        System.out.println("Digite o telefone:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o email:");
        String email = scanner.nextLine();
        System.out.println("Digite o id:");
        int id = scanner.nextInt();
        Cliente cliente = new Cliente(nome, limcred, endereco, telefone, email, id);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public static void menuCadastroFornecedores() {
        System.out.println("Digite o nome do fornecedor:");
        String nome = scanner.nextLine();
        System.out.println("Digite o limite de compra:");
        double limcred = scanner.nextDouble();
        System.out.println("Digite o site: ");
        String endereco = scanner.nextLine();
        System.out.println("Digite o id:");
        int id = scanner.nextInt();
        Fornecedor fornecedor = new Fornecedor(nome, limcred,endereco, id);
        fornecedores.add(fornecedor);
        System.out.println("Fornecedor cadastrado com sucesso!");
    }

    public static void menuCadastroContasReceber() {
        System.out.println("Digite o nome da conta a receber:");
        String nome = scanner.nextLine();
        System.out.println("Digite o data de vencimento:");
        String vencimento = scanner.nextLine();
        System.out.println("Digite o desconto:");
        double valor = scanner.nextDouble();
        System.out.println("Digite o juros:");
        double juros = scanner.nextDouble();
        System.out.println("Digite o valor' :");
        double desconto = scanner.nextDouble();
        System.out.println("Digite o id:");
        int id = scanner.nextInt();
        ContaReceber contaReceber = new ContaReceber(nome, valor, juros, desconto, id, vencimento);
        contasReceber.add(contaReceber);
        System.out.println("Conta a receber cadastrada com sucesso!");
    }

    public static void menuCadastroContasPagar() {
        System.out.println("Digite o nome da conta a pagar:");
        String nome = scanner.nextLine();
        System.out.println("Digite o data de vencimento:");
        String vencimento = scanner.nextLine();
        System.out.println("Digite o desconto:");
        double valor = scanner.nextDouble();
        System.out.println("Digite o juros:");
        double juros = scanner.nextDouble();
        System.out.println("Digite o valor:");
        double desconto = scanner.nextDouble();
        System.out.println("Digite o id:");
        int id = scanner.nextInt();
        ContaPagar contaPagar = new ContaPagar(nome, valor, juros, desconto,id,vencimento);
        contasPagar.add(contaPagar);
        System.out.println("Conta a pagar cadastrada com sucesso!");
    }

    public static void exibirMenuExclusao() {
        int opcao;
        do {
            System.out.println("\n");
            System.out.println("\n--- MENU DE EXCLUSÃO ---");
            System.out.println("1. Excluir Funcionário");
            System.out.println("2. Excluir Cliente");
            System.out.println("3. Excluir Fornecedor");
            System.out.println("4. Excluir Conta a Receber");
            System.out.println("5. Excluir Conta a Pagar");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.println("7. exibirFluxoCaixa");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            switch (opcao) {
                case 1:
                    excluirFuncionario();
                    break;
                case 2:
                    excluirCliente();
                    break;
                case 3:
                    excluirFornecedor();
                    break;
                case 4:
                    excluirContaReceber();
                    break;
                case 5:
                    excluirContaPagar();
                    break;
                case 6:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

    public static void excluirFuncionario() {
        exibirFuncionarios();
        System.out.println("Digite o ID do funcionário a ser excluído:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).id == id) {
                funcionarios.remove(i);
                System.out.println("Funcionário excluído com sucesso!");
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    public static void excluirCliente() {
        exibirClientes();
        System.out.println("Digite o ID do cliente a ser excluído:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).id == id) {
                clientes.remove(i);
                System.out.println("Cliente excluído com sucesso!");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    public static void excluirFornecedor() {
        exibirFornecedores();
        System.out.println("Digite o ID do fornecedor a ser excluído:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        for (int i = 0; i < fornecedores.size(); i++) {
            if (fornecedores.get(i).id == id) {
                fornecedores.remove(i);
                System.out.println("Fornecedor excluído com sucesso!");
                return;
            }
        }
        System.out.println("Fornecedor não encontrado.");
    }

    public static void excluirContaReceber() {
        exibirContasReceber();
        System.out.println("Digite o ID da conta a receber a ser excluída:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        for (int i = 0; i < contasReceber.size(); i++) {
            if (contasReceber.get(i).id == id) {
                contasReceber.remove(i);
                System.out.println("Conta a receber excluída com sucesso!");
                return;
            }
        }
        System.out.println("Conta a receber não encontrada.");
    }

    public static void excluirContaPagar() {
        exibirContasPagar();
        System.out.println("Digite o ID da conta a pagar a ser excluída:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        for (int i = 0; i < contasPagar.size(); i++) {
            if (contasPagar.get(i).id == id) {
                contasPagar.remove(i);
                System.out.println("Conta a pagar excluída com sucesso!");
                return;
            }
        }
        System.out.println("Conta a pagar não encontrada.");
    }
}