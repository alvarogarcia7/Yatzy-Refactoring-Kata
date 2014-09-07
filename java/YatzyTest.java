import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    private Yatzy sut;
    
    @Before
    public void setUp(){
    	sut = new Yatzy();
    }

	@Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
		int actual = sut.getChance(2,3,4,5,1);
        assertEquals(expected, actual);
        assertEquals(16, sut.getChance(3,3,4,5,1));
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = sut.yatzy(4,4,4,4,4);
        assertEquals(expected, actual);
        assertEquals(50, sut.yatzy(6,6,6,6,6));
        assertEquals(0, sut.yatzy(6,6,6,6,3));
    }

    @Test public void test_1s() {
        assertTrue(sut.ones(1,2,3,4,5) == 1);
        assertEquals(2, sut.ones(1,2,1,4,5));
        assertEquals(0, sut.ones(6,2,2,4,5));
        assertEquals(4, sut.ones(1,2,1,1,1));
    }

    @Test
    public void test_2s() {
        assertEquals(4, sut.twos(1,2,3,2,6));
        assertEquals(10, sut.twos(2,2,2,2,2));
    }

    @Test
    public void test_threes() {
        assertEquals(6, sut.threes(1,2,3,2,3));
        assertEquals(12, sut.threes(2,3,3,3,3));
    }

    @Test
    public void fours_test() 
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    public void fives() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, sut.score_pair(3,4,3,5,6));
        assertEquals(10, sut.score_pair(5,3,3,3,5));
        assertEquals(12, sut.score_pair(5,3,6,6,5));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, sut.two_pair(3,3,5,4,5));
        assertEquals(16, sut.two_pair(3,3,5,5,5));
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(9, sut.three_of_a_kind(3,3,3,4,5));
        assertEquals(15, sut.three_of_a_kind(5,3,5,4,5));
        assertEquals(9, sut.three_of_a_kind(3,3,3,3,5));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, sut.four_of_a_kind(3,3,3,3,5));
        assertEquals(20, sut.four_of_a_kind(5,5,5,4,5));
        assertEquals(9, sut.three_of_a_kind(3,3,3,3,3));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, sut.smallStraight(1,2,3,4,5));
        assertEquals(15, sut.smallStraight(2,3,4,5,1));
        assertEquals(0, sut.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, sut.largeStraight(6,2,3,4,5));
        assertEquals(20, sut.largeStraight(2,3,4,5,6));
        assertEquals(0, sut.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, sut.fullHouse(6,2,2,2,6));
        assertEquals(0, sut.fullHouse(2,3,4,5,6));
    }
}
