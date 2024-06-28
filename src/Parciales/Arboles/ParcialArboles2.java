package Parciales.Arboles;

import Practica3.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class ParcialArboles2 {
    private GeneralTree<Integer> arbol;

    public ParcialArboles2(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> camino(int num){
        List<Integer> camino = new ArrayList<>();
        if (!this.arbol.isEmpty()){
            resolver(this.arbol, num, camino, new ArrayList<>());
        }
        return camino;
    }

    private List<Integer> resolver(GeneralTree<Integer> arbol, int num, List<Integer> camino, List<Integer> caminoAct){
        if (arbol.isLeaf()){
            caminoAct.add(arbol.getData());
            if (caminoAct.size() > camino.size()){
                camino.removeAll(camino);
                camino.addAll(caminoAct);
            }
            caminoAct.removeLast();
        } else {
          List<GeneralTree<Integer>> children = arbol.getChildren();
          if (children.size() >= num){
              caminoAct.add(arbol.getData());
              for (GeneralTree<Integer> c: children){
                  resolver(c, num, camino, caminoAct);
              }
              caminoAct.removeLast();
          }
          else {
              return camino;
          }
        }
        return camino;
    }

    public static void main(String[] args) {
        GeneralTree<Integer> nodo1 = new GeneralTree<>(-6);
        List<GeneralTree<Integer>> hijos1 = new ArrayList<>();
        hijos1.add(nodo1);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(28);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(55);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(18);
        List<GeneralTree<Integer>> hijos2 = new ArrayList<>();
        hijos2.add(nodo4); hijos2.add(nodo5); hijos2.add(nodo6);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(4);
        List<GeneralTree<Integer>> hijos3 = new ArrayList<>();
        hijos3.add(nodo7);
        GeneralTree<Integer> nodo10 = new GeneralTree<>(5, hijos1);
        GeneralTree<Integer> nodo11 = new GeneralTree<>(22, hijos2);
        List<GeneralTree<Integer>> hijos4 = new ArrayList<>();
        hijos4.add(nodo10); hijos4.add(nodo11);
        GeneralTree<Integer> nodo12 = new GeneralTree<>(19, hijos3);
        GeneralTree<Integer> nodo13 = new GeneralTree<>(-9, hijos3);
        List<GeneralTree<Integer>> hijos5 = new ArrayList<>();
        hijos5.add(nodo12); hijos5.add(nodo13);
        GeneralTree<Integer> nodo14 = new GeneralTree<>(8, hijos4);
        GeneralTree<Integer> nodo15 = new GeneralTree<>(42, hijos4);
        GeneralTree<Integer> nodo16 = new GeneralTree<>(-5, hijos5);
        List<GeneralTree<Integer>> hijos6 = new ArrayList<>();
        hijos6.add(nodo14); hijos6.add(nodo15); hijos6.add(nodo16);
        GeneralTree<Integer> arbol = new GeneralTree<>(10, hijos6);

        ParcialArboles2 metodo = new ParcialArboles2(arbol);

        System.out.println(metodo.camino(2));
    }
}
