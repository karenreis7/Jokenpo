import java.util.Scanner;

public class Main {

    public static Jokenpo startGame(){
        System.out.println("******* JoKenPo *******\n");
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String playerName = sc.next().toUpperCase();

        Player user = new Player(playerName);
        Player IA = new Player("ADVERSARIO");

        System.out.print("Olá, " + playerName +  "! Quantos rounds deseja jogar? ");
        int rounds = sc.nextInt();


        return new Jokenpo(user, IA, rounds);
    }


    public static void main(String[] args) {

        Jokenpo jokenpo = startGame();
        jokenpo.toPlay();
        jokenpo.showFinalResult();
    }
}
