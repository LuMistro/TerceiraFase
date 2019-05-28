/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;

/**
 *
 * @author Luiza Mistro
 */
public interface BaseDao<T> {

    public List<T> listar();

    public int cadastrar(T obj);

    public boolean alterar(T obj);

    public boolean deletar(int id);

    public T procurarPorId(int id);

    public List<T> pesquisar(String termo);

}
