package gradebook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	private GradeBook gb1;
	private GradeBook gb2;

	@BeforeEach
	void setUp() throws Exception {
		gb1 = new GradeBook(5);
		gb2 = new GradeBook(5);
		gb1.addScore(75);
		gb1.addScore(80);
		gb1.addScore(90);
		gb1.addScore(92);
		gb1.addScore(95);
		gb2.addScore(85);
		gb2.addScore(90);
		gb2.addScore(95);
		gb2.addScore(98);
		gb2.addScore(100);
	}

	@AfterEach
	void tearDown() throws Exception {
		gb1 = null;
		gb2 = null;
	}
	
	void testToString() {
		assertEquals("75 80 90 92 95 ", gb1.toString());
		assertEquals("85 90 95 98 100 ", gb2.toString());
	}
	
	void testGetScoreSize() {
		assertEquals(5, gb1.getScoreSize());
		assertEquals(5, gb2.getScoreSize());
	}

	@Test
	void testAddScore() {
		assertTrue(gb1.toString().equals("75.0 80.0 90.0 92.0 95.0"));
		assertTrue(gb2.toString().equals("85.0 90.0 95.0 98.0 100.0"));
	}

	@Test
	void testSum() {
		assertEquals(432, gb1.sum(), .0001);
		assertEquals(468, gb2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(75, gb1.minimum(), 0.001);
		assertEquals(85, gb2.minimum(), 0.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(357, gb1.finalScore());
		assertEquals(383, gb2.finalScore());
	}

}
