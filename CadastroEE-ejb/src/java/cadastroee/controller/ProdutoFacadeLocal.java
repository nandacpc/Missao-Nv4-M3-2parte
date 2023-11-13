
package cadastroee.controller;

import cadastroee.model.Produtos;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProdutoFacadeLocal {

    void create(Produtos produto);

    void edit(Produtos produto);

    void remove(Produtos produto);

    Produtos find(Object id);

    List<Produtos> findAll();

    List<Produtos> findRange(int[] range);

    int count();
    
}
