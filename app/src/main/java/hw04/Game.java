package hw04;

import javafx.application.Platform;
import lombok.Getter;

import java.lang.reflect.Array;
import java.util.*;

public class Game {
    @Getter private List<Player> players;
    private Player nowPlayer;
    private Share shares;
    @Getter private TileList tileList;
    @Getter private List<Corporation> corporations;
    private UserInterface ui;


    public Game(){
        this.players = new LinkedList<>();
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

    public void makePlayer(int playerNum){
        int temp =4;
        for(int i = 0; i < playerNum; i++){
            String playerName = "Player" + i;
            Player player = new Player(playerName);
            for(int j =0; j < 6; j++){
                Tile t = this.tileList.remove(j);
                player.addTile(t);
                //System.out.println(player.getTileList().getTile(j).getName());
            }
            this.players.add(player);
        }

        System.out.println("make player num "+this.players.size());

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

    public void placeTile(int x, char y){

    }


//    public void nextPlayer(){
//        int playerNum = players.size();
//        System.out.println("player num "+playerNum);
//        if(this.players.size() > 0){
//            if(this.nowPlayer == null){
//                nowPlayer = players.peek();
//            }else{
//                players.offer(players.poll());
//                nowPlayer = players.peek();
//            }
//
//
//        }
//    }





}
