package hw04;

import javafx.application.Platform;
import lombok.Getter;
import org.checkerframework.checker.units.qual.C;

import java.lang.reflect.Array;
import java.util.*;

public class Game {
    @Getter private LinkedList<Player> players;
    @Getter private Player nowPlayer;
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
        corporations.add(new Corporation("corporation 1", false, 200));
        corporations.add(new Corporation("corporation 2", false, 200));
        corporations.add(new Corporation("corporation 3", false, 200));
        corporations.add(new Corporation("corporation 4", false, 200));
        corporations.add(new Corporation("corporation 5", false, 200));
        corporations.add(new Corporation("corporation 6", false, 200));
        corporations.add(new Corporation("corporation 7", false, 200));
        return corporations;
    }

    public void placeTile(int x, char y){

    }

    public void nextPlayer(){
        int playerNum = players.size();
        System.out.println("player num "+playerNum);
        if(this.players.size() > 0){
            if(this.nowPlayer == null){
                System.out.println("null?");
                nowPlayer = players.peek();
            }else{
                System.out.println("not null?");

                players.offer(players.poll());
                nowPlayer = players.peek();
                System.out.println(nowPlayer.getName());
            }


        }
    }



    private void buyShare() {
        //index of corporation is from interface, Planning to implement later
        Corporation corporation = this.corporations.get(1);
        if(corporation.isMade()){
            if(corporation.getShares().size() > 0){
                if(nowPlayer.getMoney() >= corporation.getPrice()){
                    corporation.sellShares(nowPlayer);
                }
                // not enough money
            }
        }
    }

    private void sellShare(){
        //index of corporation is from interface, Planning to implement later
        Corporation corporation = this.corporations.get(1);
        Share share = new Share(nowPlayer.getName());
        if(corporation.isMade()){
            corporation.returnShares(nowPlayer, share);
        }
    }





}
