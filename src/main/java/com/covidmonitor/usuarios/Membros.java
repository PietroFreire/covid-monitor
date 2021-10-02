package com.covidmonitor.usuarios;

import javax.persistence.*;

@Entity(name = "Membros")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoMembro")
public abstract class Membros {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String nome;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "data_nascimento")
    private String data_nascimento;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado_saude")
    private String estado_saude;

    public Membros(Long id, String nome, String senha, String data_nascimento, String cidade, String estado_saude){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.cidade = cidade;
        this.estado_saude = estado_saude;
    }

    public Membros() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

//    @Entity
//    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//    @DiscriminatorColumn(name = “Publication_Type”)
//    public abstract class Publication {
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.AUTO)
//        @Column(name = “id”, updatable = false, nullable = false)
//        protected Long id;
//
//        @Column
//        protected String title;
//
//        @Version
//        @Column(name = “version”)
//        private int version;
//
//        @ManyToMany
//        @JoinTable(name = “PublicationAuthor”, joinColumns = { @JoinColumn(name = “publicationId”, referencedColumnName = “id”) }, inverseJoinColumns = { @JoinColumn(name = “authorId”, referencedColumnName = “id”) })
//        private Set authors = new HashSet();
//
//        @Column
//        @Temporal(TemporalType.DATE)
//        private Date publishingDate;
//
//    …
//    }
}
