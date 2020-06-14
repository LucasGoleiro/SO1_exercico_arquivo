import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		String path = "C:\\TEMP\\Aula";
		String nome = "arquivo.txt";
		Transformar t = new Transformar(path, nome);
		
		try {
			t.tranforma(path, nome);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
