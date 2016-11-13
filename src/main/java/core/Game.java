package core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import mappings.base.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mresende on 13/11/16.
 */
public class Game {

    Database db;

    public static void main(String[] args) {
        Game g = new Game();

        // get the number of users that will play
        Integer amountOfUsers = g.getUsersCount();
        List<Player> players = new ArrayList<Player>(amountOfUsers);

        // Creating players
        for (int i = 0; i < amountOfUsers; i++) {
            players.add(g.createPlayer());
        }

        // finding players
        BasicDBObject query = new BasicDBObject();
        query.put("name", players.get(0).getName());

        DBCursor results = g.find("players", query);
        ObjectMapper mapper = new ObjectMapper();

        while (results.hasNext()) {
            try {
                System.out.println(mapper.readValue(results.next().toString(), Player.class).getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Game() {
        db = new Database();
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
