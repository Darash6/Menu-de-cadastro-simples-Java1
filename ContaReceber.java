class ContaReceber extends Entidade {


    public ContaReceber(String nome, double valor, double juros, double desconto,double limcred,double limdeb
            ,int id, String vencimento) {
        super(nome, desconto, juros, valor, id,vencimento, "", "",0, "06-02-2024");

    }

    public ContaReceber(String nome, double valor, double juros, double desconto, int id, String vencimento) {
        super(nome,valor,juros,0,id,"","","",0,"11-12-2024");
    }

    @Override
    public void entrar() {
        System.out.println("Entrando dados da conta a receber " + nome);
    }

    @Override
    public void imprimir() {
        System.out.println("Id da conta a receber:"+ id);
        System.out.println("Dados da conta a receber " + nome + ":");
        System.out.println("Valor: " + valor);
        System.out.println("Juros: " + juros);
        System.out.println("Desconto: " + desconto);
        System.out.println("Vencimento: " + vencimento);

    }
}