package xadrez;

import jogoTabuleiro.Peca;
import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
    //declarando atributo
    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        //instanciando o objeto tabuleiro definindo linhas e colunas com o mesmo valor de 8
        tabuleiro = new Tabuleiro(8, 8);
        configInicial();
    }//construtor padrão

    public PecaXadrez[][] getPecas() {
        //instanciando o objeto matriz quadrada peça de xadrez
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()]
                [tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                mat[i][j] = (PecaXadrez)tabuleiro.peca(i, j);
            }//fim do for para colunas
        }//fim do for para linhas
        return mat;
    }//fim do metodo peça de xadrez
    public PecaXadrez executeJogadaXadrez(PosicaoXadrez posicaoOriginal,
                                          PosicaoXadrez posicaoAlvo){
        Posicao origem = posicaoOriginal.praPosicao();
        Posicao alvo = posicaoAlvo.praPosicao();
        validarPosicaoOriginal(origem);
        validarPosicaoAlvo(origem,alvo);
        Peca capiturarPeca = fazerMover(origem, alvo);
        return (PecaXadrez) capiturarPeca;
    }
    private Peca fazerMover(Posicao original, Posicao alvo){
        Peca p = tabuleiro.removerPeca(original);
        Peca capiturarPeca = tabuleiro.removerPeca(alvo);
        tabuleiro.colocarPeca(p,alvo);
        return capiturarPeca;
    }
    //metodo validar
    private void validarPosicaoOriginal(Posicao posicao){
        if(!tabuleiro.haPeca(posicao)){
            throw new XadrezException("Não há peça na posição de origem");
        }
        if(!tabuleiro.peca(posicao).ePossivelMover()){
            throw new XadrezException("Não há movimentos possíveis para a peça escolhida");
        }
    }//fim do metodo de validar origem
    //metodo para validar alvo
    private void validarPosicaoAlvo(Posicao origem, Posicao alvo){
        if(!tabuleiro.peca(origem).movimentoPossivel(alvo)){
            throw new XadrezException("A peça escolhida não pode se mover para a posição alvo");
        }
    }//fim do metodo de validar origem

    private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
        tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).praPosicao());
    }

    //metodo para configurar as peças no inicio da partida
    private void configInicial() {

        colocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

        colocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
    }
}

