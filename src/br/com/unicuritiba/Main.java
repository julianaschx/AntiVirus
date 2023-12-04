package br.com.unicuritiba;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

	

		    public static void main(String[] args) {
		        List<String> extensoesProcuradas = new ArrayList<>();
		        extensoesProcuradas.add(".exe"); 
		        extensoesProcuradas.add(".bat");

		        String diretorio = "C:\\Windows";  
		        List<String> relatorio = encontrarArquivosComExtensao(diretorio, extensoesProcuradas);

		        
		        System.out.println("Arquivos suspeitos encontrados:");
		        for (String arquivo : relatorio) {
		            System.out.println(arquivo);
		        }
		    }

		    private static List<String> encontrarArquivosComExtensao(String diretorio, List<String> extensoes) {
		        List<String> relatorio = new ArrayList<>();
		        File dir = new File(diretorio);

		        if (dir.exists() && dir.isDirectory()) {
		            File[] arquivos = dir.listFiles();

		            if (arquivos != null) {
		                for (File arquivo : arquivos) {
		                    if (arquivo.isFile()) {
		                        for (String extensao : extensoes) {
		                            if (arquivo.getName().toLowerCase().endsWith(extensao)) {
		                                relatorio.add(arquivo.getAbsolutePath());
		                                break;  
		                            }
		                        }
		                    }
		                }
		            }
		        }

		        return relatorio;
		    }
		

	}
