import java.util.HashSet;
import java.util.Set;

enum Axis {
    X, Y, Z;

    public Set<Axis> getOtherAxes() {
        Set<Axis> set = new HashSet<>();
        set.add(X);
        set.add(Y);
        set.add(Z);
        set.remove(this);
        return set;
    }
}
