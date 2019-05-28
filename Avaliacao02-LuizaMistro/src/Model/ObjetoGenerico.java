/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Luiza Mistro
 */
public class ObjetoGenerico {

    private int id;
    private String atributo1;
    private String atributo2;
    private String atributo3;

    public ObjetoGenerico() {
    }

    public ObjetoGenerico(int id, String atributo1, String atributo2, String atributo3) {
        this.id = id;
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
        this.atributo3 = atributo3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtributo1() {
        return atributo1;
    }

    public void setAtributo1(String atributo1) {
        this.atributo1 = atributo1;
    }

    public String getAtributo2() {
        return atributo2;
    }

    public void setAtributo2(String atributo2) {
        this.atributo2 = atributo2;
    }

    public String getAtributo3() {
        return atributo3;
    }

    public void setAtributo3(String atributo3) {
        this.atributo3 = atributo3;
    }

    @Override
    public String toString() {
        return "Carro{" + "atributo1=" + atributo1 + ", atributo2=" + atributo2 + ", atributo3=" + atributo3 + '}';
    }

}
