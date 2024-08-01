import org.apache.poi.ss.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextoAExcel {
    public static void main(String[] args) throws IOException {
        String texto = "Hola mundo esto es un ejemplo";
        String[] palabras = texto.split(" ");

        // Crear un nuevo libro de trabajo
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Hoja1");
        Row row = sheet.createRow(0);

        // Escribir las palabras en la fila
        int cellNum = 0;
        for (String palabra : palabras) {
            Cell cell = row.createCell(cellNum++);
            cell.setCellValue(palabra);
        }

        // Escribir el libro de trabajo en un archivo
        try (FileOutputStream outputStream = new FileOutputStream("mi_hoja.xlsx")) {
            workbook.write(outputStream);
        }
        System.out.println("Archivo Excel creado exitosamente.");
    }
}