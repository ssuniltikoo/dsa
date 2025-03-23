package dev.dp.cdp.factory.DocProcAbstractFactory;

import dev.dp.cdp.factory.DocProcAbstractFactory.parser.DocumentParser;
import dev.dp.cdp.factory.DocProcAbstractFactory.parser.TextDocumentParser;
import dev.dp.cdp.factory.DocProcAbstractFactory.printer.DocumentPrinter;
import dev.dp.cdp.factory.DocProcAbstractFactory.printer.TextDocumentPrinter;
import dev.dp.cdp.factory.DocProcAbstractFactory.processor.DocumentProcessor;
import dev.dp.cdp.factory.DocProcAbstractFactory.processor.TextDocumentProcessor;

public class TextDocumentFactory extends  DocumentFactory{


    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }

    @Override
    public DocumentParser createDocumentParser(String path) {
        return new TextDocumentParser(path);
    }

    @Override
    public DocumentProcessor createDocumentProcessor(String name) {
        return new TextDocumentProcessor(name);
    }

    @Override
    public DocumentPrinter createDocumentPrinter(DocumentProcessor processor) {
        return new TextDocumentPrinter(processor);
    }
}
