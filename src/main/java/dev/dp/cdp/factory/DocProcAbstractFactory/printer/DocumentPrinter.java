package dev.dp.cdp.factory.DocProcAbstractFactory.printer;

import dev.dp.cdp.factory.DocProcAbstractFactory.DocumentType;
import dev.dp.cdp.factory.DocProcAbstractFactory.processor.DocumentProcessor;

public abstract class DocumentPrinter {

    private final DocumentProcessor processor;

    public DocumentPrinter(DocumentProcessor processor) {
        this.processor = processor;
    }

    public DocumentProcessor getProcessor() {
        return processor;
    }

    public abstract void printDocument();

    public abstract DocumentType supportsType();

}
