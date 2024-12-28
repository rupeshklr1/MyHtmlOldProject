package exception_03_07;

class ownException extends Exception {
    public ownException(String s)
    {
        super(s);
    }
}
public class My_own_exception extends RuntimeException {

	public static void main(String[] args) {
		try {
			throw new ownException("Throw at line number 13.");
		}catch (Exception e) {
			System.out.println("This is at own Exception block.");
			System.out.println(e);
			System.out.println(e.getMessage());
		}

	}

}
