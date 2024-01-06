package xadrez.pecas;

import jogoTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {
    public Rei(Tabuleiro xadrez, Cor cor) {
        super(xadrez, cor);
    }
    @Override
    public String toString(){
        return "R";
    }
    @Override
    public boolean[][] movimentosPossiveis(){
        boolean[][] mat =new boolean[getTabuleiro().getLinhas()]
                [getTabuleiro().getColunas()];
        return mat;
    }
}