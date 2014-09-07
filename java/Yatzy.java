public class Yatzy {
	
	private static final int DICE_NUMBER = 5;
	private Integer[] dice;
    public Yatzy() {
		// TODO Auto-generated constructor stub
	}
    
    public Yatzy(int d1, int d2, int d3, int d4, int d5)
    {
    	Integer[] movement = new Integer[]{d1,d2,d3,d4,d5};
        dice = new Integer[DICE_NUMBER];
        for(int i=0;i<movement.length;i++){
        	dice[i] = movement[i];
        }
    }

	public int getChance(int d1, int d2, int d3, int d4, int d5) {
		Integer[] dice = new Integer[] { d1, d2, d3, d4, d5 };
		int chance = 0;
		for (int i = 0; i < DICE_NUMBER; i++) {
			chance += dice[i];
		}
		return chance;
	}

    public int yatzy(int... dice)
    {
        int[] counts = getCounts(dice);
        for (int i = 0; i < 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }



	public int ones(int d1, int d2, int d3, int d4, int d5) {
		return new Yatzy(d1, d2, d3, d4, d5).sumMatchingValues(1);
    }

    public int twos(int d1, int d2, int d3, int d4, int d5) {
    	return new Yatzy(d1, d2, d3, d4, d5).sumMatchingValues(2);
    }

	private int sumMatchingValues(int value) {
		int s = 0;
		for (int i=0; i < DICE_NUMBER; i++){
			if (dice[i] == value) s += value;
		}
        return s;
	}

    public int threes(int d1, int d2, int d3, int d4, int d5) {
    	return new Yatzy(d1, d2, d3, d4, d5).sumMatchingValues(3);
    }

	public int fours()
    {
		return sumMatchingValues(4);
    }

	public int fives()
    {
		return sumMatchingValues(5);
    }

    public int sixes()
    {
    	return sumMatchingValues(6);
    }

    public int score_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = getCounts(d1, d2, d3, d4, d5);
        for (int at = 0; at < 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }

    public int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = getCounts(d1, d2, d3, d4, d5);
        int n = 0;
        int score = 0;
        for (int i = 5; i >= 0; i--)
            if (counts[i] >= 2) {
                n++;
                score += (i+1);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }
    
    private int[] getCounts(int[] dice) {
    	int[] counts = new int[6];
    	for(int i =0; i< DICE_NUMBER; i++){
    		counts[dice[i]-1]++;
    	}
		return counts;
	}

	private int[] getCounts(int d1, int d2, int d3, int d4, int d5) {
		return getCounts(new int[]{d1,d2,d3,d4,d5});
		
	}

    public int four_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies = getCounts(d1, d2, d3, d4, d5);
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] t = getCounts(d1, d2, d3, d4, d5);
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

	public int smallStraight(int d1, int d2, int d3, int d4, int d5) {
		int[] tallies = getCounts(d1, d2, d3, d4, d5);
		if (hasValueInRange(1, 0, 4, tallies)) {
			return 15;
		}
		return 0;
	}

	public int largeStraight(int d1, int d2, int d3, int d4, int d5) {
		int[] tallies = getCounts(d1, d2, d3, d4, d5);
		if (hasValueInRange(1, 1, 5, tallies)) {
			return 20;
		}
		return 0;
	}

    private boolean hasValueInRange(int needle, int start, int end, int[] haystack) {
    	for(int i = start; i<=end; i++){
    		if(haystack[i]!=needle){
    			return false;
    		}
    	}
    	return true;
    }

	public int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies = getCounts(d1, d2, d3, d4, d5);
        boolean _2 = false;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        for (int i = 0; i < 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (int i = 0; i < 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



