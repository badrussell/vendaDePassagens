package br.univates.libraries;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe para gera PDF
 * 
 *  Usada para gerar pdf final com as informações da compra
 * 
 * @author vitor
 */
public class PDF
{
    //Diretório
    private String dir = "";
    
    //Objeto document de manipulação
    private Document document;
    
    /**
     * Contrutor com as configurações de inicialização
     * 
     * @param dir String Recebe o diretorio completo (com nome do arquivo)  
     */
    public PDF(String dir) 
    {
        this.dir = dir;
        this.document = new Document();
        try{
            PdfWriter.getInstance(this.document, new FileOutputStream(this.getDir()));
        }catch(Exception E){
          System.err.println(E.getMessage());
        }
    }

    /**
     * Abre a leitura do arquivo
     * 
     * @return Situação, se o arquivo foi aberto ou não com sucesso
     */
    public boolean open()
    {
        this.document.open();
        if (this.document.isOpen()) 
        {
            return true;
        }
        return false;
    }
    
    /**
     * Escreve um paragrafo dentro do PDF
     * 
     * 
     * @param text String recebe o texto que vai ser escrito
     */
    public void setParagraph(String text)
    {
        try {
            this.document.add(new Paragraph(text));
        } catch (DocumentException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Seta o título da página em PDF
     * 
     * @param title String com o titulo
     */
    public void setTitle(String title)
    {
        this.document.addTitle(title);
    }
    
    /**
     * Fecha o arquivo.
     * 
     * @return Boolean com a situação se foi ou não fechado com sucesso
     */
    public boolean close()
    {
        this.document.close();
        if (!this.document.isOpen()) 
        {
            return true;
        }
        return false;
    }
    
    /**
     * Retorna o diretório informado
     * 
     * @return String com o diretorio
     */
    public String getDir()
    {
        return this.dir;
    }
    
    /**
     * Pega o numero da pagina
     * 
     * @return int pagina
     */
    public int getNumPage()
    {
        return this.getNumPage();
    }
    
}