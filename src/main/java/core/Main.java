package core;


import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import mappings.base.Player;

import java.util.Scanner;

public class Main {

    Database db;

    public static void main(String[] args) {
    	// será implementado um loop while (game.isGameRunning()) para continuar o jogo
    	// ao sair do loop, mostra vencedor
    }


    private DBCursor find(String collectionName, DBObject query) {
        return db.find(collectionName, query);
    }


    private Player createPlayer() {
        Player p = null;

        try {
            System.out.println("Criando jogador...");
            System.out.print("\nDigite o nome do usuário: ");
            Scanner s = new Scanner(System.in);
            String name = s.nextLine();
            p = new Player(name);
            db.savePlayer(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;

    }

    private Integer getUsersCount() {
        Scanner s = new Scanner(System.in);
        boolean validAmountOfUsers = false;
        int usersCount = 0;

        while (!validAmountOfUsers) {
            try {
                System.out.print("Digite a quantidade de usuários que jogarão: ");
                usersCount = s.nextInt();
                validAmountOfUsers = true;
            } catch (NumberFormatException e) {
                System.out.println("A quantidade deve ser um inteiro...");
            }
        }

        return usersCount;
    }



}

