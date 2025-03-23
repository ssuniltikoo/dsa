package dev.dp.cdp.prototype.invoicegeneration;

 interface InvoicePrototypeRegistry {
    void addPrototype(Invoice user);

    Invoice getPrototype(InvoiceType type);

    Invoice clone(InvoiceType type);
}

