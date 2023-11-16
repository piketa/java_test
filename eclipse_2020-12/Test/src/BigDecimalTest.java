import java.math.BigDecimal;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal[] bigArray = new BigDecimal[3];

		bigArray[0] = BigDecimal.valueOf(1);
		bigArray[1] = BigDecimal.valueOf(3);
		bigArray[2] = BigDecimal.valueOf(5);

		System.out.println(bigArray[0] + " + " + bigArray[2] + " = " + bigArray[0].add(bigArray[2]));
	}
}
