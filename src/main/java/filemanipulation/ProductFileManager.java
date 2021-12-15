package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {
    private List<Product> products = new ArrayList<>();

    public void readProductsFromFile(Path path) {
        List<String> readProducts = new ArrayList<>();
        try {
            readProducts = Files.readAllLines(path);
            for (String readProduct : readProducts) {
                String[] temp = readProduct.split(";");
                products.add(new Product(temp[0], temp[1], Integer.parseInt(temp[2])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!");
        }
    }

    public void writePriceOverToFile(Path path, int price) {
        List<String> writeToFile = new ArrayList<>();
        for (Product scopedProduct : products) {
            if (scopedProduct.getPrice() > price) {
                writeToFile.add(scopedProduct.toString());
            }
        }
        try {
            Files.write(path, writeToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}