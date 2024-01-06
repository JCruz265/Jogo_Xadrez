package xadrez;

import jogoTabuleiro.Peca;
import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca {
    //declarando atributos não herdados
    private Cor cor;

    public PecaXadrez(Tabuleiro xadrez, Cor cor) {
        super(xadrez);
        this.cor = cor;
    }//construtor com atributos herdados e não herdados

    //metodo para acessar atributos
    public Cor getCor() {
        return cor;
    }//fim do metodo getter
    protected boolean  haPecaOponente(Posicao posicao){
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p != null && p.getCor() != cor;
    }
}
