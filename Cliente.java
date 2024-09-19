class Cliente extends Entidade {
    public Cliente(String nome, double limcred, String endereco, String telefone, String email, int id) {
        super(nome, 0, 0, 0, 0, "", "", "",0,"");
    }

    @Override
    public void entrar() {
        System.out.println("Entrando dados do cliente " + nome);
    }

    @Override
    public void imprimir() {
        System.out.println("Dados do cliente " + nome + ":");
        System.out.println("Endereço: " + endereco);
        System.out.println("Limite de Credito: " + limcred);
        System.out.println("Telefone: " + telefone);
        System.out.println("email: " + email);
        System.out.println("id: " + id);
    }
}