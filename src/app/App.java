package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Product;

public class App {
	public static void main(String[] args) {
		String sourceFile = "C:\\Users\\User\\eclipse-workspace\\System_files_managment\\src\\repository\\source.csv";
		String[] attribute = new String[3];
		List<Product> products = new ArrayList<Product>();
		String pathdir = "C:\\Users\\\\User\\eclipse-workspace\\System_files_managment\\src\\repository";

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
			String line = br.readLine();
			String outFilePath = pathdir + "\\outdir\\out.csv";
			while (line != null) {
				attribute = line.split(";");

				Product prod = new Product(attribute[0], Double.parseDouble(attribute[1].trim()),
						Integer.parseInt(attribute[2].trim()));
				products.add(prod);
				line = br.readLine();
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFilePath));) {
				for (Product p : products) {
					bw.write(p.getName() + ";" + String.format("%.2f" ,p.totalValue()));
					bw.newLine();
					System.out.println(p.getName() + " gravado com sucesso!!");
				}
			} catch (IOException e) {
				System.out.println("Erro: " + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
