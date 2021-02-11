import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("8c91ecaf-394b-446c-bee2-426ab6f7efb0")
public class MonopolyGame {
    @objid ("b49c790e-42f8-4e63-807e-876b76caf57e")
    public Player currentPlayer;

    @objid ("f96577da-92cc-4b3e-b561-6b11215d5943")
    public Board board;

    @objid ("fc0ee026-8ff8-47f6-9f6f-6f1d18546a2d")
    public List<Player> players = new ArrayList<Player> ();

    @objid ("242a0e32-2682-45b3-abef-5325a2bca463")
    public void StartGame() {
    }

    @objid ("f6446150-23b9-4458-bacd-3fd320554b02")
    public void MovePlayer(int tileCount) {
    }

}
