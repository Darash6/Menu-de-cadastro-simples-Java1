
abstract class Entidade {
    protected String vencimento;
    protected String nome;
    protected String endereco;
    protected String telefone;
    protected String email;
    protected double valor;
    protected double juros;
    protected double desconto;
    protected double limcred;
    protected double limdeb;
    protected int id;


    public Entidade(String nome, double valor, double juros, double desconto, int id, String endereco,
                    String telefone, String email, double limcred,String vencimento) {
        this.nome = nome;
        this.valor = valor;
        this.juros = juros;
        this.desconto = desconto;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.limcred = limcred;
        this.id = id;
        this.vencimento = vencimento;
    }

    public abstract void entrar();
    public abstract void imprimir();

    public double calcularTotal() {
        return valor + juros - desconto;
    }

    public boolean valoresValidos() {
        return valor != 0 || juros != 0 || desconto != 0;
    }
}