import java.io.Console;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player {

    private final int startingMoney = 1500;

    private String playerName;

    private int money = 0;

    private List<BuyableTile> ownedTiles = new ArrayList<BuyableTile> ();

    private MonopolyGame game;

    private DiceCup diceCup;

    public Player(MonopolyGame game, String playerName)
    {
        this.playerName = playerName;
        money = startingMoney;
        diceCup = new DiceCup();
        this.game = game;
    }

    public void playTurn() {
        System.out.println("--" + playerName +"'s turn --");
        playOneRoll();
        while (canPlayAgain()){
            System.out.println(playerName+" rolled a double and can play again !");
            playOneRoll();
        }
    }
    private void playOneRoll(){
        int distance = rollDiceRoutine();
        System.out.println("Rolled "+distance);
        game.movePlayer(distance);
        constructionRoutine();
    }

    public boolean canAfford(int amount) {
        return money>=amount;
    }

    public void debit(int amount) {
        money-=amount;
    }

    public boolean displayBuyingProposition(BuyableTile tile) {
        System.out.println("Current balance : "+money+"$");
        System.out.println("Do you want to buy this tile ? [y/n]");
        System.out.println(tile.toString());
        Scanner input = new Scanner( System.in );
        return input.nextLine().toLowerCase().startsWith("y");
    }

    public int rollDiceRoutine() {
        diceCup.rollDice();
        return diceCup.getSum();
    }

    public void addOwnedTile(BuyableTile tile){
        this.ownedTiles.add(tile);
    }

    public void removeOwnedTile(BuyableTile tile){
        this.ownedTiles.remove(tile);
    }

    private void constructionRoutine() {
        ArrayList<PropertyTile> owned = getOwnedProperties();
        if(owned.size()>0){
            System.out.println("Current balance : "+money+"$");
            displayOwnedProperties(owned);
            PropertyTile t = getPropertyChoice(owned);
            if(t!= null){
                t.build();
            }
        }
    }

    private boolean canPlayAgain() {
        return diceCup.checkDouble();
    }

    private void displayOwnedProperties(ArrayList<PropertyTile> properties) {
        System.out.println(playerName+"'s properties :");
        for(int i=0;i<properties.size();i++){
            PropertyTile t = properties.get(i);
            System.out.println(i+") "+t.toBuildInfoString());
        }
    }

    private PropertyTile getPropertyChoice(ArrayList<PropertyTile> ownedProperties){
        Scanner input = new Scanner( System.in );
        System.out.println("Which property do you want to build on ?");
        System.out.println("Type -1 to build on none.");
        try{
            int p = input.nextInt();
            if(p<0 || p>=ownedProperties.size()){
                return null;
            } else {
                return ownedProperties.get(p);
            }
        } catch(InputMismatchException e) {
            return null;
        }

    }

    private ArrayList<PropertyTile> getOwnedProperties(){
        ArrayList<PropertyTile> res = new ArrayList<PropertyTile>();
        for(BuyableTile tile : ownedTiles){
            if(tile instanceof PropertyTile){
                res.add((PropertyTile) tile);
            }
        }
        return res;
    }

    public void transferMoney(int amount, Player player) {
        this.debit(amount);
        player.receiveMoney(amount);
    }

    public void receiveMoney(int amount) {
        money+= amount;
    }

    public int getMoney() {
        return money;
    }

    public int getDiceSum() {
        return diceCup.getSum();
    }

    public String toString()
    {
        return this.playerName;
    }
}
