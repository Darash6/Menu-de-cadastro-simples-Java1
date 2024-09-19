class Fornecedor extends Entidade {

    public Fornecedor(String nome, double limcred, String endereco, int id) {
        super(nome, 0, 0, 0, id, endereco, "", "", limcred,"");
    }
    ///////endereço = site, lincred= limite compra////////
    @Override
    public void entrar() {
        System.out.println("Entrando dados do fornecedor " + nome);
    }

    @Override
    public void imprimir() {
        System.out.println("id: "+ id);
        System.out.println("Dados do fornecedor " + nome + ":");
        System.out.println("Limite de compra: " + limcred);
        System.out.println("Site: " + endereco);

    }
}