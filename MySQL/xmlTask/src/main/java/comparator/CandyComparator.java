package comparator;
import model.Candy;
import java.util.Comparator;

public class CandyComparator implements Comparator<Candy> {
    @Override
    public int compare(Candy c1, Candy c2) {
        return Double.compare(c1.getEnergy(), c2.getEnergy());
    }
}
