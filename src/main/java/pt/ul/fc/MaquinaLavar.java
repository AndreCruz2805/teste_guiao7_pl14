package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Lavar roupa numa máquina de lavar. */
@StateSet({"vazia", "carregada", "aLavar", "terminada"})
public class MaquinaLavar {

    @StateRefinement(to="vazia()")
    public MaquinaLavar() {}

    /** Inicia a lavagem. */
    @StateRefinement(from="carregada(this)", to="aLavar(this)")
    public void iniciar() {}

    /** Termina a lavagem. */
    @StateRefinement(from="aLavar(this)", to="terminada(this)")
    public void terminar() {}

    /** Interrompe a lavagem; a roupa fica na máquina. */
    @StateRefinement(from="aLavar(this)", to="carregada(this)")
    public void interromper() {}

    /** Carrega a roupa. */
    @StateRefinement(from="vazia(this)", to="carregada(this)")
    public void carregar() {}

    /** Descarrega a roupa; a máquina fica vazia. */
    @StateRefinement(from="terminada(this)", to="vazia(this)")
    public void descarregar() {}
}
