
public class OffByN implements CharacterComparator{
	int N;
	
	public OffByN(int x){
		this.N = x;
	}

	@Override
	public boolean equalChars(char x, char y) {
		if(x - y == N || y - x == N){
			return true;
		}
		return false;
	}

}
