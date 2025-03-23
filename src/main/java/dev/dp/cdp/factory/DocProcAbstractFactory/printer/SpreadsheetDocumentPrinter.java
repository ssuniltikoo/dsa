package dev.dp.cdp.factory.DocProcAbstractFactory.printer;

import dev.dp.cdp.factory.DocProcAbstractFactory.DocumentType;
import dev.dp.cdp.factory.DocProcAbstractFactory.processor.DocumentProcessor;

public class SpreadsheetDocumentPrinter extends DocumentPrinter {

    public SpreadsheetDocumentPrinter(DocumentProcessor processor) {
        super(processor);
    }

    public void printDocument() {
        // Print spreadsheet document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }
}
