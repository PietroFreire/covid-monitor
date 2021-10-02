package usuarios;

public class Funcionarios extends Membros {
    private String num_funcional;


    public Funcionarios(int id, String nome, String senha, String data_nascimento, String cidade, String estado_saude, String num_funcional){
        super(id, nome, senha, data_nascimento, cidade, estado_saude);
        this.num_funcional = num_funcional;
    }

    public String getnum_funcional() {
        return num_funcional;
    }

    public void setnum_funcional(String num_funcional) {
        this.num_funcional = num_funcional;
    }
}
