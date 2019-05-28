/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senac.model;

/**
 *
 * @author Alunos
 */
public class Produto {
    private int id;
    private String nome;
    private double valor;

    public Produto() {
    }

    public Produto(int id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void setValor(String valor){
        try{
            setValor(Double.parseDouble(valor));
        } catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return id + " - " + nome + " - R$"+valor;
    }
    
}
