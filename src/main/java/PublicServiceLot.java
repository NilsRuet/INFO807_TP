import java.util.ArrayList;
import java.util.List;

public class PublicServiceLot extends BuyableLot {

    ///Attributes
    public List<PublicServiceTile> children = new ArrayList<PublicServiceTile> ();

    ///Constructors
    public PublicServiceLot(ArrayList<PublicServiceTile> publicServiceTiles)
    {
        for (PublicServiceTile publicServiceTile : publicServiceTiles)
        {
            this.children.add(publicServiceTile);
            publicServiceTile.SetParent(this);
        }
    }

    @Override
    public void OnOwnershipChange() {
        //TODO
    }
}