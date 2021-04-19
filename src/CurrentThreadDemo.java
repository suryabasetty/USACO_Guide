
public class CurrentThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		int i = 0;
		while (true) {
			System.out.print(i++);
			if (i > 5) {
				break;
			}
		}
	}
}

