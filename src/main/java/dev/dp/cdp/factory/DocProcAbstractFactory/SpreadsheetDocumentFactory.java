package dev.dp.cdp.factory.DocProcAbstractFactory;

import dev.dp.cdp.factory.DocProcAbstractFactory.parser.DocumentParser;
import dev.dp.cdp.factory.DocProcAbstractFactory.parser.SpreadsheetDocumentParser;
import dev.dp.cdp.factory.DocProcAbstractFactory.printer.DocumentPrinter;
import dev.dp.cdp.factory.DocProcAbstractFactory.printer.SpreadsheetDocumentPrinter;
import dev.dp.cdp.factory.DocProcAbstractFactory.processor.DocumentProcessor;
import dev.dp.cdp.factory.DocProcAbstractFactory.processor.SpreadsheetDocumentProcessor;

public class SpreadsheetDocumentFactory  extends DocumentFactory{
    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }

    @Override
    public DocumentParser createDocumentParser(String path) {
        return new SpreadsheetDocumentParser(path);
    }

    @Override
    public DocumentProcessor createDocumentProcessor(String name) {
        return new SpreadsheetDocumentProcessor(name);
    }

    @Override
    public DocumentPrinter createDocumentPrinter(DocumentProcessor processor) {
        return new SpreadsheetDocumentPrinter(processor);
    }



}
