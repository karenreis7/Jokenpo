import java.util.Random;
import java.util.Scanner;

public record Jokenpo(
        Player user,
        Player IA,
        int rounds
) {

    public void  toPlay(){
        System.out.println("\n******* SEJA BEM-VINDO(A), " + user.getName() + " *******\n");

        for (int i = 1; i <= rounds; i++){
            int choiceUser =  choiceUser();
            if (choiceUser < 1 || choiceUser >3){
                System.out.print("\nJOGADA INVALIDA! ESCOLHA SOMENTE OS NUMEROS (1, 2 ou 3)\n");
                System.out.println("\tPONTO PARA " + IA.getName() + "!" + "\n");
                IA.incrementScore();
                continue;
            }

            int choiceIA = choiceIA();

            System.out.print("\t" + user.getName() + " " + choiceUser + " X " + choiceIA + " " + IA.getName() + "\n");

            int result = choiceUser - choiceIA;

            winnerRound(result);
        }

    }

    private int choiceUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - PEDRA ");
        System.out.println("2 - PAPEL ");
        System.out.println("3 - TESOURA ");

        System.out.println("Informe sua jogada: ");

        return sc.nextInt();
    }


    public  void showFinalResult(){
        System.out.println("\n******************************************************\n");

        Integer finalScoreUser = user.getScore();
        Integer finalScoreIA = IA.getScore();

        System.out.println("\n\t PLACAR FINAL: " + user.getName() + " " + user.getScore() + " X " + IA.getScore() + " " + IA.getName());

        if (finalScoreUser == finalScoreIA){
            System.out.println("\t\t\tEMPATE!");
        } else {
            String finalWinner = (finalScoreUser > finalScoreIA) ? user.getName() : IA.getName();
            System.out.println("\t\tVENCEDOR = " + finalWinner.toUpperCase());
            System.out.println("\n******************************************************");
        }
    }
    private  void winnerRound(int result){
        String winnerRound;

        if (result == 0){
            winnerRound = "EMPATE!";
        } else {
            if (result == -1 || result == 2){
                IA().incrementScore();
                winnerRound = IA().getName();
            }else {
                user.incrementScore();
                winnerRound = user.getName();
            }
        }
        System.out.println("\nVencedor do Round: " + winnerRound + "\n");
    }


    private int choiceIA(){
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

}