/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business.Fabrica.GestaoEncomenda;

import java.util.Comparator;

/**
 *
 * @author Grupo30
 */
public class ComponenteComparator implements Comparator<Componente> {

    /**
     * Compara duas Componentes consoante o seu preço
     * @param c1 componente 1
     * @param c2 componente 2
     * @return O preço da componente 1 é maior (-1); O contador da componente 2 é maior (1); São iguais (0);
     */
    public int compare(Componente c1, Componente c2) {
        if (c1.getPreco()< c2.getPreco()) return 1;
        if (c1.getPreco() > c2.getPreco()) return -1;
        return 0;
    }
}
