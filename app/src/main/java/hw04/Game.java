package hw04;

import javafx.application.Platform;
import lombok.Getter;

import java.lang.reflect.Array;
import java.util.*;

public class Game {
    @Getter private Queue<Player> players;
    private Player nowPlayer;
    private Share shares;
    @Getter private TileList tileList;
    @Getter private List<Corporation> corporations;
    private UserInterface ui;


    public Game(){
        this.players = new ArrayDeque<>();
        this.tileList = new TileList();
        this.corporations = makeCorporations();
        for(char x = 1; x <= '\f'; ++x) {
            for(char y = 'A'; y <= 'I'; ++y) {
                this.tileList.add(new Tile(x, y));
            }
        }
        this.tileList.shuffle();

    }
    //
    public void newGame(){
        UserInterface ui = new UserInterface();
        int playerNum = players.size();
        System.out.println("player num "+playerNum);

    }

    public void makePlayer(Player player){
        this.players.add(player);
        System.out.println("make player num "+this.players.size());
        for(int i = 0; i < this.players.size(); i++){
            Player nowPlayer = players.peek();
            for(int j =0; j < nowPlayer.getTileList().getSize(); j++){
               System.out.println(nowPlayer.getTileList().getTile(j).getName());

            }
        }
    }

    public int playerNum(int num){
        System.out.println("Game player num "+num);
        for(int i = 0; i < num; i++){
            Player p = new Player("Player"+i);
            players.add(p);
        }
        for(Player p : players){
            System.out.println(p.getName());
        }
        return num;
    }


    public TileList tileLists(){
        return tileList;
    }

    public List<Corporation> makeCorporations(){
        List<Corporation> corporations = new ArrayList<>();
        corporations.add(new Corporation("corporation 1", "red", 200));
        corporations.add(new Corporation("corporation 2", "yellow", 200));
        corporations.add(new Corporation("corporation 3", "green", 200));
        corporations.add(new Corporation("corporation 4", "blue", 200));
        corporations.add(new Corporation("corporation 5", "purple", 200));
        corporations.add(new Corporation("corporation 6", "orange", 200));
        corporations.add(new Corporation("corporation 7", "pink", 200));
        return corporations;
    }

    public void nextPlayer(){
        int playerNum = players.size();
        System.out.println("player num "+playerNum);
        if(this.players.size() > 0){
            if(this.nowPlayer == null){
                nowPlayer = players.peek();
            }else{
                players.offer(players.poll());
                nowPlayer = players.peek();
            }


        }
    }


}
