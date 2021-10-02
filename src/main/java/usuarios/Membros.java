package usuarios;
public class Membros {

    private int id;
    private String nome;
    private String senha;
    private String data_nascimento;
    private String cidade;
    private String estado_saude;

    public Membros(int id, String nome, String senha, String data_nascimento, String cidade, String estado_saude){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.cidade = cidade;
        this.estado_saude = estado_saude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado_saude() {
        return estado_saude;
    }

    public void setEstado_saude(String estado_saude) {
        this.estado_saude = estado_saude;
    }

    public boolean login(String senha) {
        if (this.senha == senha) {
            System.out.println("[!] Acesso Permitido!");
            return true;
        } else {
            System.out.println("[!] Acesso Negado!");
            return false;
        }
    }
}
