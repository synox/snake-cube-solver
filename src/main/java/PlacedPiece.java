import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlacedPiece {
    Piece piece;
    Position position;
    // where the next piece must fit
    Vector outDirection;
}