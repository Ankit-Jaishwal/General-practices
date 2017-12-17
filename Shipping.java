public class Shipping {
	public static int minimalNumberOfPackages(int items,
			int availableLargePackages, int availableSmallPackages) {
		if(items <= 0 ){
			throw new UnsupportedOperationException();
		}
		int quot = items/5;
		int mod = items%5;
		int smallReq = 0;
		int diff = quot - availableLargePackages;
		if(diff >= 0){
			smallReq = diff*5 + mod;
			if(smallReq > availableSmallPackages){
				return -1;
			} else {
				return availableLargePackages + smallReq;
			}
		} else {
			if(mod >= availableSmallPackages){
				return -1;
			} else {
				return quot + mod;
			}
			
		}
		
	}

	public static void main(String[] args) {
		System.out.println(minimalNumberOfPackages(16, 2, 10));
	}
}