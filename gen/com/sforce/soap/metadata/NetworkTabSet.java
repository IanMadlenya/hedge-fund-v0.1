package com.sforce.soap.metadata;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class NetworkTabSet implements com.sforce.ws.bind.XMLizable {

    /**
     * Constructor
     */
    public NetworkTabSet() {}

    /**
     * element : customTab of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String[]
     */
    private static final com.sforce.ws.bind.TypeInfo customTab__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","customTab","http://www.w3.org/2001/XMLSchema","string",0,-1,true);

    private boolean customTab__is_set = false;

    private java.lang.String[] customTab = new java.lang.String[0];

    public java.lang.String[] getCustomTab() {
      return customTab;
    }

    public void setCustomTab(java.lang.String[] customTab) {
      this.customTab = customTab;
      customTab__is_set = true;
    }

    /**
     * element : defaultTab of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo defaultTab__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","defaultTab","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean defaultTab__is_set = false;

    private java.lang.String defaultTab;

    public java.lang.String getDefaultTab() {
      return defaultTab;
    }

    public void setDefaultTab(java.lang.String defaultTab) {
      this.defaultTab = defaultTab;
      defaultTab__is_set = true;
    }

    /**
     * element : standardTab of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String[]
     */
    private static final com.sforce.ws.bind.TypeInfo standardTab__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","standardTab","http://www.w3.org/2001/XMLSchema","string",0,-1,true);

    private boolean standardTab__is_set = false;

    private java.lang.String[] standardTab = new java.lang.String[0];

    public java.lang.String[] getStandardTab() {
      return standardTab;
    }

    public void setStandardTab(java.lang.String[] standardTab) {
      this.standardTab = standardTab;
      standardTab__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       __typeMapper.writeObject(__out, customTab__typeInfo, customTab, customTab__is_set);
       __typeMapper.writeString(__out, defaultTab__typeInfo, defaultTab, defaultTab__is_set);
       __typeMapper.writeObject(__out, standardTab__typeInfo, standardTab, standardTab__is_set);
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
        __in.peekTag();
        if (__typeMapper.isElement(__in, customTab__typeInfo)) {
            setCustomTab((java.lang.String[])__typeMapper.readObject(__in, customTab__typeInfo, java.lang.String[].class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, defaultTab__typeInfo)) {
            setDefaultTab(__typeMapper.readString(__in, defaultTab__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, standardTab__typeInfo)) {
            setStandardTab((java.lang.String[])__typeMapper.readObject(__in, standardTab__typeInfo, java.lang.String[].class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[NetworkTabSet ");
      sb.append(" customTab='").append(com.sforce.ws.util.Verbose.toString(customTab)).append("'\n");
      sb.append(" defaultTab='").append(com.sforce.ws.util.Verbose.toString(defaultTab)).append("'\n");
      sb.append(" standardTab='").append(com.sforce.ws.util.Verbose.toString(standardTab)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}