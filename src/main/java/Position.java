import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Position {
    int x;
    int y;
    int z;

    public Position plus(Vector vector) {
        return switch (vector.axis) {
            case X -> new Position(this.x + vector.value, this.y, this.z);
            case Y -> new Position(this.x, this.y + vector.value, this.z);
            case Z -> new Position(this.x, this.y, this.z + vector.value);
        };
    }

    @Override
    public String toString() {
        return x + "," + y + "," + z;
    }

}
