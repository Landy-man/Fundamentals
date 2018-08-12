package game;

public class FizzBuzz {

	public String play(int i) {
		String returnVal = "";
		if (i<1 || i>100)
			return returnVal;
		for (int j=1; j<i;j++)
			returnVal += playTurn(j) + ", ";
		return returnVal + playTurn(i);
	}

	public String playTurn(int i) {
		String returnVal = "";
		if (i%3==0)
			returnVal +="Fizz";
		if (i%5==0)
			returnVal += "Buzz";
		if (returnVal.length()==0) 
			returnVal +=i;
		return returnVal;
	}

}
