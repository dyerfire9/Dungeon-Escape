public class Renderer {
    private Player player;
    private Board board;

    public Renderer() {}

    public String renderGame(Player player, Board board) {
        String board_str = board.toString();

        return board_str.substring(0, player.getPos())
                + player.toString()
                + board_str.substring(player.getPos() + 1);
    }



}
