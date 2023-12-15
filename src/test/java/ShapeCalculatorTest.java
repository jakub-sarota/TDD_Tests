import org.example.util.ShapeCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class ShapeCalculatorTest {
	@Test
	void when_calculatingVolumeWithValidDimensions_then_returnCorrectValue() {
		// Given
		String dimensions = "10|/5|/8";

		// When
		double calculatedVolume = ShapeCalculator.shapeCalculator(dimensions, true);

		// Then
		assertNotNull(calculatedVolume);
		assertEquals(400.0, calculatedVolume);
	}

	@Test
	void when_calculatingFieldWithValidDimensions_then_returnCorrectValue() {
		// Given
		String dimensions = "10|/5|/8";

		// When
		double calculatedField = ShapeCalculator.shapeCalculator(dimensions, false);

		// Then
		assertNotNull(calculatedField);
		assertEquals(340.0, calculatedField);
	}
}
