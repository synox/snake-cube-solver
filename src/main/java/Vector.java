import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Vector {
    X_POS(Axis.X, 1),
    X_NEG(Axis.X, -1),
    Y_POS(Axis.Y, 1),
    Y_NEG(Axis.Y, -1),
    Z_POS(Axis.Z, 1),
    Z_NEG(Axis.Z, -1);

    public final Axis axis;
    public final int value;

    Vector(Axis axis, int value) {
        this.axis = axis;
        this.value = value;
    }

    public List<Vector> getVectorsAt90Degrees() {
        return Arrays.stream(values()).filter(vector -> vector.axis != this.axis)
                .collect(Collectors.toList());
    }
}

