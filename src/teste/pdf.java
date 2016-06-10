package teste;

import br.univates.libraries.PDF;

public class pdf
{
    public static void main(String[] args) {
        
        PDF pdf = new PDF("/home/vitor/teste.pdf");
        pdf.open();
        pdf.setTitle("PDF - Viewer");
        pdf.setParagraph("Este é um arquivo qualquer de teste.");
        pdf.close();
        
    }
}
