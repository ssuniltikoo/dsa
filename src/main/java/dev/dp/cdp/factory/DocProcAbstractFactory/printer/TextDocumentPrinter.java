package dev.dp.cdp.factory.DocProcAbstractFactory.printer;

import dev.dp.cdp.factory.DocProcAbstractFactory.DocumentType;
import dev.dp.cdp.factory.DocProcAbstractFactory.processor.DocumentProcessor;

public class TextDocumentPrinter extends DocumentPrinter {

    public TextDocumentPrinter(DocumentProcessor processor) {
        super(processor);
    }

    public void printDocument() {
        // Print text document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }
}