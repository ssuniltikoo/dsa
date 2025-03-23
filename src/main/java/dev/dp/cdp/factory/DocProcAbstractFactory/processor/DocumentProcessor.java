package dev.dp.cdp.factory.DocProcAbstractFactory.processor;

import dev.dp.cdp.factory.DocProcAbstractFactory.DocumentType;

public abstract class DocumentProcessor {
    private String documentName;

    public DocumentProcessor(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentName() {
        return documentName;
    }

    public abstract void processDocument();

    public abstract DocumentType supportsType();

}
