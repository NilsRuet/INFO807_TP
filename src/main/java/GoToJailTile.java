public class GoToJailTile extends Tile{
    ///Constructor
    public GoToJailTile()
    {
        this.tileName = "Go to jail";
    }


    ///Methods
    @Override
    public void applyOnStop(Player player) {
        //DO NOTHING
    }

    @Override
    public void applyOnPassBy(Player player) {
        //DO NOTHING
    }
}
