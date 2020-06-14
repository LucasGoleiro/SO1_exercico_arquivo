import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Transformar {
	public String texto = "";
	String path;
	String nome;
	public Transformar(String path, String nome) {
		super();
		this.path = path;
		this.nome = nome;
	}
	
	public void tranforma(String path, String nome) throws IOException {
		
		File arq = new File(path, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				texto = linha;
				System.out.println(linha);
				linha = buffer.readLine();
				
			}
			System.out.println(texto);
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo invalido");
		}
		File dir = new File(path);
		File arquivo = new File(path, "arquivo.csv");
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = texto;
			FileWriter fileWriter = new FileWriter(arquivo, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretório inválido");
		}
		
	};
	
}
