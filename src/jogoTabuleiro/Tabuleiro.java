package jogoTabuleiro;

public class Tabuleiro{
        //declarando atributos
        private int linhas;
        private int colunas;
        private Peca[][] pecas;


        public Tabuleiro(int linhas, int colunas) {
            if(linhas < 1 || colunas < 1){
                throw new TabuleiroException("Erro ao criar tabuleiro: deve haver pelo menos 1 linha e 1 coluna");
            }
            this.linhas = linhas;
            this.colunas = colunas;
            //instanciando a matriz peças
            pecas = new Peca[linhas][colunas];
        }//construtor com argumentos
        //metodos para acessar atributos
        public int getLinhas() {
            return linhas;
        }

        public int getColunas() {
            return colunas;
        }//fim dos metodos getter's

        //metodo para retornar uma peça atraves posição
        public Peca peca(int linha, int coluna) {
            if(!existePosicao(linha, coluna)){
                throw new TabuleiroException("Está posição não existe no tabuleiro");
            }
            return pecas[linha][coluna];
        }//fim do metodo peça

        //sobrecarga do metodo peca
        public Peca peca(Posicao posicao) {
            if(!existePosicao(posicao)){
                throw new TabuleiroException("Está posição não existe no tabuleiro");
            }
            return pecas[posicao.getLinha()][posicao.getColuna()];
        }//fim da sobrecarga do metodo peça
        public void colocarPeca(Peca peca, Posicao posicao){
            if(haPeca(posicao)){
                throw new TabuleiroException("Já há uma peça na posição "+ posicao);      }
            pecas[posicao.getLinha()][posicao.getColuna()] = peca;
            peca.posicao = posicao;
        }
        public Peca removerPeca(Posicao posicao){
            if (!existePosicao(posicao)) {
                throw new TabuleiroException("Está posição não existe no tabuleiro");
            }
            if (peca(posicao) == null){
                return null;
            }
            Peca auxiliar = peca(posicao);
            auxiliar.posicao = null;
            pecas[posicao.getLinha()][posicao.getColuna()]= null;
            return auxiliar;
        }
        private boolean existePosicao(int linha, int coluna){
            return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
        }
        public boolean existePosicao(Posicao posicao){
            return existePosicao(posicao.getLinha(), posicao.getColuna());
        }
        public boolean haPeca(Posicao posicao){
            if(!existePosicao(posicao)){
                throw new TabuleiroException("Está posição não existe no tabuleiro");
            }
            return peca(posicao) != null;
        }

}

