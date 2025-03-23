package dev.dp.cdp.factory.DocProcAbstractFactory.parser;

import dev.dp.cdp.factory.DocProcAbstractFactory.DocumentType;

public class TextDocumentParser extends DocumentParser {

    public TextDocumentParser(String path) {
        super(path);
    }

    public void parseDocument() {
        // Parse text document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }
}
