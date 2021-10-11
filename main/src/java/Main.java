package java;

public class Main {
    
    public static void main(String[] args) {

        Game game = new Game();
        Seeder seeder = new Seeder();
        SystemInOut inOut = new SystemInOut();

        game.run(inOut);

    }
