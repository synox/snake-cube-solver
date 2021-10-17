import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Game {

    private final int xFields;
    private final int yFields;
    private final int zFields;
    private LinkedList<Piece> chain;
    LinkedList<QubeModel> winners = new LinkedList<>();
    Set<QubeModel> uniqueModels = new HashSet<>();
    int plays = 0;

    public Game(int xFields, int yFields, int zFields, LinkedList<Piece> chain) {
        this.xFields = xFields;
        this.yFields = yFields;
        this.zFields = zFields;
        this.chain = chain;
    }

    public static void main(String[] args) {
        Game game = new Game(3, 3, 3, Piece.createChain("--...-..-...-.-....-.-.-.--"));
        game.run();

        System.out.println("-------");
        System.out.println("played " + game.plays + " variation");
        System.out.println("saw " + game.uniqueModels.size() + " different positions");
        System.out.println("winners:");
        game.winners.forEach(System.out::println);


        assertEquals("""
                Y\\X  Z0     Z1     Z2
                     ↓→Z    →zZ    ↓←←   \s
                     ↓Z↓    ↑Zz    ↓→z   \s
                     →↑Z    ↑←←    →→→
                """.trim(), game.winners.get(0).toString().trim());

        assertEquals("""
                Y\\X  Z0     Z1     Z2
                     ↓Z↓    Z←z    →→z   \s
                     ↓↑↓    →→Z    ↓←←   \s
                     Z↑Z    ↑zZ    →zZ \s
                """.trim(), game.winners.get(1).toString().trim());


    }

    private void run() {
        QubeModel model = new QubeModel(xFields, yFields, zFields);

        model = model.add(chain.getFirst(), new Position(0, 0, 0), Vector.Y_POS);
        placeNext(model);
    }


    private void placeNext(QubeModel model) {
        plays++;
        System.out.println(model);
        uniqueModels.add(model);

        PlacedPiece prev = model.stack.getLast();
        if (prev.piece.getNextPiece() == null) {
            // end of chain reached. It is considered a winner
            // because we used the whole chain without a violation.
            winners.add(model);
            return;
        }

        Piece currentPiece = prev.piece.getNextPiece();
        Position currentField = prev.position.plus(prev.outDirection);
        if (!model.isValid(currentField) || model.isBusyField(currentField)) {
            System.out.println("can not move");
            return;
        }

        if (currentPiece instanceof Piece.Turn) {
            // in 3d there are 4 possible vectors at 90 degrees.
            for (Vector currentOutputDirection : prev.outDirection.getVectorsAt90Degrees()) {
                QubeModel newModel = model.add(currentPiece, currentField, currentOutputDirection);
                placeNext(newModel);
            }
        } else {
            // place in same direction
            QubeModel newModel = model.add(currentPiece, currentField, prev.outDirection);
            placeNext(newModel);
        }
    }


}
