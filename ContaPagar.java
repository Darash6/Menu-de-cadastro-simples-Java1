class ContaPagar extends Entidade {
    public ContaPagar(String nome, double valor, double juros, double desconto, int id,String vencimento) {
        super(nome, desconto, juros, valor, id,vencimento, "", "", 0, "11-12-2024");


    }

    @Override
    public void entrar() {
        System.out.println("Entrando dados da conta a pagar " + nome);
    }

    @Override
    public void imprimir() {
        System.out.println("id: "+ id);
        System.out.println("Dados da conta a pagar " + nome + ":");
        System.out.println("Valor: " + valor);
        System.out.println("Juros: " + juros);
        System.out.println("Desconto: " + desconto);
        System.out.println("Data de vencimento: " + vencimento);

    }
}