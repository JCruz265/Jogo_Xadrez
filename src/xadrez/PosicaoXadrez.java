package xadrez;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.TabuleiroException;

public class PosicaoXadrez {
    //declarando atributos
    private char coluna;
    private int linha;

    public PosicaoXadrez(char coluna, int linha) {
        if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8){
            throw new TabuleiroException("Erro ao instanciar a posição no Tabuleiro de xadrez. " +
                    "Valores validos são de 'a1' a 'h8'.");
        }
        this.coluna = coluna;
        this.linha = linha;
    }
    //metodos para acessar atributos
    public char getColuna() {
        return coluna;
    }
    public int getLinha() {
        return linha;
    }//fim dos metodos getter's
    //metodo para converter posição na matriz na posição do xadrez
    protected Posicao praPosicao(){
        return new Posicao(8 - linha, coluna - 'a');
    }
    protected static PosicaoXadrez dePosicao(Posicao posicao){
        return new PosicaoXadrez((char)('a'- posicao.getColuna()),8 - posicao.getLinha());
    }

    @Override
    public String toString() {
        return "" + coluna + linha;
    }
}
