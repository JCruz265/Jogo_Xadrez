package app;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class XadrezApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PartidaXadrez partidaXadrez = new PartidaXadrez();
        while (true){
            try {
                UI.limparTela();
                UI.plotarTabuleiro(partidaXadrez.getPecas());
                System.out.print("\nOrigem: ");
                PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
                System.out.print("\nAlvo: ");
                PosicaoXadrez alvo = UI.lerPosicaoXadrez(sc);
                PecaXadrez captuarPeca =
                        partidaXadrez.executeJogadaXadrez(origem, alvo);
            }catch (XadrezException | InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}

