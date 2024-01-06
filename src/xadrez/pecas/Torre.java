package xadrez.pecas;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez {
    public Torre(Tabuleiro xadrez, Cor cor) {
        super(xadrez, cor);
    }
    @Override
    public String toString(){
        return "T";
    }
    @Override
    public boolean[][] movimentosPossiveis(){
        boolean[][] mat =new boolean[getTabuleiro().getLinhas()]
                [getTabuleiro().getColunas()];
        Posicao p = new Posicao(0,0);
        //movimentos p/ acima
        p.setValor(posicao.getLinha()-1, posicao.getColuna());
        while (getTabuleiro().existePosicao(p) && !getTabuleiro().haPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha()-1);
        }
        if(getTabuleiro().existePosicao(p) && haPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }//fim dos movimentos p/ acima
        //movimentos p/ esquerda
        p.setValor(posicao.getLinha(), posicao.getColuna()-1);
        while (getTabuleiro().existePosicao(p) && !getTabuleiro().haPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna()-1);
        }
        if(getTabuleiro().existePosicao(p) && haPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //movimentos p/ direita
        p.setValor(posicao.getLinha(), posicao.getColuna() +1);
        while (getTabuleiro().existePosicao(p) && !getTabuleiro().haPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() +1);
        }
        if(getTabuleiro().existePosicao(p) && haPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }//fim dos movimentos p/ direito
        //movimentos p/ baixo
        p.setValor(posicao.getLinha()+1, posicao.getColuna());
        while (getTabuleiro().existePosicao(p) && !getTabuleiro().haPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha()+1);
        }
        if(getTabuleiro().existePosicao(p) && haPecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }//fim dos movimentos p/ baixo
        return mat;
    }

}
