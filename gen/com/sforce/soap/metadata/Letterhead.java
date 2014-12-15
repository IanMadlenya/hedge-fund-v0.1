package com.sforce.soap.metadata;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class Letterhead extends com.sforce.soap.metadata.Metadata {

    /**
     * Constructor
     */
    public Letterhead() {}

    /**
     * element : available of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo available__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","available","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

    private boolean available__is_set = false;

    private boolean available;

    public boolean getAvailable() {
      return available;
    }

    public boolean isAvailable() {
      return available;
    }

    public void setAvailable(boolean available) {
      this.available = available;
      available__is_set = true;
    }

    /**
     * element : backgroundColor of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo backgroundColor__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","backgroundColor","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean backgroundColor__is_set = false;

    private java.lang.String backgroundColor;

    public java.lang.String getBackgroundColor() {
      return backgroundColor;
    }

    public void setBackgroundColor(java.lang.String backgroundColor) {
      this.backgroundColor = backgroundColor;
      backgroundColor__is_set = true;
    }

    /**
     * element : bodyColor of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo bodyColor__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","bodyColor","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean bodyColor__is_set = false;

    private java.lang.String bodyColor;

    public java.lang.String getBodyColor() {
      return bodyColor;
    }

    public void setBodyColor(java.lang.String bodyColor) {
      this.bodyColor = bodyColor;
      bodyColor__is_set = true;
    }

    /**
     * element : bottomLine of type {http://soap.sforce.com/2006/04/metadata}LetterheadLine
     * java type: com.sforce.soap.metadata.LetterheadLine
     */
    private static final com.sforce.ws.bind.TypeInfo bottomLine__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","bottomLine","http://soap.sforce.com/2006/04/metadata","LetterheadLine",1,1,true);

    private boolean bottomLine__is_set = false;

    private com.sforce.soap.metadata.LetterheadLine bottomLine;

    public com.sforce.soap.metadata.LetterheadLine getBottomLine() {
      return bottomLine;
    }

    public void setBottomLine(com.sforce.soap.metadata.LetterheadLine bottomLine) {
      this.bottomLine = bottomLine;
      bottomLine__is_set = true;
    }

    /**
     * element : description of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo description__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","description","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean description__is_set = false;

    private java.lang.String description;

    public java.lang.String getDescription() {
      return description;
    }

    public void setDescription(java.lang.String description) {
      this.description = description;
      description__is_set = true;
    }

    /**
     * element : footer of type {http://soap.sforce.com/2006/04/metadata}LetterheadHeaderFooter
     * java type: com.sforce.soap.metadata.LetterheadHeaderFooter
     */
    private static final com.sforce.ws.bind.TypeInfo footer__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","footer","http://soap.sforce.com/2006/04/metadata","LetterheadHeaderFooter",1,1,true);

    private boolean footer__is_set = false;

    private com.sforce.soap.metadata.LetterheadHeaderFooter footer;

    public com.sforce.soap.metadata.LetterheadHeaderFooter getFooter() {
      return footer;
    }

    public void setFooter(com.sforce.soap.metadata.LetterheadHeaderFooter footer) {
      this.footer = footer;
      footer__is_set = true;
    }

    /**
     * element : header of type {http://soap.sforce.com/2006/04/metadata}LetterheadHeaderFooter
     * java type: com.sforce.soap.metadata.LetterheadHeaderFooter
     */
    private static final com.sforce.ws.bind.TypeInfo header__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","header","http://soap.sforce.com/2006/04/metadata","LetterheadHeaderFooter",1,1,true);

    private boolean header__is_set = false;

    private com.sforce.soap.metadata.LetterheadHeaderFooter header;

    public com.sforce.soap.metadata.LetterheadHeaderFooter getHeader() {
      return header;
    }

    public void setHeader(com.sforce.soap.metadata.LetterheadHeaderFooter header) {
      this.header = header;
      header__is_set = true;
    }

    /**
     * element : middleLine of type {http://soap.sforce.com/2006/04/metadata}LetterheadLine
     * java type: com.sforce.soap.metadata.LetterheadLine
     */
    private static final com.sforce.ws.bind.TypeInfo middleLine__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","middleLine","http://soap.sforce.com/2006/04/metadata","LetterheadLine",1,1,true);

    private boolean middleLine__is_set = false;

    private com.sforce.soap.metadata.LetterheadLine middleLine;

    public com.sforce.soap.metadata.LetterheadLine getMiddleLine() {
      return middleLine;
    }

    public void setMiddleLine(com.sforce.soap.metadata.LetterheadLine middleLine) {
      this.middleLine = middleLine;
      middleLine__is_set = true;
    }

    /**
     * element : name of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo name__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","name","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean name__is_set = false;

    private java.lang.String name;

    public java.lang.String getName() {
      return name;
    }

    public void setName(java.lang.String name) {
      this.name = name;
      name__is_set = true;
    }

    /**
     * element : topLine of type {http://soap.sforce.com/2006/04/metadata}LetterheadLine
     * java type: com.sforce.soap.metadata.LetterheadLine
     */
    private static final com.sforce.ws.bind.TypeInfo topLine__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","topLine","http://soap.sforce.com/2006/04/metadata","LetterheadLine",1,1,true);

    private boolean topLine__is_set = false;

    private com.sforce.soap.metadata.LetterheadLine topLine;

    public com.sforce.soap.metadata.LetterheadLine getTopLine() {
      return topLine;
    }

    public void setTopLine(com.sforce.soap.metadata.LetterheadLine topLine) {
      this.topLine = topLine;
      topLine__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "http://soap.sforce.com/2006/04/metadata", "Letterhead");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeBoolean(__out, available__typeInfo, available, available__is_set);
       __typeMapper.writeString(__out, backgroundColor__typeInfo, backgroundColor, backgroundColor__is_set);
       __typeMapper.writeString(__out, bodyColor__typeInfo, bodyColor, bodyColor__is_set);
       __typeMapper.writeObject(__out, bottomLine__typeInfo, bottomLine, bottomLine__is_set);
       __typeMapper.writeString(__out, description__typeInfo, description, description__is_set);
       __typeMapper.writeObject(__out, footer__typeInfo, footer, footer__is_set);
       __typeMapper.writeObject(__out, header__typeInfo, header, header__is_set);
       __typeMapper.writeObject(__out, middleLine__typeInfo, middleLine, middleLine__is_set);
       __typeMapper.writeString(__out, name__typeInfo, name, name__is_set);
       __typeMapper.writeObject(__out, topLine__typeInfo, topLine, topLine__is_set);
    }

    @Override
    public void load(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __typeMapper.consumeStartTag(__in);
      loadFields(__in, __typeMapper);
      __typeMapper.consumeEndTag(__in);
    }

    protected void loadFields(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
        super.loadFields(__in, __typeMapper);
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, available__typeInfo)) {
            setAvailable(__typeMapper.readBoolean(__in, available__typeInfo, boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, backgroundColor__typeInfo)) {
            setBackgroundColor(__typeMapper.readString(__in, backgroundColor__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, bodyColor__typeInfo)) {
            setBodyColor(__typeMapper.readString(__in, bodyColor__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, bottomLine__typeInfo)) {
            setBottomLine((com.sforce.soap.metadata.LetterheadLine)__typeMapper.readObject(__in, bottomLine__typeInfo, com.sforce.soap.metadata.LetterheadLine.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, description__typeInfo)) {
            setDescription(__typeMapper.readString(__in, description__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, footer__typeInfo)) {
            setFooter((com.sforce.soap.metadata.LetterheadHeaderFooter)__typeMapper.readObject(__in, footer__typeInfo, com.sforce.soap.metadata.LetterheadHeaderFooter.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, header__typeInfo)) {
            setHeader((com.sforce.soap.metadata.LetterheadHeaderFooter)__typeMapper.readObject(__in, header__typeInfo, com.sforce.soap.metadata.LetterheadHeaderFooter.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, middleLine__typeInfo)) {
            setMiddleLine((com.sforce.soap.metadata.LetterheadLine)__typeMapper.readObject(__in, middleLine__typeInfo, com.sforce.soap.metadata.LetterheadLine.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, name__typeInfo)) {
            setName(__typeMapper.readString(__in, name__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, topLine__typeInfo)) {
            setTopLine((com.sforce.soap.metadata.LetterheadLine)__typeMapper.readObject(__in, topLine__typeInfo, com.sforce.soap.metadata.LetterheadLine.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[Letterhead ");
      sb.append(super.toString());sb.append(" available='").append(com.sforce.ws.util.Verbose.toString(available)).append("'\n");
      sb.append(" backgroundColor='").append(com.sforce.ws.util.Verbose.toString(backgroundColor)).append("'\n");
      sb.append(" bodyColor='").append(com.sforce.ws.util.Verbose.toString(bodyColor)).append("'\n");
      sb.append(" bottomLine='").append(com.sforce.ws.util.Verbose.toString(bottomLine)).append("'\n");
      sb.append(" description='").append(com.sforce.ws.util.Verbose.toString(description)).append("'\n");
      sb.append(" footer='").append(com.sforce.ws.util.Verbose.toString(footer)).append("'\n");
      sb.append(" header='").append(com.sforce.ws.util.Verbose.toString(header)).append("'\n");
      sb.append(" middleLine='").append(com.sforce.ws.util.Verbose.toString(middleLine)).append("'\n");
      sb.append(" name='").append(com.sforce.ws.util.Verbose.toString(name)).append("'\n");
      sb.append(" topLine='").append(com.sforce.ws.util.Verbose.toString(topLine)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}