package dev.dp.cdp.factory.DocProcAbstractFactory.parser;


import dev.dp.cdp.factory.DocProcAbstractFactory.DocumentType;

public abstract class DocumentParser {

    private final String path;

    public DocumentParser(String path) {
        this.path = path;
    }



    public abstract void parseDocument();

    public String getPath() {
        return path;
    }

    public abstract DocumentType supportsType();

}
