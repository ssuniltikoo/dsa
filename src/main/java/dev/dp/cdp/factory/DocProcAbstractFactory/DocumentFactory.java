package dev.dp.cdp.factory.DocProcAbstractFactory;

import dev.dp.cdp.factory.DocProcAbstractFactory.parser.DocumentParser;
import dev.dp.cdp.factory.DocProcAbstractFactory.printer.DocumentPrinter;
import dev.dp.cdp.factory.DocProcAbstractFactory.processor.DocumentProcessor;

public abstract class DocumentFactory {
    public abstract DocumentType supportsType();
    public abstract DocumentParser createDocumentParser(String path);
    public abstract DocumentProcessor createDocumentProcessor(String name);
    public abstract DocumentPrinter createDocumentPrinter(DocumentProcessor processor);

//    public static DocumentFactory getFactory(DocumentType type,String name, String path) {
//        if(type.equals(DocumentType.SPREAD_SHEET)){
//            return new SpreadsheetDocumentFactory(name,path);
//        }
//        if(type.equals(DocumentType.TEXT)){
//            return new TextDocumentFactory();
//        }
//        throw new RuntimeException("Document type is not provided");
//
//    }

}
