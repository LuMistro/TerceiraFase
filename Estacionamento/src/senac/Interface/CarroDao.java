/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senac.Interface;

import java.util.List;
import senac.model.Carro;

/**
 *
 * @author Luiza Mistro
 */
public interface CarroDao {

    public boolean inserir(Object objeto);

    public boolean update(Object objeto);

    public Object pesquisar(Integer id);

    public boolean excluir(Integer id);

    public List<Carro> listar();

    public List<Carro> pesquisarTermo(String termo);
}
