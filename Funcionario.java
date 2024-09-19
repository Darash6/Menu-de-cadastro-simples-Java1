class Funcionario extends Entidade {
    public Funcionario(String nome, String endereco, String telefone, String email, int id) {
        super(nome, 0, 0, 0, id, endereco, telefone, email, 0,"");
    }


    @Override
    public void entrar() {
        System.out.println("Entrando dados do funcionário " + nome);
    }

    @Override
    public void imprimir() {
        System.out.println("id: "+ id);
        System.out.println("Dados do funcionário " + nome + ":");
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
    }
}